package p000601_p000700;

import java.util.Arrays;

public class P000629 {
	private static final int MODULO = 1_000_000_007;

	public static void main(String[] args) {
		System.out.println(kInversePairs(3, 1));
	}

	public static int kInversePairs(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return kInversePairs(n, k, dp);
	}

	private static int kInversePairs(int n, int k, int[][] dp) {
		if (n < 0 || k < 0) {
			return 0;
		}
		if (k == 0) {
			return 1;
		}

		if (dp[n][k] != -1) {
			return dp[n][k];
		}

		long result = 0;
		for (int i = 0; i < n; i++) {
			if (k - i < 0) break;
			result = (result + kInversePairs(n - 1, k - i, dp)) % MODULO;

		}
		return dp[n][k] = (int) result;
	}
}
