// SOLUTION
package de.unistuttgart.vis.dsass2021.ex06.p4;

public class HeapSortCheckerList<T extends Comparable<T>> extends
		AbstractSortCheckerList<T> {

	@Override
	public void sort() {
		for (int i = this.size() / 2; i >= 0; i--) {
			percolate(i, this.size());
		}
		for (int i = this.size() - 1; i > 0; i--) {
			// Swap last element with the first
			this.swap(0, i);
			// Create heap from element 0 to i
			percolate(0, i);
		}
	}

	private void percolate(int idx, int last) {
		int i = idx + 1, j;
		while (2 * i <= last) {
			// f[i] has left child
			j = 2 * i;
			// f[j] is left child of f[i]
			if (j < last) {
				// f[i] has also right child
				if (this.get(j - 1).compareTo(this.get(j)) < 0) { // Compare
																	// children
					j++;
					// f[j] is now greater
				}
			}
			if (this.get(i - 1).compareTo(this.get(j - 1)) < 0) {
				// Compare parent with child
				this.swap(i - 1, j - 1);
				i = j;
				// Sift further
			} else {
				// Stop when heap property if fulfilled
				break;
			}
		}
	}

}
