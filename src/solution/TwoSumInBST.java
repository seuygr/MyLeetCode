package solution;

import java.util.*;
public class TwoSumInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Method 1 with a hashtable to save the values of the BST
	// O(n) time and O(n) space
	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<>();
		return dfs(root, set, k);
	}
	private boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
		if (root == null) {
			return true;
		}
		if (set.contains(k - root.val)) {
			return true;
		}
		set.add(root.val);
		return dfs(root.left, set, k) || dfs(root.right, set, k);
	}
	
	// Method 2 with inorder traversal
	public boolean findTarget1(TreeNode root, int k) {
		if (root == null) {
			return true;
		}
		List<Integer> num = new ArrayList<>();
		inorder(root, num);
		int left = 0;
		int right = num.size() - 1;
		while (left <= right) {
			int sum = num.get(left) + num.get(right);
			if (sum == k) {
				return true;
			} else if (sum < k) {
				left++;
			} else {
				right--;
			}
		}
		return false;
		
	}
	private void inorder(TreeNode root, List<Integer> num) {
		if (root == null) {
			return;
		}
		inorder(root.left, num);
		num.add(root.val);
		inorder(root.right, num);
	}
	
	// Method 3 with binary search
	// O(n * height) time and O(h) space
	public boolean findTarget2(TreeNode root, int k) {
		return dfs1(root, root, k);
	}
	private boolean dfs1(TreeNode root, TreeNode cur, int k) {
		if (cur == null) {
			return false;
		}
		return search(root, cur, k - cur.val) 
				|| dfs1(root, cur.left, k) 
				|| dfs1(root, cur.right, k);
	}
	private boolean search(TreeNode root, TreeNode cur, int value) {
		if (root == null) {
			return false;
		}
		return (root.val == value) && (root != cur) 
				|| 
				(root.val < value) && search(root.right, cur, value)
				||
				(root.val > value) && search(root.left, cur, value);
	}
}
