package solution.Sorting;

public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotIndex = partition(array, left, right);
		quickSort(array, left, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, right);
	}
	private int partition(int[] array, int left, int right) {
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, right);
		int leftIndex = left;
		int rightIndex = right - 1;
		while (leftIndex <= rightIndex) {
			if (array[leftIndex] < pivot) {
				leftIndex++;
			} else if (array[rightIndex] > pivot) {
				rightIndex--;
			} else {
				swap(array, leftIndex++, rightIndex--);
			}
		}
		swap(array, leftIndex, right);
		return leftIndex;
	}
	
	private void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3, 5, 1, 2, 4, 8};
		QuickSort sol = new QuickSort();
		int[] result =sol.quickSort(array);
		for (int num : result) {
			System.out.println(num);
		}
		
	}
}
