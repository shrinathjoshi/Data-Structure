package SegementTree;

public class SegmentTreeRunner {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };

		SegmentTree segmentTree = new SegmentTree(arr);
		segmentTree.buildSegementTree();

		int st[] = segmentTree.getSegmentTree();

		// Updating value at index=2 to 5
		segmentTree.updateSegmentTree(3, 4);

		int st1[] = segmentTree.getSegmentTree();

		for (int i : st1) {
			System.out.println(i);
		}
	}

}
