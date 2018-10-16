package com.sawcao.beanoperation.copier;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 *
 * 21 May 2009
 */
public class FastClonerCalendar implements IFastCloner
{
    public Object clone(final Object t, final IDeepCloner cloner, final Map<Object, Object> clones) {
		final GregorianCalendar gc = new GregorianCalendar();
		Calendar c = (Calendar) t;
		gc.setTimeInMillis(c.getTimeInMillis());
		gc.setTimeZone((TimeZone) c.getTimeZone().clone());
		return gc;
	}
}
