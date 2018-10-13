package solution;

import java.util.Arrays;

public class Umbrellas {
	public static void main(String[] args) {
		System.out.print(getCombination(3, new int[] {3,2,2}));
	}
	private static int getCombination(int n, int[] p) {
		int result = -1;
		int count = 0;
		Arrays.sort(p);
		for (int i = p.length-1; i >= 0; i--) {
			count = count + p[i];
			int currentVal = 0;
			if(p[i] == n) {
				result = 1;
				break;
			}
			if(n > p[i]) {
				if(n % p[i] == 0) {
					currentVal = n / p[i];
				} else {
					int compute= n / p[i];
					int itr = compute;
					while (itr >= 1) {
						int rem = n - itr * p[i];
						int sum2 = itr * p[i];
						boolean flag = false;
						int inc = 0;
						for(int k = i-1; k >= 0; k--) {
							if(rem == p[k]) {
								currentVal = itr + 1;
								flag = true;
								break;
							} else if(rem % p[k] == 0) {
								currentVal = itr + (rem / p[k]);
								flag = true;
								break;
							} else {
								sum2 = sum2 + p[k];
								if (sum2 > n) {
									break;
								}
								inc++;
								if(sum2 == n) {
									currentVal = itr + inc;
									flag = true;
								}
							}
						}								
						if(result == -1 && flag == true) {
							result = currentVal;
						}
						else if(result > currentVal && currentVal != 0) {
							result = currentVal;
						}
						itr--;
					}
				}
			}
			if(result == -1 && currentVal != 0) {
				result = currentVal;
			} else if (result != -1 &&  currentVal != 0 && result >= currentVal)
				result = currentVal;
		}
		if(count == n && result == -1) {
			result = p.length; 
		}
		return result;
	}
}
