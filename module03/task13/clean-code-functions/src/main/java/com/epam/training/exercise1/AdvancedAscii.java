package com.epam.training.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converter to Ascii.
 *
 * @author Valeriia Biruk
 */
public class AdvancedAscii {
    private static final int INITIAL_MAX = 0;
    private static final int INITIAL_MIN = 255 * 3;
    private static final int STEP_RESOLUTION_Y = 60;
    private static final int STEP_RESOLUTION_X = 200;
    private static final char[] CHARS_BY_DARKNESS = {'#', '@', 'X', 'L', 'I', ':', '.', ' '};
    private static Logger logger = LoggerFactory.getLogger(AdvancedAscii.class);

    private Image image;
    private int max;
    private int min;
    private int stepY;
    private int stepX;

    public AdvancedAscii(Image image) {
        this.image = image;
        max = INITIAL_MAX;
        min = INITIAL_MIN;
        stepY = image.getHeight() / STEP_RESOLUTION_Y;
        stepX = image.getWidth() / STEP_RESOLUTION_X;
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
                logger.info(String.valueOf(CHARS_BY_DARKNESS[(intensity - min) * CHARS_BY_DARKNESS.length / (max - min + 1)]));
            }
            logger.info("\n");
        }
    }
}
