package util;

import java.util.Arrays;

/**
 * @author half-dead
 */
class RangeMax {
    int start;
    int n;
    long[] t;

    // [low, high] inclusive
    public RangeMax(int low, int high) {
        start = low;
        n = high - low + 1;
        t = new long[n * 2 + 2];
        Arrays.fill(t, Long.MIN_VALUE);
    }

    long get(int index) {
        return t[index - start + n];
    }

    void set(int index, long value) {
        index -= start;
        for (t[index += n] = value; (index >>= 1) > 0; ) {
            t[index] = Math.max(t[index << 1], t[index << 1 | 1]);
        }
    }

    // [l, r] inclusive
    long getMax(int l, int r) {
        l -= start;
        r = (r + 1 - start); // make it as [l, r)
        long resl = Long.MIN_VALUE, resr = Long.MIN_VALUE;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) != 0) resl = Math.max(resl, t[l++]);
            if ((r & 1) != 0) resr = Math.max(t[--r], resr);
        }
        return Math.max(resl, resr);
    }
}
