package com.citizant.kudos.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
	
    private static Log log = LogFactory.getLog(StringUtil.class);
    public static final String EMPTY_STRING = "";
	
	public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
	}

	public static String getStandardDate(Date d)
	{
		return (new SimpleDateFormat("MM/dd/yyyy")).format(d);
	}

}
