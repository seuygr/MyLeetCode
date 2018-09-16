package solution;

public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		// Write your solution here
		return match(input, pattern, 0, 0);
	}
	private boolean match(String input, String pattern, int inputIndex, int pattIndex) {
		if (inputIndex == input.length() && pattIndex == pattern.length()) {
			return true;
		}
		if (inputIndex >= input.length() || pattIndex >= pattern.length()) {
			return false;
		}

		if (pattern.charAt(pattIndex) < '0' || pattern.charAt(pattIndex) > '9') {
			if (pattern.charAt(pattIndex) == input.charAt(inputIndex)) {
				return match(input, pattern, inputIndex + 1, pattIndex + 1);
			}
			return false;
		}
		int num = 0;
		while (pattIndex < pattern.length() && pattern.charAt(pattIndex) >= '0' && pattern.charAt(pattIndex) <= '9') {
			num = num * 10 + (pattern.charAt(pattIndex) - '0');
			pattIndex++;
		}
		return match(input, pattern, inputIndex + num, pattIndex);
	}
	public static void main(String[] args) {
		String one = "apple";
		String two = "5";
		StringAbbreviationMatching sol = new StringAbbreviationMatching();
		System.out.println(sol.match(one, two));

	}
}
