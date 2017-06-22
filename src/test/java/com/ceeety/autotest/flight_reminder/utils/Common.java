package com.ceeety.autotest.flight_reminder.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
	public static void sleepFor(long seconds) {
        long start = new Date().getTime();
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            long end = new Date().getTime();
            do {
                end = new Date().getTime();
            } while ((start + (seconds * 1000)) > end);
        }
    }
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
}
