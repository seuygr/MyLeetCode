package solution;

import java.util.*;

public class ValidPermutationOfParenthesis {
	// Given n pairs of parenthesis, print all valid permutation of parenthesis
	
	public List<String> validPermutation(int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0) {
			return result;
		}
		char[] cur = new char[2 * n];
		dfs(n, n, cur, 0, result);
		return result;
	}
	private void dfs(int left, int right, char[] cur, int index, List<String> result) {
		if (left == 0 && right == 0) {
			result.add(new String(cur));
			return;
		}
		if (left > 0) {
			cur[index] = '(';
			dfs(left - 1, right, cur, index + 1, result);
		}
		if (right > left) {
			cur[index] = ')';
			dfs(left, right - 1, cur, index + 1, result);
		}
	}
}
