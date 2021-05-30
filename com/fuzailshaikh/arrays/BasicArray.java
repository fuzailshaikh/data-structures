package com.fuzailshaikh.arrays;

public class BasicArray {
	public static void main(String[] args) {
		// Create an array with size: 2
		int[] array = new int[2];

		// Insert some data by referencing index
		array[0] = 11;
		array[1] = 9;

		print(array);

		// Delete some data at specified index
		array = delete(array, 1);

		print(array);
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] delete(int[] arr, int index) {
		int[] temp = new int[arr.length - 1];

		for (int i = 0, j = 0; i < arr.length; i++) {
			if (i != index) {
				temp[j++] = arr[i];
			}
		}

		return temp;
	}

	public static boolean search(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return true;
			}
		}
		return false;
	}
}
