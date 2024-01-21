package p000101_p000200;

import java.util.Arrays;

public class P000198 {
	public static void main(String[] args) {
		System.out.println(rob(new int[]{1, 2, 3, 1}));
		System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
	}

	public static int rob(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);

		return rob(nums, 0, dp);
	}

	public static int rob(int[] nums, int selectIndex, int[] dp) {
		if (selectIndex >= nums.length) {
			return 0;
		}

		if (dp[selectIndex] != -1) {
			return dp[selectIndex];
		}

		int firstCase = nums[selectIndex] + rob(nums, selectIndex + 2, dp);
		int secondCase = rob(nums, selectIndex + 1, dp);
		return dp[selectIndex] = Math.max(firstCase, secondCase);
	}
}
