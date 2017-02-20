package com.inc.gtc.fire.util;


import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 工具箱
 *     
 * @author: inc.tzj 
 */
public class StringUtils {
	/**
	 * 解析字符串是否为查询余额短信
	 * */
	public static boolean isBalanceMatcher(String s){
		  String reg = "余额为[0-9\\.]+|余额：[0-9\\.]+";
		  Pattern p = Pattern.compile(reg);
		  Matcher m = p.matcher(s);
		  if((s != null)&&(s!=""))
			    return m.find();
			   else
			    return false;
	}
	
	/**
	 * 解析字符串得出话费余额
	 * */
	public static String findBalanceMatcher(String s){
		  String strR = "[0-9\\.]+";
		  String reg = "余额为[0-9\\.]+|余额：[0-9\\.]+";
		  Pattern p = Pattern.compile(reg);
		  Matcher m = p.matcher(s);
		  if(m.find()){
			  String tmp = m.group();
			  Pattern p2 = Pattern.compile(strR);
			  Matcher m2 = p2.matcher(tmp);
			  m2.find();
			  return m2.group();
		  }else{
			  return null;
		  }
	}
	
	public static boolean isNumeric(String s)
	{
	   if((s != null)&&(s!=""))
	    return s.matches("^[0-9]*$");
	   else
	    return false;
	}
	/**
	 * UNICODE 转换字符串
	 * @param str
	 * @return
	 */
	public static String decodeUnicode(String str)
	{
		str = str.trim();
		 char[] cb = new char[4];
		 StringBuffer buf = new StringBuffer();  
		 for (int i=0;i<str.length();)
		 {
			 try
			 {
				cb[0]=str.charAt(i++);
			 	cb[1]=str.charAt(i++);
			 	cb[2]=str.charAt(i++);
			 	cb[3]=str.charAt(i++);
			 	buf.append(convertUnicodeChar(cb));
			 }
			 catch (Exception e)
			 {
				 e.printStackTrace();
				 return str;
			 }
		 }
		 return buf.toString();
	}
	
