package com.epam.training.exercise1;

/**
 * Converter to Ascii.
 *
 * @author Valeriia Biruk
 */
public class AdvancedAscii {

    private Image image;
    private static final char[] charsByDarkness = {'#', '@', 'X', 'L', 'I', ':', '.', ' '};
    private int max = 0;
    private int min = 255 * 3;
    private int stepY = image.getHeight() / 60;
    private int stepX = image.getWidth() / 200;

    public AdvancedAscii(Image image) {
        this.image = image;
    }
    /**
     * main method to start converter.
     *
     * @author Valeriia Biruk
     */
    public void convertImageToAscii() {
        adjustMinAndMax();
        printAsciiImage();
    }

    private void adjustMinAndMax() {
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
    }

    private void printAsciiImage() {
        for (int y = 0; y < image.getHeight(); y += stepY) {
            for (int x = 0; x < image.getWidth(); x += stepX) {
                int intensity = image.getIntensity(new Point(x, y));
                System.out.print(charsByDarkness[(intensity - min) * charsByDarkness.length / (max - min + 1)]);
            }
            System.out.println();
        }
    }
}
