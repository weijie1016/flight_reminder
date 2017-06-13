package com.ceeety.autotest.flight_reminder.utils;

import org.apache.log4j.Logger;
import sun.reflect.Reflection;

import sun.reflect.CallerSensitive;





public class Log {
	private static Logger log=null;

	@SuppressWarnings("deprecation")
	@CallerSensitive
	public static Logger getLogger() {
		log=Logger.getLogger(Reflection.getCallerClass(3).getName());
		log.debug(Reflection.getCallerClass(3).getName());
		return log;
	}
}
