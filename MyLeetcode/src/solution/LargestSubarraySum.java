package solution;

import java.util.*;
public class LargestSubarraySum {
	// DP
	public int largestSubarray(int[] array) {
		// largest[i] represents the largest subarray sum ending at index i
		int[] largest = new int[array.length];
		largest[0] = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] < 0) {
				largest[i] = array[i];
			} else {
				largest[i] = array[i] + array[i - 1];
			}
			if (largest[i] > max) {
				max = largest[i];
			}
		}
		return max;
	}
	// largest subarray sum of a circular array
	// 反向思考 求最小 和 最大
	//public int largestSumCircular(int[] array) {
		
	//}
	// largest subarray product
	// largest[i] = largest subarray product ending at index i
	// smallest[i] = smallest subarray product ending at index i
	
}



