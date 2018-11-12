package com.epam.training.exercise1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.epam.training.exercise1.exceptions.ReadImageException;
import com.epam.training.exercise1.exceptions.WrongCoordinateException;

/**
 * Image from file.
 *
 * @author Valeriia Biruk
 */
public final class Image {

    private static final int LAST_BYTE = 0xFF;
    private static final int BYTE = 8;
    private static final int TWO_BYTES = 16;

    private BufferedImage image;

    private Image(String fileName) {
        this.image = loadImageFromFile(fileName);
    }

    /**
     * Buffered Image from file.
     *
     * @param fileName from console.
     * @return Buffered Image
     * @author Valeriia Biruk
     */
    public static Image get(String fileName) {
        return new Image(fileName);
    }

    /**
     * Height of image.
     *
     * @return height
     * @author Valeriia Biruk
     */
    public int getHeight() {
        return image.getHeight();
    }

    /**
     * Weight of image.
     *
     * @return Weight
     * @author Valeriia Biruk
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * Intensity of image.
     *
     * @param point with X and Y coordinates
     * @return Intensity
     * @author Valeriia Biruk
     */
    public int getIntensity(Point point) {
        return getRed(point) + getBlue(point) + getGreen(point);
    }

    private int getRed(Point point) {
        int rgbValue = getRgbValue(point);
        return (rgbValue >> TWO_BYTES) & LAST_BYTE;
    }

    private int getGreen(Point point) {
        int rgbValue = getRgbValue(point);
        return (rgbValue >> BYTE) & LAST_BYTE;
    }

    private int getBlue(Point point) {
        int rgbValue = getRgbValue(point);
        return rgbValue & LAST_BYTE;
    }

    private int getRgbValue(Point point) {
        if (point.getX() < 0 || point.getX() > image.getWidth()) {
            throw new WrongCoordinateException("Point x out of range: 0.." + image.getWidth());
        } else if (point.getY() < 0 || point.getY() > image.getHeight()) {
            throw new WrongCoordinateException("Point y out of range: 0.." + image.getHeight());
        }
        return image.getRGB(point.getX(), point.getY());
    }

    private BufferedImage loadImageFromFile(String fileName) {
        try {
            URL file = getClass().getClassLoader().getResource(fileName);
            if (file != null) {
                return ImageIO.read(file);
            } else {
                throw new ReadImageException("Cannot load image!");
            }
        } catch (IOException exception) {
            throw new ReadImageException("Cannot load image!", exception);
        }
    }
}
