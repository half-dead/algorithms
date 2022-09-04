package util;

/**
 * @author half-dead
 */ // Tested by Leetcode 239
class SparseSegmentTreeRangeMax {
    private class TreeNode {
        TreeNode left, right;
        long max = Long.MIN_VALUE;
    }

    private TreeNode root;
    private final long L, R;

    public SparseSegmentTreeRangeMax(long low, long high) {
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
            root.max = value;
            return;
        }

        long M = L + ((R - L) >>> 1);
        if (root.left == null) root.left = new TreeNode();
        if (root.right == null) root.right = new TreeNode();
        update(position, value, L, M, root.left);
        update(position, value, M + 1, R, root.right);
        root.max = Math.max(root.left.max, root.right.max);
    }

    // Max[low...high] inclusive
    public long getMax(long low, long high) {
        return getMax(low, high, L, R, root);
    }

    // [low, high] is range of query, [L, R] are range of TreeNode.
    private long getMax(long low, long high, long L, long R, TreeNode root) {
        if (low > high || root == null) return Long.MIN_VALUE;
        if (low <= L && R <= high) {
            return root.max;
        }
        long M = L + ((R - L) >>> 1);
        if (high <= M) {
            return getMax(low, high, L, M, root.left);
        } else if (M + 1 <= low) {
            return getMax(low, high, M + 1, R, root.right);
        } else {
            return Math.max(getMax(low, high, L, M, root.left), getMax(low, high, M + 1, R, root.right));
        }
    }
}
