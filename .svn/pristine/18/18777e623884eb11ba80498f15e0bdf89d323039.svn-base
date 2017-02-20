package com.inc.gtc.fire.util;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GsonUtils  {
	
	
	public static Map<String,Object> convertFromJson(String json) throws Exception
	{
		 ObjectMapper mapper = new ObjectMapper();
		 return  mapper.readValue(json, new TypeReference<Map<String,Object>>() { });
	}
	
	
	
	

	public static String getJsonFromObj(Object obj) throws Exception{
		
		 ObjectMapper objectMapper = new ObjectMapper();  
		 return objectMapper.writeValueAsString(obj); 
	}
}
