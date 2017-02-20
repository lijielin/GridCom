package com.inc.gtc.fire.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-27 下午03:23:57
 */
public class MessageUtils {
	public final static  String heartbeat = "heartbeat";
	public final static  String connect = "connect";
	public final static  String requestConnect = "Ask For connect";
	public final static  String get = "get";
	/**温度*/
	public static final String DATA_CODE_TEMP = "01";
	/**电压*/
	public static final String DATA_CODE_VOLTAGE = "02";
	public static final String DATA_CODE_REPLY = "193";
	public static final String DATA_NAME_REPLY = "回复";
	/***森林防火相关常量*/
	/***火灾预警*/
	public static final String DATA_CODE_FIRE = "176";
	public static final String DATA_NAME_FIRE = "火灾预警";
	public static final String DATA_MESSAGE_FIRE = "火灾预警！";
	
	/***电池预警*/
	public static final String DATA_CODE_BATTERY = "178";
	public static final String DATA_NAME_BATTERY = "电池预警";
	public static final String DATA_MESSAGE_BATTERY = "电池耗尽预警！请及时更换！";
	/***盗取预警*/
	public static final String DATA_CODE_STEAL = "177";
	public static final String DATA_NAME_STEAL = "摘取预警";
	public static final String DATA_MESSAGE_STEAL = "发出摘取预警！请前往查看是否被摘取！";
	/***盗林预警*/
	public static final String DATA_CODE_FOREST = "179";
	public static final String DATA_NAME_FOREST = "盗林预警";
	public static final String DATA_MESSAGE_FOREST = "盗林预警！请前往查看是否有人盗林或盗猎！";
	/***虫灾预警*/
	public static final String DATA_CODE_WORM = "180";
	public static final String DATA_NAME_WORM = "虫灾预警";
	public static final String DATA_MESSAGE_WORM = "虫灾预警！请前往查看是否有虫灾！";
	/**固定长度测试类*/
	public static final String DATA_CODE_E0 = "224";
	public static final String DATA_NAME_E0 = "固定长度测试类";
	public static final String DATA_MESSAGE_E0 = "固定长度测试类。";
	/**可变长度测试类*/
	public static final String DATA_CODE_E1 = "225";
	public static final String DATA_NAME_E1 = "可变长度测试类";
	public static final String DATA_MESSAGE_E1 = "可变长度测试类。";
		

	/**代号信息Map k code v message*/
	public static Map<String,String> DATA_CODE_MESSAGE_MAP = new HashMap<String,String>();
	static{
		/***火灾预警*/
		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_FIRE, DATA_MESSAGE_FIRE);
		/***电池预警*/
		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_BATTERY, DATA_MESSAGE_BATTERY);
		/***盗取预警*/
		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_STEAL, DATA_MESSAGE_STEAL);
		/***盗林预警*/
