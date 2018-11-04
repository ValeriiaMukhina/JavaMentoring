package com.epam.training.exercise2;

import java.util.Calendar;
import java.util.Date;

import static com.epam.training.exercise2.DateUtil.increment;

public class App {

	public static void main(String[] args) {
		Date date = new Date();
		increment(date, false);
		System.out.println(date);

		System.out.println(DateUtil.create(2014, 10, 10));
	}

}
