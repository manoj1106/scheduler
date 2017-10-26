package com.erstegroup.lio.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.erstegroup.lio.db.model.SchedulerJobGroup;

public class ObjectFactory {

	public static Map<String,Object> getMap() {
		return new HashMap<>();
	}
	
	public static SchedulerJobGroup getSchedulerJobGroup() {
		return new SchedulerJobGroup();
	}
	
	public static Map<String,Object> getConcurrentMap() {
		return new ConcurrentHashMap<>();
	}
	
}
