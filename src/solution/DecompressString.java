package solution;

public class DecompressString {
	// Given a string in compressed form, decompress it to the original string. 
	// The adjacent repeated characters in the original string are compressed 
	// to have the character followed by the number of repeated occurrences. 
	// If the character does not have any adjacent repeated occurrences, it is not compressed.
	public String decompress(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = new char[find(input)];
		int end = 0;
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur > '2' && cur <= '9') {
				int c = cur - '0';
				while (c > 1) {
					array[end++] = input.charAt(i - 1);
					c--;
				}
			} else if (cur == '2') {
				array[end++] = input.charAt(i - 1);
			} else {
				array[end++] = input.charAt(i);
			}
		}
		return new String(array);
	}
	private int find(String input) {
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur > '2' && cur <= '9') {
				sum += cur - '0' - 1;
			} else {
				sum++;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		String one = "a3p2lec3n";
		DecompressString sol = new DecompressString();
		System.out.print(sol.decompress(one));
	}
}
