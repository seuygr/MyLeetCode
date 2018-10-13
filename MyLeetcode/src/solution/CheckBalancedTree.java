package solution;

public class CheckBalancedTree {
	// Given a binary tree, determine if it is height-balanced.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Naive way with O(nlogn) time and O(height) space
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	private int getHeight(TreeNode root) {
		 if (root == null) {
			 return 0;
		 }
		 return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	// Better method with O(n) time
	public boolean isBalanced1(TreeNode root) {
		if (root == null) {
			return true;
		}
		return getHeight1(root) != -1;
	}
	// return -1, means the subtree is not balanced
	// otherwise, return a value representing the height of current root
	private int getHeight1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		if (left == -1) {
			return -1;
		}
		int right = getHeight(root.right);
		if (right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
