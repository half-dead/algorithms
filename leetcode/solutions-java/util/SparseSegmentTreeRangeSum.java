package util;

/**
 * @author half-dead
 */ // Tested by Leetcode 307
class SparseSegmentTreeRangeSum {
    private class TreeNode {
        TreeNode left, right;
        long sum;
    }

    private TreeNode root;
    private final long L, R;

    public SparseSegmentTreeRangeSum(long low, long high) {
        L = low;
        R = high;
        root = new TreeNode();
    }

    public void update(long position, long value) {
        update(position, value, L, R, root);
    }

    private void update(long position, long value, long L, long R, TreeNode root) {
        if (position < L || R < position) return;
        if (L == R) {
            root.sum = value;
            return;
        }
        long M = L + ((R - L) >>> 1);
        if (root.left == null) root.left = new TreeNode();
        if (root.right == null) root.right = new TreeNode();
        update(position, value, L, M, root.left);
        update(position, value, M + 1, R, root.right);
        root.sum = root.left.sum + root.right.sum;
    }

    // Sum[low...high] inclusive
    public long getSum(long low, long high) {
        return getSum(low, high, L, R, root);
    }

    // [low, high] is range of query, [L, R] are range of TreeNode.
    private long getSum(long low, long high, long L, long R, TreeNode root) {
        if (low > high || root == null) return 0L;
        if (low <= L && R <= high) {
            return root.sum;
        }
        long M = L + ((R - L) >>> 1);
        if (high <= M) {
            return getSum(low, high, L, M, root.left);
        } else if (M + 1 <= low) {
            return getSum(low, high, M + 1, R, root.right);
        } else {
            return getSum(low, high, L, M, root.left) + getSum(low, high, M + 1, R, root.right);
        }
    }
}
