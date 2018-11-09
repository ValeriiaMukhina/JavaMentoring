package com.epam.training.exercise3;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
  *The N Queen is the problem of placing N chess queens on an N×N chessboard
 * so that no two queens attack each other.
 *
 * @author Valeriia Biruk
 * @version 1.0
 */
public class QueensPuzzle {

    private static Logger logger = LoggerFactory.getLogger(QueensPuzzle.class);

    private int boardDimension;

    private ArrayList<char[][]> solutions = new ArrayList<>();

    public QueensPuzzle(int boardDimension) {
        this.boardDimension = boardDimension;
    }

    /**
     * The idea is to place queens one by one in different columns,
     * starting from the leftmost column. When we place a queen in a column,
     * we check for clashes with already placed queens. In the current column,
     * if we find a row for which there is no clash, we mark this row and column as part of the solution.
     * If we do not find such a row due to clashes then we backtrack and return false.
     *
     */

    public void solve() {
        char[][] newBoard = getNewBoard();
        solveAllNQueens(newBoard, 0);
        printSolutionSize();
        printSolutions();
    }

    private void printSolutions() {
        for (int i = 0; i < solutions.size(); i++) {
            logger.info("\nSolution {}", i + 1);

            char[][] board = solutions.get(i);

            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    out.print(board[row][column]);
                }
                out.println();
            }
        }
    }

    private void printSolutionSize() {
        logger.info("{} solution found", solutions.size());
    }

    private char[][] getNewBoard() {
        char[][] newBoard = new char[boardDimension][boardDimension];
        for (int row = 0; row < boardDimension; row++) {
            Arrays.fill(newBoard[row], '.');
        }
        return newBoard;
    }

    /* A recursive utility function to solve N
        Queen problem */
    private void solveAllNQueens(char[][] board, int column) {
        if (column == board.length) {
            solutions.add(getCopyOfBoard(board));
        } else {
            for (int row = 0; row < board.length; row++) {
                board[row][column] = 'q';
                if (canBeSafe(board, row, column)) {
                    solveAllNQueens(board, column + 1);
                }
                board[row][column] = '.';
            }
        }
    }

    private char[][] getCopyOfBoard(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            System.arraycopy(board[row], 0, copy[row], 0, board[0].length);
        }
        return copy;
    }

    private boolean canBeSafe(char[][] board, int row, int col) {
        return isPlaceToTheRowSafe(board, row, col) && isPlaceToTheMajorDiagonalSafe(board, row, col) && isPlaceToTheMinorDiagonalSafe(board, row, col);
    }

    private boolean isPlaceToTheRowSafe(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'q') {
                return false;
            }
        }
        return true;
    }

    private boolean isPlaceToTheMajorDiagonalSafe(char[][] board, int row, int col) {
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'q') {
                return false;
            }
        }
        return true;
    }

    private boolean isPlaceToTheMinorDiagonalSafe(char[][] board, int row, int col) {
        for (int i = row + 1, j = col - 1; j >= 0 && i < boardDimension; i++, j--) {
            if (board[i][j] == 'q') {
                return false;
            }
        }
        return true;
    }
}
