package solution;

import java.util.*;
public class AllSubset {
	// print all subsets of a set
	// no duplicate elements
	public List<String> allSubsets(String input) {
		List<String> result = new ArrayList<>();
		if (input == null || input.length() == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		dfs(input, sb, 0, result);
		return result;
	}
	private void dfs(String input, StringBuilder sb, int index, List<String> result ) {
		
	}
}
