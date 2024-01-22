package p000601_p000700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P000645 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
	}

	public static int[] findErrorNums(int[] nums) {
		Map<Integer, Boolean> hashMap = new HashMap<>();
		for (int i = 1; i <= nums.length; i++) {
			hashMap.put(i, false);
		}

		int[] result = new int[2];
		for (int num : nums) {
			if (hashMap.get(num)) {
				result[0] = num;
			}
			hashMap.put(num, true);
		}

		for (Map.Entry<Integer, Boolean> integerBooleanEntry : hashMap.entrySet()) {
			if (!integerBooleanEntry.getValue()) {
				result[1] = integerBooleanEntry.getKey();
				break;
			}
		}

		return result;
	}
}
