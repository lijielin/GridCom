package com.inc.gm.utils;

public class GeoUtils {

	
    public static double[] getAround(double lat,double lon,int raidus){  
        
        Double latitude = lat;  
        Double longitude = lon;  
          
        Double degree = (24901*1609)/360.0;  
        double raidusMile = raidus;  
          
        Double dpmLat = 1/degree;  
        Double radiusLat = dpmLat*raidusMile;  
        Double minLat = latitude - radiusLat;  
        Double maxLat = latitude + radiusLat;  
          
        Double mpdLng = degree*Math.cos(latitude * (Math.PI/180));  
        Double dpmLng = 1 / mpdLng;  
        Double radiusLng = dpmLng*raidusMile;  
        Double minLng = longitude - radiusLng;  
        Double maxLng = longitude + radiusLng;  
        return new double[]{minLat,minLng,maxLat,maxLng};  
    }  
    
	public static double angle(Coordinate A,Coordinate B)
	{
	double dx = (B.m_RadLo - A.m_RadLo) * A.Ed;
      double dy = (B.m_RadLa - A.m_RadLa) * A.Ec;
      double angle =  Math.atan(Math.abs(dx/dy))*180./Math.PI;
       // 判断象限
      double  dLo = B.m_Longitude - A.m_Longitude;
      double  dLa = B.m_Latitude - A.m_Latitude;
       
       if(dLo > 0 && dLa <= 0) {
	         angle = (90. - angle) + 90.;
	        }
       else if(dLo <= 0 && dLa < 0) {
	         angle = angle + 180.;
	        }
       else if(dLo < 0 && dLa >= 0) {
	         angle = (90. - angle) + 270;
	   }
		return angle;
	}
	public static CalResult calDistanceAngle1(double lng1,double lat1,double lng2,double lat2) {
		Coordinate A = new Coordinate(lng1,lat1);
		Coordinate B = new Coordinate(lng2,lat2);
        double dx = (B.m_RadLo - A.m_RadLo) * A.Ed;
        double dy = (B.m_RadLa - A.m_RadLa) * A.Ec;
        double out = Math.sqrt(dx * dx + dy * dy);
     
        CalResult rs = new CalResult();
        rs.setAngle(angle(A,B));
        rs.setDistance(out);
        return rs;
    }
	
	public static double distance(double lng1,double lat1,double lng2,double lat2) {
		Coordinate A = new Coordinate(lng1,lat1);
		Coordinate B = new Coordinate(lng2,lat2);
        double dx = (B.m_RadLo - A.m_RadLo) * A.Ed;
        double dy = (B.m_RadLa - A.m_RadLa) * A.Ec;
        return  Math.sqrt(dx * dx + dy * dy);
        
    }
	
	
	
	public static String getDirection(double angle)
	{
		if (angle<15 || angle>350)
			return "北方";
		else if (angle>=15 && angle<=80)
			return "东北";
		else if (angle>=80 && angle<=100)
			return "东方";
		else if (angle>=100 && angle<=170)
			return "东南";
		else if (angle>=270 && angle<=350)
			return "西北";
		else if (angle>=190 && angle<=260)
			return "西南";
		else if (angle>=170 && angle <=190)
			return "南方";
		else if (angle>=260 && angle<=290)
			return "西方";
		else
			return "方向不明";
		
	}
}

 class Coordinate {
    
    static double PI = Math.PI;//3.14159265
    static double Rc = 6378137; // 赤道半径
    static double Rj = 6356725; // 极半径
 
    public double m_LoDeg, m_LoMin, m_LoSec; // longtitude 经度
    public double m_LaDeg, m_LaMin, m_LaSec;
    public double m_Longitude, m_Latitude;
    public double m_RadLo, m_RadLa;
    public double Ec;
    public double Ed;
 
    

 
    public  Coordinate(double longitude, double latitude) {
        m_LoDeg = (int) (longitude);
        m_LoMin = (int) ((longitude - m_LoDeg) * 60);
        m_LoSec = (int) (longitude - m_LoDeg - m_LoMin / 60.) * 3600;
 
        m_LaDeg = (int) latitude;
        m_LaMin = (int) ((latitude - m_LaDeg) * 60);
        m_LaSec = (latitude - m_LaDeg - m_LaMin / 60.) * 3600;
 
        m_Longitude = longitude;
        m_Latitude = latitude;
        m_RadLo = longitude * PI / 180.;
        m_RadLa = latitude * PI / 180.;
        Ec = Rj + (Rc - Rj) * (90. - m_Latitude) / 90.;
        Ed = Ec * Math.cos(m_RadLa);
    }
     
    
	/**WGS84转墨卡托**/
 public static double[] lonLat2Mercator(double lon,double lat)
 {
	 double[] xy = new double[2];
     double x = lon *20037508.342789/180;
     double y = Math.log(Math.tan((90+lat)*Math.PI/360))/(Math.PI/180);
     y = y *20037508.34789/180;
     xy[0] = x;
     xy[1] = y;
     return xy;
 }
 /**墨卡托转WGS84**/
 public static double[] Mercator2lonLat(double mercatorX,double mercatorY)
 {
  double[] xy = new double[2];
     double x = mercatorX/20037508.34*180;
     double y = mercatorY/20037508.34*180;
     y= 180/Math.PI*(2*Math.atan(Math.exp(y*Math.PI/180))-Math.PI/2);
     xy[0] = x;
     xy[1] = y;
     return xy;
 }

/**根据经纬度获取瓦片地址**/
public static double[] toTile(int zoom, double lng,double lat) {
    double n = Math.pow(2, zoom);
    double tileX = ((lng+ 180) / 360) * n;
    double tileY = (1 - (Math.log(Math.tan(Math.toRadians(lat)) + (1 / Math.cos(Math.toRadians(lat)))) / Math.PI)) / 2 * n;
    return new double[]{tileX,tileY};
}

public static double toResolutions(int n)
{
	return 20037508.3427892 * 2 / 256 / (2^n);
}

//经度到像素X
public static double lngToPixel(double lng, int zoom) {
	return (lng + 180) * (256L << zoom) / 360;
}

//像素X到经度
public static double pixelToLng(double pixelX, int zoom) {
	return pixelX * 360 / (256L << zoom) - 180;
}

//纬度到像素Y
public static double latToPixel(double lat, int zoom) {
	double siny = Math.sin(lat * Math.PI / 180);
	double y = Math.log((1 + siny) / (1 - siny));
	return (128 << zoom) * (1 - y / (2 * Math.PI));
}

//像素Y到纬度
public static double pixelToLat(double pixelY, int zoom) {
	double y = 2 * Math.PI * (1 - pixelY / (128 << zoom));
	double z = Math.pow(Math.E, y);
	double siny = (z - 1) / (z + 1);
	return Math.asin(siny) * 180 / Math.PI;
}
}
