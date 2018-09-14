package com.epam.training;

import java.util.HashSet;
import java.util.Set;

public class Application {
	
	private static final int MAX = 10000000;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Pancake> pancakes = createPancakes();
		checkSize(pancakes);
		long end = System.currentTimeMillis();
		System.out.println("It took: " + (end - start) + " ms");
	}

	private static Set<Pancake> createPancakes() {
		Set<Pancake> availablePancakes = new HashSet<>();
		for (int i = 10; i < MAX; i++) {
			availablePancakes.add(new Pancake("Bacon Pancake", i / 100.0));
		}
		return availablePancakes;
	}

	private static void checkSize(Set<Pancake> availablePancakes) {
		if (availablePancakes.size() == MAX / 10) {
			System.out.println("Correct size");
		} else {
			System.out.println("Invalid size");
		}
	}

}
