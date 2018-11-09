package com.epam.training.exercise3;

/**
 * Runner for start QueensPuzzle.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
final class EightQueensRunner {

    private EightQueensRunner() {
    }

    /**
     * initialize and start solving.
     *
     * @param args from console.
     * @author Valeriia Biruk
     */
    public static void main(String[] args) {
        final int boardDimension = 8;
        new QueensPuzzle(boardDimension).solve();
    }
}
