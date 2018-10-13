package solution;

public class LongestCommonSubstring {
	// Given two strings one(length of m) and two(length of n), find the length of the longest common substring.
	// The simplest way is to one by one check all substring in one if it is also a substring in two
	// This method costs O(m^2 * n)
	
	//Better method: DP with O(m * n) time and O(m * n) space
	public String longestCommonSubstring(String one, String two) {
		if (one == null || two == null) {
			return null;
		}
		char[] source = one.toCharArray();
		char[] target = two.toCharArray();
		int start = 0;
		int longest = 0;
		int[][] common = new int[source.length][target.length];
		for (int i = 0; i < common.length; i++) {
			for (int j = 0; j < common[0].length; j++) {
				if (source[i] == target[j]) {
					if (i == 0 || j == 0) {
						common[i][j] = 1;
					} else {
						common[i][j] = common[i - 1][j - 1] + 1;
					}
				}
				if (common[i][j] > longest) {
					longest = common[i][j];
					start = i - longest + 1;
				}
			}
		}
		return one.substring(start, start + longest);
	}
	
}
