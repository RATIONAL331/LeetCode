package p000501_p000600;

import java.util.Arrays;

public class P000576 {
	private static final int MODULO = 1_000_000_007;
	public static void main(String[] args) {
		System.out.println(findPaths(2, 2, 2, 0, 0));
		System.out.println(findPaths(1, 3, 3, 0, 1));
	}

	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][][] dp = new int[maxMove][m][n];
		for (int i = 0; i < maxMove; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return findPaths(m, n, maxMove, 0, startRow, startColumn, dp);
	}

	private static int findPaths(int m, int n,  int maxMove, int cycle, int currentRow, int currentColumn, int[][][] dp) {
		if (currentRow >= m || currentColumn >= n || currentRow < 0 || currentColumn < 0) {
			return 1;
		}

		if (cycle == maxMove) {
			return 0;
		}

		if (dp[cycle][currentRow][currentColumn] != -1) {
			return dp[cycle][currentRow][currentColumn];
		}

		long result = 0L;
		int south = findPaths(m, n, maxMove, cycle + 1, currentRow + 1, currentColumn, dp) % MODULO;
		int east = findPaths(m, n, maxMove, cycle + 1, currentRow, currentColumn + 1, dp) % MODULO;
		int north = findPaths(m, n, maxMove, cycle + 1, currentRow - 1, currentColumn, dp) % MODULO;
		int west = findPaths(m, n, maxMove, cycle + 1, currentRow, currentColumn - 1, dp) % MODULO;
		if (cycle + 1 == maxMove || currentRow + 1 >= m || currentColumn + 1 >= n || currentRow - 1 < 0 || currentColumn - 1 < 0) {
			result = (result + south) % MODULO;
			result = (result + east) % MODULO;
			result = (result + north) % MODULO;
			result = (result + west) % MODULO;
		} else {
			result = (result + (dp[cycle + 1][currentRow + 1][currentColumn] = south)) % MODULO;
			result = (result + (dp[cycle + 1][currentRow][currentColumn + 1] = east)) % MODULO;
			result = (result + (dp[cycle + 1][currentRow - 1][currentColumn] = north)) % MODULO;
			result = (result + (dp[cycle + 1][currentRow][currentColumn - 1] = west)) % MODULO;
		}
		return (int) result % MODULO;
	}
}
