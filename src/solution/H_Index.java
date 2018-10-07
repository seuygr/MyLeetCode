package solution;

public class H_Index {
	// Given an array of citations (each citation is a non-negative integer) of a researcher, 
	// write a function to compute the researcher's h-index.

	// According to the definition of h-index on Wikipedia: 
	// "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
    public int hIndex(int[] citations) {
        // bucket sort
    	if (citations == null || citations.length == 0) {
    		return 0;
    	}
    	int len = citations.length;
    	int[] buckets = new int[len + 1];
    	for (int i = 0; i < len; i++) {
    		if (citations[i] > len) {
    			buckets[len]++;
    		} else {
    			buckets[i]++;
    		}
    	}
    	
    	int sum = 0;
    	for (int i = len; i >= 0; i--) {
    		sum += buckets[i];
    		if (sum >= i) {
    			return i;
    		}
    	}
    	return 0;
    }
}