//		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_FOREST, DATA_MESSAGE_FOREST);
//		/***虫灾预警*/
//		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_WORM, DATA_MESSAGE_WORM);
//		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_E0, DATA_MESSAGE_E0);
//		DATA_CODE_MESSAGE_MAP.put(DATA_CODE_E1, DATA_MESSAGE_E1);
	}
	/**[回车][换行]*/
	public static String TAG_SPLIT = "\r\n";
	public static String TAG_SPLIT_R = "\r";
	public static String TAG_SPLIT_N = "\n";
	/**
	 * 解析格式串短信
	 * @param message 格式为 "M=86230002[回车][换行]S=00000060[回车][换行]D=176" 
	 * 或者 "M=86230002[回车][换行]S=00000060[回车][换行]CD=[B0|B1|B2][回车][换行]D=00170[回车][换行]CR=130"
	 * CR序号 CD同第一种的D,是十六进制数，B0为火，D表示火势 B1时D表示温度，B2时表示电压
	 * @return 返回一个三元组对象，第一个为M的值，第二个为S的值，第三个为D值
	 * */
	public static Map<String,String> parseMessage(String message) {
		Map<String,String> map = new HashMap<String,String>();
//		List<String> list = StringUtils.stringToArrayList(message, TAG_SPLIT);
//		for(String str : list){
//			if(str.indexOf("=") > -1){
//				int index = str.indexOf("=");
//				String key = str.substring(0,index);
//				String value = str.substring(index + 1,str.length());
//				if("CD".equals(key)){// || "CLASS".equals(key) || "D".equals(key)
//					value = String.valueOf(Integer.parseInt(value, 16));
//				}
//				map.put(key, value);
//			}
//		}
		if(message.indexOf("M=") >= 0 && message.indexOf("S=") >= 0 && message.indexOf("CD=") >= 0
				&& message.indexOf("D=") >= 0 && message.indexOf("CLASS=") >= 0 && message.indexOf("CR=") >= 0){
			int indexM,indexS,indexCd,indexD,indexClass,indexCr;
			indexM = message.indexOf("M=");
			indexS = message.indexOf("S=");
			indexCd = message.indexOf("CD=");
			indexD = message.indexOf("D=",indexCd + 2);
			indexClass = message.indexOf("CLASS=");
			indexCr = message.indexOf("CR=");
			String valueM = message.substring(indexM + "M=".length(),indexS).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueS = message.substring(indexS + "S=".length(),indexCd).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueCd = message.substring(indexCd + "CD=".length(),indexD).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueD = message.substring(indexD + "D=".length(),indexClass).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueClass = message.substring(indexClass + "CLASS=".length(),indexCr).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueCr = message.substring(indexCr + "CR=".length(),message.length()).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			valueCd = String.valueOf(Integer.parseInt(valueCd, 16));
			map.put("M", valueM);
			map.put("S", valueS);
			map.put("CD", valueCd);
			map.put("D", valueD);
			map.put("CLASS", valueClass);
			map.put("CR", valueCr);
//			System.out.println(valueM);
//			System.out.println(valueS);
//			System.out.println(valueCd);
//			System.out.println(valueD);
//			System.out.println(valueClass);
//			System.out.println(valueCr);
		}
		else if(message.indexOf("M=") >= 0 && message.indexOf("S=") >= 0 && message.indexOf("CD=") >= 0
				&& message.indexOf("D=") >= 0 && message.indexOf("CR=") >= 0){
			int indexM,indexS,indexCd,indexD,indexCr;
			indexM = message.indexOf("M=");
			indexS = message.indexOf("S=");
			indexCd = message.indexOf("CD=");
			indexD = message.indexOf("D=",indexCd + 2);
			indexCr = message.indexOf("CR=");
			String valueM = message.substring(indexM + "M=".length(),indexS).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueS = message.substring(indexS + "S=".length(),indexCd).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueCd = message.substring(indexCd + "CD=".length(),indexD).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueD = message.substring(indexD + "D=".length(),indexCr).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueCr = message.substring(indexCr + "CR=".length(),message.length()).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			valueCd = String.valueOf(Integer.parseInt(valueCd, 16));
			map.put("M", valueM);
			map.put("S", valueS);
			map.put("CD", valueCd);
			map.put("D", valueD);
			map.put("CR", valueCr);
		}
		else if(message.indexOf("M=") >= 0 && message.indexOf("S=") >= 0 && message.indexOf("D=") >= 0 ){
			int indexM,indexS,indexD;
			indexM = message.indexOf("M=");
			indexS = message.indexOf("S=");
			indexD = message.indexOf("D=");
			String valueM = message.substring(indexM + "M=".length(),indexS).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueS = message.substring(indexS + "S=".length(),indexD).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			String valueD = message.substring(indexD + "D=".length(),message.length()).replaceAll(TAG_SPLIT, "").replaceAll(TAG_SPLIT_R, "").replaceAll(TAG_SPLIT_N, "").trim();
			map.put("M", valueM);
			map.put("S", valueS);
			map.put("D", valueD);
//			System.out.println(valueM);
//			System.out.println(valueS);
//			System.out.println(valueD);
		}
//		System.out.println("parseMessage..." + message);
//		0035(000-00:01:30):
//			M=86230035
//			S=02301
//			CD=E0
//			D=01 01
//			CLASS=22 B8
//			CR=094
		
		
		return map;
	}
	
	/**
	 * 得到字符串的最后几位
	 * */
	public static String getLastChar(String message,int bit){
		return message.substring(message.length() - bit,message.length());
	}
	/**
	 * "0035(000-00:00:33):\r\nIP :192.168.000.113\r\nSN :255.255.255.000\r\nGW :192.168.000.001"
	 * 根据传过来的字符串判断注册信息是否合法
	 */
	public static Boolean regMsgParse(String str) {
		return (str.indexOf("IP") >= 0) && (str.indexOf("SN") >= 0)
				&& (str.indexOf("GW") >= 0);
	}

	/**
	 * "0035(000-00:00:33):\r\nIP :192.168.000.113\r\nSN :255.255.255.000\r\nGW :192.168.000.001"
	 * 根据传过来的字符串解析出基站编号
	 */
	public static String parseRegCode(String str) {
		str = str.substring(0, str.indexOf("("));
		return str;
	}
	
	/**
	 * "0035(000-00:00:33):\r\nIP :192.168.000.113\r\nSN :255.255.255.000\r\nGW :192.168.000.001"
	 * 根据传过来的字符串解析出基站编号后面的数据，是为实际的信息
	 */
	public static String parseRealData(String str) {
		str = str.substring(str.indexOf("):") + 2,str.length());
		return str;
	}

	/**
	 * "0035(000-00:00:33):\r\nIP :192.168.000.113\r\nSN :255.255.255.000\r\nGW :192.168.000.001"
	 * 根据传过来的字符串解析出基站在线时间（准确的说应该是基站开机时间）
	 */
	public static String parseOnlineTime(String str) {
		str = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
		return str;
	}
	
	/**
	 * 
	 * 根据传过来的字符串解析是否是心跳串
	 */
	public static Boolean parseHeartbeat(String str) {
		return str.length() == 2;
	}
	
	/**
	 * M=86230012\r\nS=00000221\r\nCD=B0\r\nD=176\r\nCR=001
	 * 解析是否为报警信息
	 */
	public static Boolean parseAlarm(String str) {
		return (str.indexOf("M=") >= 0) && (str.indexOf("S=") >= 0)
			&& (str.indexOf("CD=") >= 0);
	}
	
	/**
	 * Data数据域
	 * 该区域表示火焰大小趋势，共2个字节包含8次等级记录，每两位转换成十进制表示一个火焰等级，
	 * 分为(0.1.2.3)四种等级；0等级最低，表明火焰幅度比较小；3等级最高，幅度较大；通过八次火焰等级的变化趋势，判断火焰燃烧情况趋势。
	 * 举例：D=16 BF
	 * 分解成2进制  ：D= 0001 0110 1011 1111
	 * 转化成火焰等级：    0 1  1 2  2 3  3 3
	 * 说明：根据这8个连续的火焰等级记录，可断定相对火势变大。
	 */
	public static String parseFireGrade(String data) {
		String sRet = "";
		data = data.replaceAll(" ", "");
		DecimalFormat df = new DecimalFormat();
		String style = "0000";
		df.applyPattern(style);
		String sBinary = "";
		//把16进制数转成2进制数，一个十六进制数用四位二进制数表示，不足四位用0补齐
		for(int i = 0 ; i < data.length() ; i++){
			String tmp = Integer.toBinaryString(Integer.valueOf(String.valueOf(data.charAt(i)),16));
//			System.out.println(String.format("%4d", Integer.parseInt(tmp)));
			sBinary += df.format(Integer.parseInt(tmp));
		}
		//把二进制数转成十进制，每二位二进制数表示一个十进制数
		char[] arr = sBinary.toCharArray();
		int len = arr.length / 2;
		for(int i = 0 ; i < len ; i++){
			sRet = sRet + Integer.valueOf(String.valueOf(arr, i * 2, 2), 2) + " ";
		}
		return sRet;
	}
	/**
	 * Data数据域
	 * 该区域表示探测器内部温度，精度为0.5℃，范围为±64℃；共2个字节，
	 * 高字节在前，低字节在后。8位的原始数据位于低字节中，需网关重新计算处理。
	 * 按照公式：Temp = Value x 0.5 – 64 (单位-℃)
	 * 举例：D=00 C2
	 * 转换成10进制  ：D= 0 194
	 * 套用公式： 194 x 0.5 – 64 = 33
	 * 说明：计算结果为33.0℃
	 */
	public static double parseTheftTemperature(String data){
		String[] arr  = data.split(" ");
		int value = 0;
		if(arr.length >= 2){
			value = Integer.valueOf(arr[1],16);
		}
//		for(String s : arr){
//			value += Integer.valueOf(s,16);
//		}
		return value * 0.5 - 64;
	}
	/**
	 * Data数据域
	 * 该区域表示探测器电池电压，精度为0.05V，
	 * 范围为1.7V到3.2V；共2个字节，高字节在前，低字节在后。
	 * 5位的原始数据位于低字节中，需网关重新计算处理。
	 * 按照公式：V = 0.05* Value + 1.7 (单位-V)
	 */
	public static double parseVoltage(String data){
		String[] arr  = data.split(" ");
		int value = 0;
		if(arr.length >= 2){
			value = Integer.valueOf(arr[1],16);
		}
//		for(String s : arr){
//			value += Integer.valueOf(s,16);
//		}
		return 0.05 * value + 1.7;
	}
	/**
	 * e0时data高位取值为00 01 02 03 10五项，
	 * 00 时data低位为天数，class高位为小时，低位为温度
	 * 01 时data低位为小时，class高位为分钟，低位为温度
	 * 02 时data低位为天数，class高位为小时，低位为电压
	 * 03 时data低位为小时，class高位为分钟，低位为电压
	 * 10 时data低位为天数，class高位为小时，低位为分钟 RF突发异常
	 * D=01 01
	 * CLASS=22 B8
	 * */
	public static String parseDetailE0(String d,String glass){
		String[] arrD = d.split(" ");
		String[] arrGlass = glass.split(" ");
		String detail = "";
		//00 01 02 03 10
		//2301号探测器-每分钟温度测试-1小时34分-温度为28.0℃
		if("00".equals(arrD[0])){
			//天
			int tmp1 = Integer.valueOf(arrD[1],16);
			//小时
			int tmp2 = Integer.valueOf(arrGlass[0],16);
			detail = "每小时温度测试-" + tmp1 + "天" + tmp2 + "小时-" + parseTheftTemperature(glass) + "℃";
		}else if("01".equals(arrD[0])){
			//小时
			int tmp1 = Integer.valueOf(arrD[1],16);
			//分
			int tmp2 = Integer.valueOf(arrGlass[0],16);
			detail = "每分钟温度测试-" + tmp1 + "小时" + tmp2 + "分-" + parseTheftTemperature(glass) + "℃";
		}else if("02".equals(arrD[0])){
			//天
			int tmp1 = Integer.valueOf(arrD[1],16);
			//小时
			int tmp2 = Integer.valueOf(arrGlass[0],16);
			detail = "每小时电压测试-" + tmp1 + "天" + tmp2 + "小时-" + parseVoltage(glass) + "V";
		}else if("03".equals(arrD[0])){
			//小时
			int tmp1 = Integer.valueOf(arrD[1],16);
			//分
			int tmp2 = Integer.valueOf(arrGlass[0],16);
			detail = "每分钟电压测试-" + tmp1 + "小时" + tmp2 + "分-" + parseVoltage(glass) + "V";
		}else if("10".equals(arrD[0])){
			//天
			int tmp1 = Integer.valueOf(arrD[1],16);
			//小时
			int tmp2 = Integer.valueOf(arrGlass[0],16);
			detail = " RF突发异常-" + tmp1 + "天" + tmp2 + "小时-" + Integer.valueOf(arrGlass[1],16) + "分";
		}
		return detail;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Double d = 1.0000000000000002;
//		System.out.println(Math.acos(d));
//		d = Math.acos(d) * 6378137d;
//		System.out.println("NaN".equals(d.toString()));
//		System.out.println(MessageUtils.parseFireGrade("16 BF"));
		System.out.println(MessageUtils.parseTheftTemperature("01 B9"));
//		System.out.println(MessageUtils.parseVoltage("00 1E"));
//		String message = "0035(000-00:01:30):\r\nM=86230035\r\nS=02301\r\nD=01 01";
//		String message = "0035(000-00:01:30):\r\nM=86230035\r\nS=02301\r\nCD=E0\r\nD=01 01\r\nCLASS=22 B8\r\nCR=094";
//		Map<String, String> map = MessageUtils.parseMessage(message);
//		System.out.println(map.size());
//		System.out.println(MessageUtils.parseRealData(message));
//		try {
//			System.out.println(MessageUtils.getLastTwoChar(message));
////			System.out.println(Integer.valueOf("B0",16));
//			MessageUtils.parseMessage(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String a = "INC_TZJ: M=86230035";
//		System.out.println(a.substring(a.indexOf("M="),a.length()));
//		System.out.println(MessageUtils.regMsgParse("0035(000-00:00:33):\r\nIP :192.168.000.113\r\nSN :255.255.255.000\r\nGW :192.168.000.001"));
	}

}
