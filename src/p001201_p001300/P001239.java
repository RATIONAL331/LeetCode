package p001201_p001300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P001239 {
	public static void main(String[] args) {
		System.out.println(maxLength(Arrays.asList("un", "iq", "ue")));
		System.out.println(maxLength(Arrays.asList("cha","r","act","ers")));
		System.out.println(maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
	}

	public static int maxLength(List<String> arr) {
		int maxValue = 0;
		for (int i = 0; i < arr.size(); i++) {
			maxValue = Math.max(maxValue, maxLength(arr, i, new HashSet<>()));
		}
		return maxValue;
	}

	private static int maxLength(List<String> arr, int currentIndex, Set<Character> hasCharacter) {
		if (arr.size() <= currentIndex) {
			return 0;
		}

		String current = arr.get(currentIndex);

		int contain = 0;
		boolean selected = false;
		// 포함될 수 있다면 해당 단어를 포함시키고 글자 수 늘리기
		if (canSelect(current, hasCharacter)) {
			select(current, hasCharacter);
			selected = true;
			contain = current.length() + maxLength(arr, currentIndex + 1, hasCharacter);
		}

		if (selected) {
			deSelect(current, hasCharacter);
		}
		int skip = maxLength(arr, currentIndex + 1, hasCharacter);

		return Math.max(contain, skip);
	}

	private static boolean canSelect(String current, Set<Character> hasCharacter) {
		Set<Character> duplicateCharacter = new HashSet<>();
		for (char c : current.toCharArray()) {
			if (duplicateCharacter.contains(c) || hasCharacter.contains(c)) {
				return false;
			}
			duplicateCharacter.add(c);
		}
		return true;
	}

	private static void select(String current, Set<Character> hasCharacter) {
		for (char c : current.toCharArray()) {
			hasCharacter.add(c);
		}
	}

	private static void deSelect(String current, Set<Character> hasCharacter) {
		for (char c : current.toCharArray()) {
			hasCharacter.remove(c);
		}
	}
}
