package SegementTree;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SegementTreeTest {

	@Test
	public void testBuildSegmentTree() {

		int arr[] = { 1, 2, 3, 4, 5 };
		int segmentTree[] = { 0, 15, 6, 9, 3, 3, 4, 5, 1, 2 };
		SegmentTree st = new SegmentTree(arr);
		st.buildSegementTree();
		assertArrayEquals(segmentTree, st.getSegmentTree());
	}

	@Test
	public void testUpdateSegmentTree() {

		int arr[] = { 1, 2, 3, 4, 5 };
		SegmentTree st = new SegmentTree(arr);
		st.buildSegementTree();
		st.updateSegmentTree(3, 4);
		int newSegmentTree[] = { 0, 16, 7, 9, 3, 4, 4, 5, 1, 2 };
		assertArrayEquals(newSegmentTree, st.getSegmentTree());

	}

}
