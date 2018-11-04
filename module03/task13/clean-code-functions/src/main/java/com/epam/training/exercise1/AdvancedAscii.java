package com.epam.training.exercise1;

import java.io.IOException;

public class AdvancedAscii {

	public static void main(String[] args) throws IOException {
		Image image = Image.createImage("pair_hiking.png");
		char[] charsByDarkness = { '#', '@', 'X', 'L', 'I', ':', '.', ' ' };
		int max = 0;
		int min = 255 * 3;
		int stepY = image.getHeight() / 60;
		int stepX = image.getWidth() / 200;
		for (int y = 0; y < image.getHeight(); y += stepY) {
			for (int x = 0; x < image.getWidth(); x += stepX) {
				int sum = 0;
				for (int avgy = 0; avgy < stepY; avgy++) {
					for (int avgx = 0; avgx < stepX; avgx++) {
						sum = sum + (image.getRed(new Coordinate(x, y)) + image.getBlue(new Coordinate(x, y)) + image.getGreen(new Coordinate(x, y)));
					}
				}
				sum = sum / stepY / stepX;
				if (max < sum) {
					max = sum;
				}
				if (min > sum) {
					min = sum;
				}
			}
		}
		for (int y = 0; y < image.getHeight() - stepY; y += stepY) {
			for (int x = 0; x < image.getWidth() - stepX; x += stepX) {
				int sum = 0;
				for (int avgy = 0; avgy < stepY; avgy++) {
					for (int avgx = 0; avgx < stepX; avgx++) {
                        sum = sum + (image.getRed(new Coordinate(x, y)) + image.getBlue(new Coordinate(x, y)) + image.getGreen(new Coordinate(x, y)));
					}
				}
				sum = sum / stepY / stepX;
				System.out.print(charsByDarkness[(sum - min) * charsByDarkness.length / (max - min + 1)]);
			}
			System.out.println();
		}
	}

}
