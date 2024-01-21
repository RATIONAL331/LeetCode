package p000001_p000100;

public class P000007 {
	public static void main(String[] args) {
		System.out.println(reverse(23));
	}

	public static int reverse(int x) {
		if (x == 0) return 0;

		boolean signFlag = x >= 0;
		if (x < 0) x = -x;

		long result = 0L;
		while (x != 0) {
			result *= 10;
			result += x % 10;
			x /= 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}

		Long resultWrap = signFlag ? result : -result;
		return resultWrap.intValue();
	}
}
