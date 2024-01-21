package p001701_p001800;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P001704 {
	private static final Set<Character> vowels = new HashSet<>(List.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

	public static void main(String[] args) {
		System.out.println(halvesAreAlike("book"));
	}

	public static boolean halvesAreAlike(String s) {
		int length = s.length();
		String left = s.substring(0, length / 2);
		String right = s.substring(length / 2, length);

		return countVowels(left) == countVowels(right);
	}

	private static long countVowels(String str) {
		return str.chars()
		          .mapToObj(i -> (char) i)
		          .filter(vowels::contains)
		          .count();
	}
}
