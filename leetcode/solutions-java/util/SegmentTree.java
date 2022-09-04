package util;

/**
 * @author half-dead
 */ // SegmentTree for Range Query Sum
// Tested by https://leetcode.com/problems/range-sum-query-mutable/
class SegmentTree {
    private int size;
    private int[] nodes;

    // 0 ... n - 1
    public SegmentTree(int[] input) {
        this.size = input.length;
        this.nodes = new int[this.size * 4];
        build(0, 0, size - 1, input);
    }

    private void build(int x, int l, int r, int[] input) {
        if (l == r) {
            nodes[x] = input[l]; //// TODO
            return;
        }

        int m = (l + r) >> 1;
        build(x * 2 + 1, l, m, input);
        build(x * 2 + 2, m + 1, r, input);
        nodes[x] = nodes[x * 2 + 1] + nodes[x * 2 + 2]; //// TODO
    }

    public void update(int pos, int value) {
        update(0, 0, size - 1, pos, value);
    }

    private void update(int x, int l, int r, int pos, int value) {
        if (l == r) {
            nodes[x] = value; //// TODO
            return;
        }
        int m = (l + r) >> 1;
        if (pos <= m) update(x * 2 + 1, l, m, pos, value);
        else update(x * 2 + 2, m + 1, r, pos, value);
        nodes[x] = nodes[x * 2 + 1] + nodes[x * 2 + 2]; //// TODO
    }

    public int query(int queryL, int queryR) {
        return query(0, 0, size - 1, queryL, queryR);
    }

    private int query(int x, int l, int r, int queryL, int queryR) {
        if (queryL <= l && r <= queryR) {
            return nodes[x];
        }
        int m = (l + r) >> 1;
        if (queryR <= m) return query(x * 2 + 1, l, m, queryL, queryR);
        else if (m + 1 <= queryL) return query(x * 2 + 2, m + 1, r, queryL, queryR);
        else return query(x * 2 + 1, l, m, queryL, queryR) + query(x * 2 + 2, m + 1, r, queryL, queryR); //// TODO
    }
}
