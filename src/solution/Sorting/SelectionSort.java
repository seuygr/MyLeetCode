package solution.Sorting;

public class SelectionSort {
	// Given an array of integers, sort the elements in the array in ascending order.
	// The selection sort algorithm should be used to solve this problem.
	public int[] selectionSort(int[] array) {
	    if (array == null || array.length == 0) {
	        return array;
	      }
	      for (int i = 0; i < array.length - 1; i++) {
	        int min = i;
	        for (int j = i + 1; j < array.length; j++) {
	          if (array[j] < array[min]) {
	            min = j;
	          }
	        }
	        int tmp = array[i];
	        array[i] = array[min];
	        array[min] = tmp;
	      }
	      return array;
	}
}
