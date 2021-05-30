package com.fuzailshaikh.arrays;

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

	}
}
