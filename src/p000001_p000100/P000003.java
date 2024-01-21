package p000001_p000100;

import java.util.HashSet;
import java.util.Set;

public class P000003 {
	public static void main(String[] args) {
		int i = lengthOfLongestSubstring("dvdf");
		System.out.println(i);
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int leftIndex = 0;
		Set<Character> wasChecked = new HashSet<>();

		for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
			char currentChar = s.charAt(rightIndex);
			if (wasChecked.contains(currentChar)) {
				while (wasChecked.contains(currentChar)) {
					wasChecked.remove(s.charAt(leftIndex++));
				}
			}
			wasChecked.add(currentChar);
			maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
		}

		return maxLength;
	}
}