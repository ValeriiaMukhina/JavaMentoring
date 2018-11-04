package com.epam.training.exercise2;

import java.util.Date;

import static com.epam.training.exercise2.DateUtil.nextDay;
import static com.epam.training.exercise2.DateUtil.previousDay;

public class App {

	public static void main(String[] args) {
		Date date = new Date();
		previousDay(date);
		System.out.println(date);

		System.out.println(DateUtil.create(2014, 10, 10));
	}

}
