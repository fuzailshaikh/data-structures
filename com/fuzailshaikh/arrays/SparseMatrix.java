package com.fuzailshaikh.arrays;

import java.util.Arrays;

public class SparseMatrix {
	public static void main(String[] args) {
		// Let's say we want to store this matrix, we can either store it in 2 dimensional array
		int[][] matrix = 
		{
			{0, 0, 0, 0},
			{5, 8, 0, 0},
			{0, 0, 3, 0},
			{0, 6, 0, 0},
		};

		// But as this is sparse matrix we can save some space by saving only important info 
		int[] values = {5, 8, 3, 6};
		int[] colIndex = {0, 1, 2, 1};
		int[] rowIndex = {1, 1, 2, 3};

		int[][] result = getMinSparseMatrix(values, colIndex, rowIndex);
		printMatrix(result);
	}

	static int[][] getMinSparseMatrix(int[] values, int[] cols, int[] rows) {
		int[][] result = new int[rows.length][cols.length];
		Arrays.stream(result).forEach(elem -> Arrays.fill(elem, 0));
		for(int index = 0; index < values.length; index++) {
			int row = rows[index];
			int column = cols[index];
			result[row][column] = values[index];
		}

		return result;
	}

	static void printMatrix(int[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}
