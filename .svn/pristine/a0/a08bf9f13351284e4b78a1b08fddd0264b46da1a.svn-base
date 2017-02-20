package com.inc.gtc.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gm.domain.task.PointNode;
import com.inc.gm.service.task.PointNodeService;
import com.inc.gmgrid.db.DbToken;
import com.inc.gtc.context.AppContext;
import com.inc.gtc.db.DbConfig;
import com.inc.gtc.db.DbCreator;
import com.inc.gtc.domain.Manager;
import com.inc.gtc.domain.PtNode;
import com.inc.gtc.domain.SysTask;
import com.inc.gtc.domain.Unit;
import com.inc.gtc.domain.UserIndex;
import com.inc.gtc.err.MigrateException;
import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.domain.User;
import com.inc.gtc.fire.service.BaseStationService;
import com.inc.gtc.fire.service.DistrictService;
import com.inc.gtc.fire.service.FireSensorService;
import com.inc.gtc.fire.service.UserService;
import com.inc.gtc.fire.util.GsonUtils;
import com.inc.gtc.service.ManagerService;
import com.inc.gtc.service.MigrateService;
import com.inc.gtc.service.PtNodeService;
import com.inc.gtc.service.SysTaskService;
import com.inc.gtc.service.UnitService;
import com.inc.gtc.service.UserIndexService;
import com.inc.yun.cfg.ConfigContext;
import com.inc.yun.util.FileUtils;
import com.itc.util.EncryptUtils;

/**
 * 数据迁移service
 * @author inc.courser
 *
 */
@Service("migrateService")
public class MigrateServiceImpl implements MigrateService {
	
	private static final Logger logger = Logger.getLogger(MigrateServiceImpl.class);
	private String CODE_PREFIX="gm_";
	
	public String CONFIG_DB_SERVER = "db.server";
	public String CONFIG_DB_USER = "db.user";
	public String CONFIG_DB_PWD = "db.pwd";
	public String CONFIG_DB_PORT = "db.port";
	public String CONFIG_DB_DBNAME = "db.dbname";
	
	@Autowired
	private AppContext appContext;
	
	@Autowired
	private UnitService unitService;
	
	@Autowired
	private SysTaskService taskService;
	
	@Autowired
	private DbCreator dbCreator;
	
	@Autowired
	private PtNodeService ptNodeService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private UserService userService;
	
	@Resource(name="gmUserService")
	private com.inc.gm.service.sys.UserService gmUserService;
	
	@Autowired
	private UserIndexService userIndexService;
	
	@Autowired
	private BaseStationService stationService;
	
	@Autowired
	private FireSensorService sensorService;
	
	@Autowired
	private PointNodeService pointNodeService;
	
	@Override
	public void executeTask(SysTask task) {
		try
		{
			task.setExecuteTime(Calendar.getInstance().getTimeInMillis());
			if (task.getType()==SysTask.TASKTYPE_CREATEDB)
			{
				Unit unit = null;
				try
				{
					unit = unitService.get(task.getUnit_id());
					createDb(unit);
					task.setResult(SysTask.RESULT_SUCCESS);
				}
				catch (Exception e)
				{
					logger.error(e);
					e.printStackTrace();
					task.setResult(SysTask.RESULT_ERROR);
					task.setErrorInfo(e.getMessage());
				}
				if (StringUtils.isNotBlank(task.getParam()))
				{
					Map<String,Object> data = GsonUtils.convertFromJson(task.getParam());
					Manager manager = new Manager();
					manager.setEmail((String)data.get("email"));
					manager.setTel((String)data.get("tel"));
					manager.setPwd(EncryptUtils.MD5((String)data.get("pwd")));
					manager.setUnit(unit.getCode());
					manager.setLoginname(unit.getCode()+"Manager");
					managerService.save(manager);
				}
			}
			else if (task.getType()==SysTask.TASKTYPE_MIGRATE && StringUtils.isNotBlank(task.getParam()))
			{
				this.migrateDistrict(task.getParam());
			}
			taskService.save(task);
		}
		catch(Exception e)
		{
			task.setResult(SysTask.RESULT_ERROR);
			task.setErrorInfo(e.getMessage());
			taskService.save(task);
			e.printStackTrace();
			throw new MigrateException(e);
		}
	}
	
	
	public void createDb(Unit unit)
	{
		DbConfig cfg = new DbConfig("com.mysql.jdbc.Driver",ConfigContext.getProperty(CONFIG_DB_SERVER)
				,Integer.valueOf(ConfigContext.getProperty(CONFIG_DB_PORT)),ConfigContext.getProperty(CONFIG_DB_USER)
				,ConfigContext.getProperty(CONFIG_DB_PWD),ConfigContext.getProperty(CONFIG_DB_DBNAME));
		dbCreator.createDb(cfg, unit.getDbName(),"UTF-8", new File(FileUtils.getDirectoryPath(appContext.getAppDirectory(),"/sql"),"mysql.sql"));
		
	}
	
	
	
	public void migrateDistrict(String districtCode)
	{
		try
		{
			/**
			 * 导入地区
			 */
			District district = districtService.findDistrictByCode(districtCode);
			if (district!=null)
			{
				Unit unit = unitService.findByCode(districtCode);
				if (unit==null)
				{
					unit = new Unit();
					unit.setCode(districtCode);
					unit.setName(district.getName());
					unit.setDbName(CODE_PREFIX+districtCode);
					unit.setDbPwd(ConfigContext.getProperty(CONFIG_DB_PWD));
					unit.setDbUrl(ConfigContext.getProperty(CONFIG_DB_SERVER));
					unit.setDbUser(ConfigContext.getProperty(CONFIG_DB_USER));
					unit.setLng(district.getLng());
					unit.setLat(district.getLat());
					unitService.save(unit);
					createDb(unit);
				}
				importData(district,unit);
			}
			else
			{
				throw new MigrateException("Null District");
			}
		}
		catch (Exception e)
		{
			logger.error(e);
			e.printStackTrace();
		}
	}

