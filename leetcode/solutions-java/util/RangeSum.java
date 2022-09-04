package util;

/**
 * @author half-dead
 */
class RangeSum {
    BinaryIndexTree tree;
    int start;

    // [low, high] inclusive
    public RangeSum(int low, int high) {
        start = low;
        tree = new BinaryIndexTree(high - low + 1);
    }

    public void add(int index, long value) {
        tree.add(index - start + 1, value);
    }

    public long get(int index) {
        return tree.getSum(index - start + 1) - tree.getSum(index - start);
    }

    public void set(int index, long value) {
        tree.add(index - start + 1, value - get(index));
    }

    // [l, r] inclusive
    public long getSum(int l, int r) {
        return tree.getSum(r - start + 1) - tree.getSum(l - start);
    }
}
