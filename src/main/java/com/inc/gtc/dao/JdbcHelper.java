package com.inc.gtc.dao;

import java.sql.ResultSet;
import java.util.Calendar;

public class JdbcHelper {

	public static Object getItemVal(ResultSet rs,int col) throws Exception
	{
		int type = rs.getMetaData().getColumnType(col);
		switch(type)
		{
			case java.sql.Types.VARCHAR:return rs.getString(col);
			case java.sql.Types.INTEGER:return rs.getInt(col);
			case java.sql.Types.DATE:return rs.getDate(col);
			case java.sql.Types.FLOAT:return rs.getFloat(col);
			case java.sql.Types.DOUBLE:return rs.getDouble(col);
			case java.sql.Types.TIMESTAMP:
				{
					if (rs.getTimestamp(col)!=null)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTimeInMillis(rs.getTimestamp(col).getTime());
						return cal.getTime();
					}
					else
					{
						return null;
					}
				}
		}
		return null;
	}
}
