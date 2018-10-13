package solution.Sorting;

public class RainbowSort {
	// Given an array of balls, where the color of the balls can only be Red, Green or Blue, 
	// sort the balls such that all the Red balls are grouped on the left side, 
	// all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. 
	// (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		// left of i are all -1 [0, i)
		// between i and j are all 0 [i, j)
		// between j and k are unknown [j, k]
		// right of k are all 1 (k, array.length - 1]
		int i = 0;
		int j = 0;
		int k = array.length - 1;
		while (j <= k) {
			if (array[j] == -1) {
				swap(array, i++, j++);
			} else if (array[j] == 0) {
				j++;
			} else {
				swap(array, j, k--);
			}
		}
		return array;
	}
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
