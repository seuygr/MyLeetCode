package solution;

import java.util.*;
public class Contiguous_Array {
	// Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
    public int findMaxLength(int[] nums) {
        if (nums == null) {
        	return 0;
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		nums[i] = -1;
        	}
        }
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (sumToIndex.containsKey(sum)) {
        		result = Math.max(result, i - sumToIndex.get(sum));
        	} else {
        		sumToIndex.put(sum, i);
        	}
        }
        return result;
    }
}
