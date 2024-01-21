package p000001_p000100;

public class P000005 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv"));
	}

	private static String longestPalindrome(String s) {
		return getLongestPalindrome(s, 0, s.length() - 1, new String[s.length()][s.length()]);
	}

	private static String getLongestPalindrome(String s, int beginIndex, int endIndex, String[][] dp) {
		if (dp[beginIndex][endIndex] != null) {
			return dp[beginIndex][endIndex];
		}

		String substring = s.substring(beginIndex, endIndex + 1);
		if (checkPalindrome(s, beginIndex, endIndex)) {
			return dp[beginIndex][endIndex] = substring;
		}

		String post = getLongestPalindrome(s, beginIndex + 1, endIndex, dp);
		String pre = getLongestPalindrome(s, beginIndex, endIndex - 1, dp);
		if (post.length() > pre.length()) {
			return dp[beginIndex][endIndex] = post;
		} else {
			return dp[beginIndex][endIndex] = pre;
		}
	}

	private static boolean checkPalindrome(String s, int beginIndex, int endIndex){
		while (beginIndex <= endIndex){
			if(s.charAt(beginIndex) != s.charAt(endIndex)){
				return false;
			}
			beginIndex++;
			endIndex--;
		}
		return true;
	}
}
