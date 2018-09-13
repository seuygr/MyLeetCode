package solution;

public class LongestAscendingSubsequence {
	// Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
	// Method 1: DP with O(n^2) time and O(n) space
	public int longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		// longestLength[i] stores the longest length of subsequence that ends at index i
		int[] longestLength = new int[array.length];
		longestLength[0] = 1;
		int result = 1;
		for (int i = 1; i < array.length; i++) {
			longestLength[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					longestLength[i] = Math.max(longestLength[i], longestLength[j] + 1);
				}
			}
			result = Math.max(longestLength[i], result);
		}
		return result;
	}
	
	// Method 2: binary search
	// to be continued
	public static void main(String[] args) {
		int[] array = new int[] {10, 11, 1, 2, 12, 3, 4, 6, 2};
		LongestAscendingSubsequence sol = new LongestAscendingSubsequence();
		System.out.println(sol.longest(array));
	}
}
