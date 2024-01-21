package p000001_p000100;

import java.util.ArrayList;
import java.util.List;

public class P000006 {
	public static void main(String[] args) {
		System.out.println(convert("ABCDE", 4));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		List<String> down = new ArrayList<>();
		List<String> upRight = new ArrayList<>();

		int index = 0;
		boolean isDown = true;
		while (index < s.length()) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int capacity = 1; capacity < numRows; capacity++) {
				if (index >= s.length()) {
					break;
				}
				stringBuilder.append(s.charAt(index++));
			}
			String result = stringBuilder.toString();
			if (isDown) {
				down.add(result);
			} else {
				StringBuilder builder = new StringBuilder(result);
				for (int i = 0; i < numRows - result.length(); i++) {
					builder.append(' ');
				}
				upRight.add(builder.toString());
			}
			isDown = !isDown;
		}
		return makeWord(down, upRight, numRows);
	}

	private static String makeWord(List<String> down, List<String> upRight, int numRows) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int index = 0; index < numRows; index++) {
			for (int i = 0; i < down.size(); i++) {
				String downWord = getWord(down, i);
				String upRightWord = new StringBuilder(getWord(upRight, i)).reverse().toString();

				char downCharAt = getCharAt(downWord, index);
				if (downCharAt != ' ') {
					stringBuilder.append(downCharAt);
				}
				char upRightCharAt = getCharAt(upRightWord, index);
				if (upRightCharAt != ' ') {
					stringBuilder.append(upRightCharAt);
				}
			}
		}
		return stringBuilder.toString();
	}

	private static String getWord(List<String> wordList, int index) {
		return wordList.stream().skip(index).findFirst().orElse("");
	}


	private static char getCharAt(String word, int index) {
		int length = word.length();
		if (index >= length) {
			return ' ';
		}
		return word.charAt(index);
	}
}
