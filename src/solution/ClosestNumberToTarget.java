package solution;

public class ClosestNumberToTarget {
	// Find the closest number to the target in a BST
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Method 1 with recursion
	public int findClosest(TreeNode root, int target) {
		TreeNode next = target < root.val ? root.left : root.right;
		if (next == null) {
			return root.val;
		}
		int closestVal = findClosest(next, target);
		
		return Math.abs(root.val - target) < Math.abs(closestVal - target) ?
				root.val : closestVal;
	}
	
	// Method 2 with iteration
	// maintain an optimal value and search in the BST
	public int findClosest1(TreeNode root, int target) {
		int closestVal = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(closestVal - target)) {
				closestVal = root.val;
			}
			root = target < root.val ? root.left : root.right;
		}
		return closestVal;
	}
}
