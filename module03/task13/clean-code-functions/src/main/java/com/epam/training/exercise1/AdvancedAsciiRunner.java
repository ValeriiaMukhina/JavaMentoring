package com.epam.training.exercise1;

/**
 * Simple generator of picture into ascii text.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public final class AdvancedAsciiRunner {

    private AdvancedAsciiRunner() {
    }

    /**
     * initialize and start.
     *
     * @param args from console.
     * @author Valeriia Biruk
     */
    public static void main(String[] args) {
        Image image = Image.get("pair_hiking.png");
        AdvancedAscii converter = new AdvancedAscii(image);
        converter.convertImageToAscii();
    }
}
