package util;

/**
 * @author half-dead
 */
class RMQ {
    // tested by LC 1438,239
    private static int log2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    long[][] d;
    boolean useMax;

    // useMax == true means RMQMax
    public RMQ(int[] input, boolean useMax) {
        int n = input.length;
        this.useMax = useMax;
        this.d = new long[log2(n) + 1][n];
        for (int i = 0; i < n; i++) d[0][i] = input[i];
        for (int j = 1; (1 << j) <= n; j++)
            for (int i = 0; i + (1 << j) <= n; i++)
                d[j][i] = useMax ? Math.max(d[j - 1][i], d[j - 1][i + (1 << (j - 1))]) : Math.min(d[j - 1][i], d[j - 1][i + (1 << (j - 1))]);
    }

    public RMQ(long[] input, boolean useMax) {
        int n = input.length;
        this.useMax = useMax;
        this.d = new long[log2(n) + 1][n];
        for (int i = 0; i < n; i++) d[0][i] = input[i];
        for (int j = 1; (1 << j) <= n; j++)
            for (int i = 0; i + (1 << j) <= n; i++)
                d[j][i] = useMax ? Math.max(d[j - 1][i], d[j - 1][i + (1 << (j - 1))]) : Math.min(d[j - 1][i], d[j - 1][i + (1 << (j - 1))]);
    }

    // i <= j, and index starts from 0.
    public long query(int i, int j) {
        int k = log2(j - i + 1);
        return useMax ? Math.max(d[k][i], d[k][j - (1 << k) + 1]) : Math.min(d[k][i], d[k][j - (1 << k) + 1]);
    }
}
