package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

public class TwoSum {
	public int[] twoSum1(int[] array, int target) {
		// corner case check
		if (array == null || array.length == 0) {
			return new int[0];
		}
		
		// to use 2 pointers, make sure the array is sorted with O(n) time and O(1) space
		// notice: order of the array has changed, so may not be able to get the indices
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == target) {
				return new int[] {left, right};
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[0];
	}
	
	public int[] twoSum2(int[] array, int target) {
		// corner case check

		// brute method with O(n^2) time and O(1) space
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] + array[j] == target && i != j) {
					return new int[] {i, j};
				}
			}
		}
		return new int[0];
	}
	
	public int[] twoSum3(int[] array, int target) {
		// store all previous number and their indices in a hashmap
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(target - array[i])) {
				return new int[] {i, map.get(target - array[i])};
			}
			map.put(array[i], i);
		}
		return new int[0];
	}
	public static void main(String[] args) {
		int[] array = new int[] {1,4,5,2,3,6,9,13,7};
		TwoSum sol = new TwoSum();
		int target = 3;
		int[] result = sol.twoSum3(array, target);
		for (int num : result) {
			System.out.println(num);
		}
	}
}
