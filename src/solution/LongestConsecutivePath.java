package solution;

public class LongestConsecutivePath {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// Method 1 with O(n) time and O(height) space
	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		dfs(root, root.val, 0, max);
		return max[0];		
	}
	private void dfs(TreeNode root, int value, int longest, int[] max) {
		if (root == null) {
			return;
		}
		if (value + 1 == root.val) {
			longest++;
		} else {
			longest = 1;
		}
		max[0] = Math.max(longest, max[0]);
		dfs(root.left, root.val, longest, max);
		dfs(root.right, root.val, longest, max);
	}
	
	// Method 2 
	public int longestConsecutive1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		dfs1(root, max);
		return max[0];
	}
	private void dfs1(TreeNode root, int[] max) {
		
	}
}