	public static char convertUnicodeChar(char[] arg)
	{
		int v = 0;
        for (int i = 0; i < 4; i++) {      
        	 switch (arg[i]) {      

             case '0':      

             case '1':      

             case '2':      

             case '3':      

             case '4':      

             case '5':      
           
                 case '6':      
                  case '7':      
                  case '8':      
                  case '9':      
                    v = (v << 4) + arg[i] - '0';      
                   break;      
                  case 'a':      
                  case 'b':      
                  case 'c':      
                  case 'd':      
                  case 'e':      
                  case 'f':      
                   v = (v << 4) + 10 + arg[i] - 'a';      
                  break;      
                  case 'A':      
                  case 'B':      
                  case 'C':      
                  case 'D':      
                  case 'E':      
                  case 'F':      
                   v = (v << 4) + 10 + arg[i] - 'A';      
                   break;      
                  default:      
                   throw new IllegalArgumentException(      
                     "Malformed   \\uxxxx   encoding.");      
                  }      
           
                }    
        return (char)v;
		
	}
	/**
	 * 整数格式化，前面加0
	 * @param formartStr 格式化串,如“00000”
	 * @param num 
	 */
	public static String intFormat(String formarStr,int num){
		DecimalFormat format=new DecimalFormat(formarStr);
	    return format.format(num);
	}
	/**
	 * 返回当前时间
	 * @return 
	 *     Date - 当前时间
	 */
	public static Date getCurDate() {
		try {
			return Calendar.getInstance().getTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public static boolean isNull(String str){
		if(null == str || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * String 转化为 Date
	 * @param strTime
	 * @return
	 */
	public static Date string2Date(String strDate) {
		if (strDate == null || strDate.equals("")) {
			return null;
		}
		try {
			SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
			Date date = forma.parse(strDate);
			return date;
		} catch (ParseException ex) {
			return null;
		}
	}

	/**
	 * String 转化为 Date
	 * @param strTime
	 * @return
	 */
	public static Date string2DateTime(String strTime) {
		if (strTime == null || strTime.equals("")
				|| strTime.toUpperCase().equals("NULL")) {
			return null;
		}
		try {
			SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = forma.parse(strTime);
			return date;
		} catch (Exception ex) {
			SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = forma.parse(strTime);
				return date;
			} catch (Exception Ex) {
				Ex.printStackTrace();
			}
		}
		return null;
	}
	
	 /**
	 * 是否是合法小灵通号 小灵通是11或12位,以0开头
	 * 
	 * @param str 小灵通号
	 * @return altStr 链表
	 */
	public static boolean isXLT (String str) {
		str = str.trim();
		int nLen = str.length();
		/**为8位时加上"023"*/
		if(nLen == 8){
			str = "023" + str;
		}
		nLen = str.length();
		/**小灵通是11或12位*/
		if(!(nLen == 11 || nLen == 12)){
			return false;
		}
		/**以0开头*/
		String sTmp = str.substring(0, 1);
		if("0".equals(sTmp)){
			/**是否为数字串*/
			return isNum(str);
		}else{
			return false;
		}
	}  
	
	/**
	 * 是否是合法手机号 手机号码是 11位 13或15开头
	 * 
	 * @param str 手机号
	 * @return altStr 链表
	 */
	public static boolean isMobile (String str) {
		str = str.trim();
		int nLen = str.length();
		/**手机号码是 11位*/
		if(nLen != 11){
			return false;
		}
		/**13或15,18开头*/
		String sTmp = str.substring(0, 2);
		if("13".equals(sTmp) || "15".equals(sTmp) || "18".equals(sTmp)){
			/**是否为数字串*/
			return isNum(str);
		}else{
			return false;
		}
	}

	/**
	 * Date 转化为 String
	 * @param dateTime
	 * @return
	 */
	public static String dateTime2String(Date dateTime) {
		try {
			SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (dateTime != null) {
				String strTime = forma.format(dateTime);
				return strTime;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Date 转化为 String
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Date 转化为 String
	 * @param date
	 * @return
	 */
	public static String date2String(Date date,String formatStr) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			return format.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 将不带时间的Date转换为带时间的日期字符串
	 * @param strTime 时间部分，格式如 08:00:00
	 * @param date 不带时间的Date
	 * @return 
	 *     String - 带时间的日期字符串
	 */
	public static String date2DateTimeString(Date date, String strTime) {
		try {
			if (strTime == null) {
				strTime = "00:00:00";
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = format.format(date);
			strDate = strDate + " " + strTime;
			return strDate;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 返回当前时间字符串
	 * @return 
	 *     String - 当前时间串
	 */
	public static String getCurDateTimeString() {
		try {
			return dateTime2String(new Date());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
//	public static Timestamp getCurTimeStamp(){
//		return new Timestamp(string2DateTime(getCurDateTimeString()).getTime());
//	}

	/**
	 * 返回当前时间字符串
	 * @return 
	 *     String - 当前时间串
	 */
	public static String getCurDateString() {
		try {
			return date2String(new Date());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0 || v == 0) {
			return v;
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 将带某分隔字符的字符串转换为数组列表
	 * @param str
	 *            字符串(字符串形式如：8,12,50,10)
	 * @param strSymbol
	 *            分隔字符
	 * @return ArrayList - 链表
	 */
	public static List<String> stringToArrayList(String str,
			String strSymbol) {
		List<String> altStr = new ArrayList<String>();
		if (str == null || "".equals(str)) {
			return altStr;
		}
		while (true) {
			int iIndex = str.indexOf(strSymbol);
			String strTemp = "";
			if (iIndex != -1) {
				strTemp = str.substring(0, iIndex);
				if (strTemp != null && !strTemp.equals("")) {
					altStr.add(strTemp.trim());
				}
				str = str.substring(iIndex + 1);
			} else {
				if (str != null && !str.equals("")) {
					altStr.add(str.trim());
				}
				return altStr;
			}
		}
	}
	
	/**
	 * 将带某分隔字符的字符串转换为数组列表
	 * @param str
	 *            字符串(字符串形式如：8,12,50,10)
	 * @param strSymbol
	 *            分隔字符
	 * @return ArrayList - 链表
	 */
	public static String[] stringToArray(String str,
			String strSymbol) {
		
		if (str == null || "".equals(str)) {
			return null;
		}
		List<String> lst = stringToArrayList(str,strSymbol);
		String[] arr = new String[lst.size()];
		int i = 0;
		for(String tmp : lst){
			arr[i] = tmp;
			i++;
		}
		return arr;
	}
	
	/**
	 * @Description:将链表转换为带某分隔字符的字符串
	 * @param altData 
	 *     链表
	 * @param strSymbol 
	 *     分隔字符
	 * @return 
	 *     String - 生成后的字符串(字符串形式如：8,12,50,10)
	 */
	public static String arrayListToString(List<String> altData, String strSymbol) {
		String str = "";
		if (altData == null) {
			return null;
		}
		for (int i = 0; i < altData.size(); i++) {
			String strTemp = (String) altData.get(i);
			if (i == altData.size() - 1) {
				str = str + strTemp;
			} else {
				str = str + strTemp + strSymbol;
			}
		}
		return str;
	}
	
	/**
	 * 将数组转换为带某分隔字符的字符串
	 * @param objs
	 *     数组
	 * @param strSymbol 
	 *    分隔字符
	 * @return 
	 *     String - 生成后的字符串(字符串形式如：8,12,50,10)
	 */
	public static String arrayToString(Object[] objs, String strSymbol) {
		String str = "";
		if (objs == null) {
			return null;
		}
		int nLen = objs.length;
		for (int i = 0; i < nLen; i++) {
			String strTemp = (String) objs[i];
			if (i == nLen - 1) {
				str = str + strTemp;
			} else {
				str = str + strTemp + strSymbol;
			}
		}
		return str;
	}
	
	/**
	 * 将对象数组转换为向量
	 * @param anArray:数组对象
	 * @return 向量对象
	 */
	public static Vector<Object> convertToVector(Object[] anArray) {
		if (anArray == null) {
			return null;
		}
		Vector<Object> v = new Vector<Object>(anArray.length);
		for (int i = 0; i < anArray.length; i++) {
			v.addElement(anArray[i]);
		}
		return v;
	}
	
	/**
	 * 将数组转换为链表
	 * @param objs 
	 *    字符串
	 * @return 
	 *     List - 链表
	 */
	public static List<String> arrayToArrayList(Object[] objs) {
		List<String> altStr = new ArrayList<String>();
		if (objs == null) {
			return altStr;
		}
		int nLen = objs.length;
		if (nLen == 0) {
			return altStr;
		}
		String strTemp = "";
		for (int i = 0; i < nLen; i++) {

			strTemp = objs[i].toString();
			if (strTemp != null && !strTemp.equals("")) {
				altStr.add(strTemp);
			}
		}
		return altStr;
	}

	/**
	 * 判断字符串是否为数字串,字符串为空时也返回false
	 * @param strString
	 * @return 
	 */
	public static boolean isNum(String strString) {
		boolean bFlag = true;
		if("".equals(strString)){
			return false;
		}
		char[] arr1 = strString.toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] < '0' || arr1[i] > '9') {
				bFlag = false;
			}
		}
		return bFlag;
	}
	
	/**
	 * 判断字符串是否为数字串(可以包含小数点),字符串为空时也返回false
	 * @param strString
	 * @return 
	 */
	public static boolean isDouble(String strString) {
		if("".equals(strString)){
			return false;
		}
		int iIndex = strString.indexOf(".");
		if(iIndex == -1){
			return isNum(strString);
		}
		String sBefore = "";
		String sAfter = "";
		sBefore = strString.substring(0, iIndex);
		sAfter = strString.substring(iIndex + 1, strString.length());
		if(sBefore.length() > 0 && sAfter.length() > 0){
			return isNum(sBefore) && isNum(sAfter);
		}
		return false;
	}
	
	/**
	 * 得到A和B两个时间的差,返回结果以秒为单位
	 * @param dateA
	 *     Date
	 * @param dateB
	 *     Date
	 * @return 
	 *     long - 时间差
	 */
	public static long getTimeBtwAnB(Date dateA, Date dateB) {
		if (dateA == null || dateB == null) {
			return 0;
		}
		return (dateB.getTime() - dateA.getTime()) / 1000;
	}

	/**
	 * 得到A和B两个时间的差,返回结果以秒为单位
	 * @param dateA
	 *     String
	 * @param dateB
	 *     String
	 * @return 
	 *     long - 时间差
	 */
	public static long getTimeBtwAnB(String dateA, String dateB) {
		return getTimeBtwAnB(string2DateTime(dateA), string2DateTime(dateB));
	}

	/**
	 * @Description:得到A和B两个时间的差,返回结果以秒为单位
	 * @param dateA
	 *     String
	 * @param dateB
	 *     Date
	 * @return 
	 *     long - 时间差
	 */
	public static long getTimeBtwAnB(String dateA, Date dateB) {
		return getTimeBtwAnB(string2DateTime(dateA), dateB);
	}

	/**
	 * 判断A是否在B之前
	 * @param dateA
	 *     Date
	 * @param dateB
	 *     String
	 * @return 
	 *     boolean - A是否在B之前
	 */
	public static boolean isABeforeB(Date dateA, String dateB) {
		return isABeforeB(dateA, string2DateTime(dateB));
	}

	/**
	 * 判断A是否在B之前
	 * @param dateA
	 *     String
	 * @param dateB
	 *     Date
	 * @return 
	 *     boolean - A是否在B之前
	 */
	public static boolean isABeforeB(String dateA, Date dateB) {
		return isABeforeB(string2DateTime(dateA), dateB);
	}

	/**
	 * @Description:判断A是否在B之前
	 * @param dateA
	 *     String
	 * @param dateB
	 *     String
	 * @return 
	 *     boolean - A是否在B之前
	 */
	public static boolean isABeforeB(String dateA, String dateB) {
		return isABeforeB(string2DateTime(dateA), string2DateTime(dateB));
	}

	/**
	 * 判断A是否在B之前
	 * @param dateA
	 *     Date
	 * @param dateB
	 *     Date
	 * @return 
	 *     boolean - A是否在B之前
	 */
	public static boolean isABeforeB(Date dateA, Date dateB) {
		try {
			if (dateA == null || dateB == null) {
				return true;
			}
			Calendar calendarA = Calendar.getInstance();
			calendarA.setTime(dateA);
			Calendar calendarB = Calendar.getInstance();
			calendarB.setTime(dateB);
			return calendarA.before(calendarB);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 计算文件大小
	 * @param fileName
	 *     文件全路径
	 * @return 
	 *     long - 文件大小
	 */
	public static long countFileSize(String fileName){
		File file = new File(fileName);
		return file.length();
	}
	
	/**
	 * 计算文件大小
	 * @param file
	 *     文件
	 * @return 
	 *     long - 文件大小
	 */
	public static long countFileSize(File file){
		return file.length();
	}
	
	/**
	 * 检测文件是否存在，如果存在，则删除
	 * @param fileName
	 *     文件全路径
	 */
	public static void deleteExistsFile(String fileName){
		File file = new File(fileName);
		if(file.exists()){
			file.delete();
		}
	}
	/**
	 * 检测文件是否存在，如果存在，则删除
	 * @param nowDate 时间
	 * @param day Calendar中的年，月，天，时，分秒等常量
	 * @param number 数量
	 */
	public static Date addDays(Date nowDate, int day, int number) {
		Calendar c = Calendar.getInstance();
		c.setTime(nowDate);
		c.add(day, number);
		return c.getTime();
	}
	
	public static void main(String [] args) throws Exception{
		String tmpContent = StringUtils.decodeUnicode("6CA195EE9898");
//		System.out.println(StringUtils.addDays(Utils.nowFullTime("yyyy-MM-dd HH:mm:ss"),Calendar.MINUTE , -3));
		System.out.println(tmpContent);
	}
}
