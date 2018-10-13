package solution;

public class CheckBST {
	// Determine if a binary tree is a binary search tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	private boolean isBST(TreeNode root, int max, int min) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
	}
	
	// Method 2: check inorder traversal
	public boolean isBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		TreeNode[] prev = {null};
		boolean[] flag = {true};
		isBST1(root, prev, flag);
		return flag[0];
	}
	private void isBST1(TreeNode root, TreeNode[] prev, boolean[] flag) {
		if (root == null || !flag[0]) {
			return;
		}
		isBST1(root.left, prev, flag);
		if (prev[0] != null && prev[0].val >= root.val) {
			flag[0] = false;
			return;
		}
		prev[0] = root;
		isBST1(root.right, prev, flag);
	}
}
