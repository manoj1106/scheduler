package com.erstegroup.lio.utils;

import java.util.HashMap;
import java.util.Map;

import com.erstegroup.lio.db.model.SchedulerJobGroup;

public class ObjectFactory {

	public static Map<String,Object> getMap() {
		return new HashMap<>();
	}
	
	public static SchedulerJobGroup getSchedulerJobGroup() {
		return new SchedulerJobGroup();
	}
	
}
