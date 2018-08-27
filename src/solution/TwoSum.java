package solution;

import java.util.Arrays;

public class TwoSum {
	public boolean exist(int[] array, int target) {
		// corner case check
		if (array == null || array.length == 0) {
			return false;
		}
		
		// to use 2 pointers, make sure the array is sorted
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == target) {
				return true;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,4,5,2,3,6,9,13,7};
		TwoSum sol = new TwoSum();
		int target = 7;
		if (sol.exist(array, target)) {
			System.out.println("two sum exists");
		} else {
			System.out.println("no two sum");
		}
	}
}
