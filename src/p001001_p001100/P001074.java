package p001001_p001100;

public class P001074 {

	// todo : 다시 풀어보기 (TLE 39/40)
	public static void main(String[] args) {
		System.out.println(numSubmatrixSumTarget(
				new int[][]{
						{0, 1, 0},
						{1, 1, 1},
						{0, 1, 0}
				},
				0));

		System.out.println(numSubmatrixSumTarget(
				new int[][]{
						{1, -1},
						{-1, 1}
				},
				0));
	}

	public static int numSubmatrixSumTarget(int[][] matrix, int target) {
		int maxWidthIndex = matrix[0].length - 1;
		int maxHeightIndex = matrix.length - 1;

		int[][] prefixSumMatrix = getPrefixSumMatrix(matrix);
		boolean [][][][] hasVisited = new boolean[maxWidthIndex + 1][maxHeightIndex + 1][maxWidthIndex + 1][maxHeightIndex + 1];
		return numSubmatrixSumTarget(matrix, target, 0, 0, maxWidthIndex, maxHeightIndex, prefixSumMatrix, hasVisited);
	}

	private static int numSubmatrixSumTarget(int[][] matrix, int target, int x1, int y1, int x2, int y2, int[][] prefixSumMatrix, boolean[][][][] hasVisited) {
		if (isOutOfIndex(matrix, x1, y1, x2, y2)) {
			return 0;
		}

		if (hasVisited[x1][y1][x2][y2]) {
			return 0;
		}

		hasVisited[x1][y1][x2][y2] = true;
		int result = 0;


		int currentSumSubMatrix = queryPrefixSumMatrix(prefixSumMatrix, x1, y1, x2, y2);
		if (currentSumSubMatrix == target) {
			result += 1;
		}

		int left = numSubmatrixSumTarget(matrix, target, x1, y1, x2 - 1, y2, prefixSumMatrix, hasVisited);
		int right = numSubmatrixSumTarget(matrix, target, x1 + 1, y1, x2, y2, prefixSumMatrix, hasVisited);
		int down = numSubmatrixSumTarget(matrix, target, x1, y1 + 1, x2, y2, prefixSumMatrix, hasVisited);
		int up = numSubmatrixSumTarget(matrix, target, x1, y1, x2, y2 - 1, prefixSumMatrix, hasVisited);

		result += left;
		result += right;
		result += down;
		result += up;

		return result;
	}

	private static int[][] getPrefixSumMatrix(int[][] matrix) {
		int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i < sumMatrix.length; i++) {
			for (int j = 1; j < sumMatrix[0].length; j++) {
				sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
		return sumMatrix;
	}

	private static int queryPrefixSumMatrix(int[][] sumMatrix, int x1, int y1, int x2, int y2) {
		return sumMatrix[y2 + 1][x2 + 1] - sumMatrix[y1][x2 + 1] - sumMatrix[y2 + 1][x1] + sumMatrix[y1][x1];
	}

	private static boolean isOutOfIndex(int[][] matrix, int x1, int y1, int x2, int y2) {
		int maxWidth = matrix[0].length;
		int maxHeight = matrix.length;

		if (x1 < 0 || x1 >= maxWidth ||
				x2 < 0 || x2 >= maxWidth ||
				y1 < 0 || y1 >= maxHeight ||
				y2 < 0 || y2 >= maxHeight) {
			return true;
		}

		if (x1 > x2 || y1 > y2) {
			return true;
		}

		return false;
	}
}
