package de.unistuttgart.dsass2021.ex09.p4;

/**
 * This class implements the function to compute the bayer moore tables.
 */
public class BMTables {

	/**
	 * Create the last table based on the given pattern.
	 *
	 * The returned array shall contain 256 values each char is determined by
	 * its char value.
	 *
	 * @param pattern the pattern to create the last table from
	 * @return the last table
	 */
	public static int[] initLast(String pattern) {
		int[] last = new int[256];
		int len = pattern.length();
		for(int i = 0; i < 256; i ++){
			last[i] = -1;
		}
		for(int i = 0; i < len; i ++){
			int character = (int)pattern.charAt(i);
			last[character] = i;
		}
		return last;
	}

	/**
	 * Compute the shift and suffix table based on the given input. These two
	 * results will be "returned" as parameter. This functions assume the
	 * suffix table and the shift table have at least one more element than the
	 * length of the pattern.
	 *
	 * @param pattern the pattern to create the shift and suffix table from
	 * @param shift   the returned shift table
	 * @param suffix  the returned suffix table
	 */
	public static void bmShiftSuffix(String pattern, int[] shift, int[] suffix) {
		int len = pattern.length();
		for(int i = 0; i < len ; i ++){
			shift[i] = Integer.MAX_VALUE;
			suffix[i] = Integer.MAX_VALUE;
		}

		suffix[len - 1 ] = len;

		for(int j = 1; j < len; j ++){
			int k = 0;
			while (k<= len - 1 - j && pattern.charAt(len - 1 - k)==pattern.charAt(len - 1 - j - k) ){
				k++;
			}
			if(k<= len - 1 - j){
				if(shift[len-1-k]>j){
					shift[len-1-k] = j;
				}
			}else if(k == len -j){
				for(int i = 0; i < len - j ;i++){
					if(shift[i] > j){
						shift[i] = j;
					}
				}
			}
			suffix[len - 1 - j] = k;
		}

		for(int index = 0; index < len; index ++){
			if(shift[index] == Integer.MAX_VALUE){
				shift[index] = len;
			}
		}
	}

	// code from Lehrbuch, used to check correctness of these two function
	public static int[] initShift(String pat) {
		int m = pat.length();
		int[ ] shift = new int[m + 1];
		int[ ] suffix = new int[m + 1];
		int i, j, h = 0;
		suffix[m - 1] = m;
		j = m - 1;
		for (i = m - 2; i >= 0; i--) {
			if (i > j && suffix[i + m - 1 - h] < i - j)
				suffix[i] = suffix[i + m - 1 - h];
			else {
				if (i < j)
					j = i;
				h = i;
				while (j >= 0 && pat.charAt(j) ==
						pat.charAt(j + m - 1 - h))
					j--;
				suffix[i] = h - j;
			}
		}
		for (i = 0; i < m; i++)
			shift[i] = m;
		j = 0;
		for (i = m - 1; i >= -1; i--)
			if (i == -1 || suffix[i] == i + 1)
				while (j < m - 1 - i) {
					if (shift[j] == m)
						shift[j] = m - 1 - i;
					j++;
				}
		for (i = 0; i < m - 1; i++)
			shift[m - 1 - suffix[i]] = m - i - 1;
		return shift;
	}

	public static int bmSearch(String text, String pattern){
		int[] last = initLast(pattern);
		int[] shift = new int[pattern.length()];
		int[] suffix = new int[pattern.length()];
		bmShiftSuffix(pattern, shift, suffix);

		int i = 0;
		while (i <= text.length() - pattern.length()){
			int j = pattern.length() - 1;
			while (j>=0 && pattern.charAt(j) == text.charAt(i + j)){
				j--;
			}
			if(j<0){
				return i;
			}
			int lastValue = j - last[(int)text.charAt(i+j)];
			int shiftValue = shift[j];
			i += Math.max(lastValue, shiftValue);
		}
		return -1;
	}
}
