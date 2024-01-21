package p000001_p000100;

import java.util.ArrayList;
import java.util.List;

public class P000004 {
	public static void main(String[] args) {
		double medianSortedArrays = findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4});
		System.out.println(medianSortedArrays);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> mergedArrays = getMergedArrays(nums1, nums2);
		if (mergedArrays.isEmpty()) {
			return 0;
		}

		int length = mergedArrays.size();
		int middle = length / 2;
		if (length % 2 == 0) {
			return (mergedArrays.get(middle - 1) + mergedArrays.get(middle)) / 2.0;
		} else {
			return mergedArrays.get(middle);
		}
	}

	private static List<Integer> getMergedArrays(int[] nums1, int[] nums2) {
		List<Integer> mergedArrays = new ArrayList<>();

		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < nums1.length || rightIndex < nums2.length) {
			if (leftIndex == nums1.length) {
				mergedArrays.add(nums2[rightIndex++]);
			} else if (rightIndex == nums2.length) {
				mergedArrays.add(nums1[leftIndex++]);
			} else {
				if (nums1[leftIndex] < nums2[rightIndex]) {
					mergedArrays.add(nums1[leftIndex++]);
				} else {
					mergedArrays.add(nums2[rightIndex++]);
				}
			}
		}
		return mergedArrays;
	}
}
