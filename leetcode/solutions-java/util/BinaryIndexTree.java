package util;

/**
 * @author half-dead
 */
class BinaryIndexTree {
    private long[] c;
    private int n;

    // NOTE: index is from 1 to n. (NOT 0 .. n - 1)
    public BinaryIndexTree(int n) {
        this.n = n;
        this.c = new long[n + 1];
    }

    // Add value to position k, k is from 1 to n.
    public void add(int k, long value) {
        while (k <= n) {
            c[k] += value;
            k += (k & (k ^ (k - 1)));
        }
    }

    // k is from 1 to n.
    public long getSum(int k) {
        long sum = 0;
        while (k > 0) {
            sum += c[k];
            k -= (k & (k ^ (k - 1)));
        }
        return sum;
    }
}
