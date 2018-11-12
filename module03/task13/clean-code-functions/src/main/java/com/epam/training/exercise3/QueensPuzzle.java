package com.epam.training.exercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private List<char[][]> solutions = new ArrayList<>();

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
        solveAllNQueens(getNewBoard(), 0);
        printSolutionSize();
        printSolutions();
    }

    private char[][] getNewBoard() {
        char[][] newBoard = new char[boardDimension][boardDimension];
        for (int row = 0; row < boardDimension; row++) {
            Arrays.fill(newBoard[row], '.');
        }
        return newBoard;
    }

    private void printSolutionSize() {
        logger.info("{} solution found", solutions.size());
    }

    private void printSolutions() {
        for (int i = 0; i < solutions.size(); i++) {
            logger.info("\nSolution {}\n", i + 1);

            char[][] board = solutions.get(i);
            for (char[] row : board) {
                logger.info(String.valueOf(row)+"\n");
            }
        }
    }

    /* A recursive utility function to solve N
        Queen problem */
    private void solveAllNQueens(char[][] board, int column) {
        if (column == board.length) {
            solutions.add(getCopyOfBoard(board));
        } else {
            for (int row = 0; row < board.length; row++) {
                if (isSafe(board, row, column)) {
                    board[row][column] = 'q';
                    solveAllNQueens(board, column + 1);
                    board[row][column] = '.';
                }
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

    private boolean isSafe(char[][] board, int row, int column) {
        return isRowSafe(board, row, column)
                && isMajorDiagonalSafe(board, row, column)
                && isMinorDiagonalSafe(board, row, column);
    }

    private boolean isRowSafe(char[][] board, int row, int column) {
        boolean result = true;
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 'q') {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isMajorDiagonalSafe(char[][] board, int row, int column) {
        boolean result = true;
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'q') {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isMinorDiagonalSafe(char[][] board, int row, int column) {
        boolean result = true;
        for (int i = row, j = column; j >= 0 && i < boardDimension; i++, j--) {
            if (board[i][j] == 'q') {
                result = false;
                break;
            }
        }
        return result;
    }
}
