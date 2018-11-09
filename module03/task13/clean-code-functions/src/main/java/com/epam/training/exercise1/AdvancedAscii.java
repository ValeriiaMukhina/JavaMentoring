package com.epam.training.exercise1;

public class AdvancedAscii {

	public static void main(String[] args) {
		Image image = Image.get("pair_hiking.png");
		char[] charsByDarkness = { '#', '@', 'X', 'L', 'I', ':', '.', ' ' };
		int max = 0;
		int min = 255 * 3;
		int stepY = image.getHeight() / 60;
		int stepX = image.getWidth() / 200;
		for (int y = 0; y < image.getHeight(); y += stepY) {
			for (int x = 0; x < image.getWidth(); x += stepX) {
				int intensity = image.getIntensity(new Point(x, y));
				if (max < intensity) {
					max = intensity;
				}
				if (min > intensity) {
					min = intensity;
				}
			}
		}
		for (int y = 0; y < image.getHeight(); y += stepY) {
			for (int x = 0; x < image.getWidth(); x += stepX) {
				int intensity = image.getIntensity(new Point(x, y));
				System.out.print(charsByDarkness[(intensity - min) * charsByDarkness.length / (max - min + 1)]);
			}
			System.out.println();
		}
	}

}