	private void importData(District district,Unit unit) throws Exception
	{
		DbToken.set(unit.getCode());
		try
		{
			importUser(district,unit);
			Map<String,PointNode> nodes = importBaseStation(district,unit);
			importSensor(nodes,district,unit);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			DbToken.set(null);
		}
	}
	/**
	 * 导入用户
	 */
	private void importUser(District district,Unit unit)
	{
		userIndexService.removeUnitUser(unit.getCode());
		gmUserService.removeAllUser();
		Collection<User> users = this.userService.getDistrictRangerUsers(district);
		for (User user : users)
		{
			com.inc.gm.domain.sys.User gu = new com.inc.gm.domain.sys.User();
			gu.setType(0);
			gu.setSync(com.inc.gm.domain.sys.User.SYNC_NOT);
			if (StringUtils.isNotBlank(user.getLoginCode())
					 && (StringUtils.isNotBlank(user.getEmail()) ||StringUtils.isNotBlank(user.getTelephone())  ))
			{
				if (userIndexService.findIndex(user.getEmail(), user.getCode())!=null)
				{
					gu.setSync(com.inc.gm.domain.sys.User.SYNC_ERROR);
				}
				else
				{
					gu.setSync(com.inc.gm.domain.sys.User.SYNC_SUCCESS);
					UserIndex index = new UserIndex();
					index.setPhone(user.getTelephone());
					index.setEmail(user.getEmail());
					index.setUnit(unit.getCode());
					userIndexService.save(index);
					gu.setType(com.inc.gm.domain.sys.User.TYPE_OPER);
					if (StringUtils.isNotBlank(user.getPassword()))
					{
						gu.setPwd(EncryptUtils.MD5(user.getPassword()));
					}
				}
			}
			gu.setPhone(user.getTelephone());
			gu.setEmail(user.getEmail());
			gu.setRealName(user.getName());
			gu.setName(user.getName());
			if (user.getIsRanger()!=null && user.getIsRanger()>0 && user.getSmsGrade()!=null
					&& user.getSmsGrade()>0)
			{
				gu.setType(gu.getType()| com.inc.gm.domain.sys.User.TYPE_RECEIVER);
			}
			gmUserService.save(gu);
		}
	}
	
	/**
	 * 导入基站
	 * @param district
	 * @param unit
	 */
	private Map<String,PointNode> importBaseStation(District district,Unit unit)
	{
		this.ptNodeService.removeUnitNode(unit.getCode());
		this.pointNodeService.removeNodes(PointNode.NODE_TYPE_FS);
		this.pointNodeService.removeNodes(PointNode.NODE_TYPE_BASESTATION);
		Map<String,PointNode> rs = new HashMap<String,PointNode>();
		Long nt = Calendar.getInstance().getTimeInMillis();
		Collection<BaseStation> stations = this.stationService.findStation(district);
		for (BaseStation station : stations)
		{
			if (StringUtils.isNotBlank(station.getNumber()))
			{
				PointNode node = new PointNode();
				node.setId("station_"+station.getId());
				node.setCreateTime(nt);
				node.setLat(station.getLat());
				node.setLng(station.getLng());
				node.setNumber(station.getNumber().trim());
				node.setName(station.getNumber().trim());
				node.setAddress(station.getAddress());
				node.setPhone(station.getTelephone());
				node.setType(PointNode.NODE_TYPE_BASESTATION);
				this.pointNodeService.save(node);
				rs.put(node.getNumber(),node);
				
				this.ptNodeService.save(new PtNode(node.getPhone(),unit.getCode()));
			}
		}
		return rs;
	}
	
	/**
	 * 导入探测器
	 */
	private void importSensor(Map<String,PointNode> nodes,District district,Unit unit)
	{
		this.pointNodeService.removeNodes(PointNode.NODE_TYPE_FS);
		Long nt = Calendar.getInstance().getTimeInMillis();
		Collection<FireSensor> sensors = this.sensorService.findSensors(district);
		String addr = null;
		for (FireSensor sensor : sensors)
		{
			addr = null;
			if (StringUtils.isNotBlank(sensor.getBasestationnumber()) &&
					nodes.containsKey(sensor.getBasestationnumber()))
			{
				PointNode node = new PointNode();
				node.setId("sensor"+sensor.getId());
				node.setParent(nodes.get(sensor.getBasestationnumber()));
				node.setCreateTime(nt);
				node.setLat(sensor.getLat());
				node.setLng(sensor.getLng());
				node.setAddress(sensor.getAddress());
				node.setNumber(sensor.getNumber().trim());
			
				if (sensor.getArea()!=null && sensor.getArea().length()>0)
				{
					addr=(addr!=null)?addr+sensor.getArea():sensor.getArea();
				}
				if (sensor.getPart()!=null && sensor.getPart().length()>0)
				{
					addr=(addr!=null)?addr+sensor.getPart():sensor.getPart();
				}
				node.setAddress(addr);
				if (sensor.getShowNo()!=null)
				{
					node.setName(sensor.getShowNo().toString());
				}
				else
				{
					node.setName(sensor.getNumber().trim());
				}
				node.setType(PointNode.NODE_TYPE_FS);

				this.pointNodeService.save(node);
			}
		}
	}
	
	

}
