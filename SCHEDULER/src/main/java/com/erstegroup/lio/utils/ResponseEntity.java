package com.erstegroup.lio.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseEntity {

	private Map<String, Object> dataMap;

	private ResponseEntity() {
		
	}
	
	public static ResponseEntity newInstance() {
		return new ResponseEntity();
	}
	
	public Map<String, Object> getDataMap() {
		if(null == this.dataMap) {
			dataMap = new HashMap<String,Object>();
		}
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
