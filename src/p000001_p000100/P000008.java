package p000001_p000100;

public class P000008 {
	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("      -42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("-+12"));
		System.out.println(myAtoi("+-12"));
		System.out.println(myAtoi("+1"));
	}

	public static int myAtoi(String s) {
		s = s.trim();

		int result = 0;
		if (s.isEmpty()) {
			return result;
		}

		boolean negative = false;
		boolean overflow = false;
		boolean readNumberPhase = false;

		int currentIndex = 0;
		while (currentIndex < s.length()) {
			char currentChar = s.charAt(currentIndex);

			if (!readNumberPhase) {
				if (currentChar == '-' || currentChar == '+') {
					currentIndex += 1;
				}
				if (currentChar == '-') negative = true;
				readNumberPhase = true;
				continue;
			}

			currentIndex += 1;
			if (currentChar == '+' || currentChar == '-') break;
			if (currentChar < '0' || currentChar > '9') break;

			// check overflow
			if ((result > Integer.MAX_VALUE / 10) || (-result < Integer.MIN_VALUE / 10)) {
				overflow = true;
			}

			result *= 10;
			int currentInt = currentChar - '0';

			if ((result > Integer.MAX_VALUE - currentInt) || (-result < Integer.MIN_VALUE + currentInt)) {
				overflow = true;
			}

			result += currentInt;
		}

		if (overflow) {
			return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return negative ? -result : result;
	}
}
