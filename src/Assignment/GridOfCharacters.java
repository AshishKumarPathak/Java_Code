package Assignment;

import java.util.Scanner;

public class GridOfCharacters {
	private static final int[] ROW_DIRECTIONS = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] COL_DIRECTIONS = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of rows in the grid: ");
		int rows = scanner.nextInt();
		System.out.print("Enter the number of columns in the grid: ");
		int cols = scanner.nextInt();

		char[][] grid = new char[rows][cols];
		System.out.println("Enter the characters of the grid:");

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				grid[row][col] = scanner.next().charAt(0);
			}
		}

		System.out.print("Enter the number of words: ");
		int wordCount = scanner.nextInt();//Total number of words
		scanner.nextLine(); // Consume newline character

		String[] words = new String[wordCount];
		System.out.println("Enter the words:");

		for (int i = 0; i < wordCount; i++) {
			words[i] = scanner.nextLine();
		}

		scanner.close();

		for (String word : words) {
			int count = countOccurrences(grid, word);
			System.out.println("Word \"" + word + "\" occurs " + count + " time(s) in the grid.");//Words and the number of times it occured
		}
	}

	private static int countOccurrences(char[][] grid, String word) {
		int rows = grid.length;
		int cols = grid[0].length;
		int len = word.length();
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == word.charAt(0)) {
					for (int dir = 0; dir < 8; dir++) {
						int rd = row + ROW_DIRECTIONS[dir];
						int cd = col + COL_DIRECTIONS[dir];

						int k;
						for (k = 1; k < len; k++) {
							if (rd >= rows || rd < 0 || cd >= cols || cd < 0) {
								break;
							}

							if (grid[rd][cd] != word.charAt(k)) {
								break;
							}

							rd += ROW_DIRECTIONS[dir];
							cd += COL_DIRECTIONS[dir];
						}

						if (k == len) {
							count++;
						}
					}
				}
			}
		}

		return count;
	}
}
