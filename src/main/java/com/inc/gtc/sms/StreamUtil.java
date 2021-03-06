package com.inc.gtc.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {

	   public static String convertStreamToString(InputStream is,String charset) throws Exception{    
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is,charset));    
	        StringBuilder sb = new StringBuilder();    
	        String line = null;    
	        try {    
	            while ((line = reader.readLine()) != null) {
	            	System.out.println(line);
	                sb.append(line + "\n");    
	            }    
	        } catch (IOException e) {    
	            e.printStackTrace();    
	        } finally {    
	            try {    
	                is.close();    
	            } catch (IOException e) {    
	                e.printStackTrace(); 
	            }    
	        }    
	        return sb.toString();    
	    }   
}
