package com.epam.training.exercise3;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {

	public static void main(String[] args) {
		ArrayList<char[][]> solutions = new ArrayList<>();
		
		char[][] result = new char[8][8];
		for (int r1 = 0; r1 < 8; r1++)
			Arrays.fill(result[r1], '.');
		
		solveAllNQueens(result, 0, solutions);
		
		System.out.println(solutions.size());
		for (int i = 0; i < solutions.size(); i++) {
			System.out.println("\nSolution " + (i + 1));
			
			char[][] board = solutions.get(i);
			
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[r].length; c++)
					System.out.print(board[r][c]);
				System.out.println();
			}
		}
	}

	private static void solveAllNQueens(char[][] board, int col, ArrayList<char[][]> solutions) {
		if (col == board.length) {
			char[][] copy = new char[board.length][board[0].length];
			for (int r = 0; r < board.length; r++)
				for (int c = 0; c < board[0].length; c++)
					copy[r][c] = board[r][c];
			solutions.add(copy);
		} else {
			for (int row = 0; row < board.length; row++) {
				board[row][col] = 'q';
				if (canBeSafe(board, row, col))
					solveAllNQueens(board, col + 1, solutions);
				board[row][col] = '.';
			}
		}
	}

	private static boolean canBeSafe(char board[][], int row, int col) {
		int i, j;

		// Check row on left side
		for (i = 0; i < col; i++)
			if (board[row][i] == 'q') return false;

		// Check major diagonal on left side
		for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 'q') return false;

		// Check minor diagonal on left side
		for (i = row + 1, j = col - 1; j >= 0 && i < 8; i++, j--)
			if (board[i][j] == 'q') return false;

		return true;
	}
}