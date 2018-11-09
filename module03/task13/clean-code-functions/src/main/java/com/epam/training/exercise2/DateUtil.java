package com.epam.training.exercise2;

import java.util.Calendar;
import java.util.Date;

/**
 * Util class for Dates.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class DateUtil {

    private DateUtil() {
    }

    /**
     * returns next day date.
     *
     * @param date date
     */
    public static void nextDay(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date.setTime(calendar.getTime().getTime());
    }

    /**
     * returns previous day date.
     *
     * @param date date
     */

    public static void previousDay(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date.setTime(calendar.getTime().getTime());
    }

    /**
     * Turn year, month, date into Date object.
     *
     * @return Date or null, depending if arguments are in the valid date range
     * @param year year
     * @param month month
     * @param day day
     */

    public static Date create(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}
