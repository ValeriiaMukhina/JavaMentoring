package com.epam.trainings.utils;

import com.epam.trainings.domain.betting.Currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class for transforming different data types.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class DataUtils {

    private DataUtils() {
    }

    /**
     * Class for transforming different data types.
     *
     * @param currency as string
     * @return Currency object
     */
    public static Currency getCurrency(String currency) {
        checkNotNull(currency);
        Currency answer;
        if ("EUR".equalsIgnoreCase(currency)) {
            answer = Currency.EUR;
        } else if ("HUF".equalsIgnoreCase(currency)) {
            answer = Currency.HUF;
        } else if ("USD".equalsIgnoreCase(currency)) {
            answer = Currency.USD;
        } else {
            throw new IllegalArgumentException();
        }
        return answer;
    }

    /**
     * Class for transforming different data types.
     *
     * @param date as string
     * @return Local date time
     */
    public static LocalDate getDate(String date) {
        checkNotNull(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    /**
     * Class for transforming different data types.
     *
     * @param data as string
     * @return option as integer
     */
    public static int getOption(String data) {
        int option;
        checkNotNull(data);
        if ("q".equals(data)) {
            option = 0;
        } else {
            option = Integer.parseInt(data);
        }
        return option;
    }
}
