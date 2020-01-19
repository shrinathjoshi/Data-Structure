package SegementTree;

public class SegmentTree {
	int n;
	int segmentTree[];
	int elements[];

	public SegmentTree(int[] elements) {
		this.n = elements.length;
		this.segmentTree = new int[2 * this.n];
		this.elements = new int[this.n];
		System.arraycopy(elements, 0, this.elements, 0, this.n);
	}

	public void buildSegementTree() {
		this.buildSegmentTreeRecursively(1, this.n, 1);
	}

	private void buildSegmentTreeRecursively(int start, int end, int position) {

		if (start == end) {
			this.segmentTree[position] = this.elements[start - 1];
		} else {
			int middleIndex = (start + end) / 2;
			this.buildSegmentTreeRecursively(start, middleIndex, 2 * position);
			this.buildSegmentTreeRecursively(middleIndex + 1, end, (2 * position) + 1);
			this.segmentTree[position] = this.segmentTree[2 * position] + this.segmentTree[(2 * position) + 1];
		}
	}

	public void updateSegmentTree(int index, int newValue) {

		int diff = Math.abs(this.elements[index - 1] - newValue);
		this.elements[index - 1] = newValue;
		this.updateSegmentTreeRecursively(1, this.n, index, diff, 1);

	}

	private void updateSegmentTreeRecursively(int start, int end, int index, int diff, int position) {

		if ((index < start) || (index > end)) {
			return;
		}

		this.segmentTree[position] = this.segmentTree[position] + diff;

		if (start != end) {
			int middle = (start + end) / 2;
			this.updateSegmentTreeRecursively(start, middle, index, diff, 2 * position);
			this.updateSegmentTreeRecursively(middle + 1, end, index, diff, (2 * position) + 1);

		}
	}

	public int[] getSegmentTree() {
		return this.segmentTree;
	}
}
