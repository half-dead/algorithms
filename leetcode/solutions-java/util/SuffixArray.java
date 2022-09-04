package util;

import java.util.Arrays;

/**
 * @author half-dead
 */
class SuffixArray {
    int[] s;
    int[] SA; // SA[i] => index of the i-th ranked suffix
    int[] rank; // rank[i] => the rank of i-th suffix, SA[rank[i]] == i
    int[] height; // height[i] = LCP(s[SA[i]], s[SA[i - 1]]).

    private int[][] d;
    private int n;
    private int[] lg;

    private int log2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public SuffixArray(int[] nums) {
        this.s = nums;
        this.n = nums.length;
        this.height = new int[n];
        this.d = new int[log2(n) + 1][n];
        this.lg = new int[n + 1];
        this.SA = new int[n];
        this.rank = new int[n];
        suffixSort(s);
        getHeight();
        buildRMQ();
    }

    // height[i] = LCP(s[SA[i]], s[SA[i - 1]]).
    // ?? s[n] = 0 or s[n] = -INF.
    private void getHeight() {
        int i, j, h;
        height[0] = 0;
        for (i = 0; i < n; i++)
            rank[SA[i]] = i;
        for (h = i = 0; i < n; i++)
            if (rank[i] > 0) {
                j = SA[rank[i] - 1];
                while (i + h < n && j + h < n && s[i + h] == s[j + h]) ++h;
                height[rank[i]] = h;
                if (h > 0) --h;
            }
    }

    // LCP(i, j) = LCP(s[SA[i]], s[SA[j]]) = min{height[k] | i + 1 <= k <= j}.
    private void buildRMQ() {
        int i, j, k;
        for (i = 0; i < n; i++)
            d[0][i] = height[i];
        for (j = 1; (1 << j) <= n; j++)
            for (i = 0; i + (1 << j) <= n; i++)
                d[j][i] = Math.min(d[j - 1][i], d[j - 1][i + (1 << (j - 1))]);
        for (lg[0] = k = 0, i = 1; i <= n; lg[i++] = k - 1)
            while ((1 << k) <= i) k++;
    }

    // LCP(i, j) = LCP(s[SA[i]], s[SA[j]]) = min{height[k] | i + 1 <= k <= j}.
    public int LCP(int i, int j) {
        if (i == j) return n - SA[i];
        if (i > j) {
            int t = i;
            i = j;
            j = t;
        }
        int k = lg[j - (++i) + 1];
        return Math.min(d[k][i], d[k][j - (1 << k) + 1]);
    }

    // LCPIndex(i, j) = LCP(s[i], s[j])
    public int LCPIndex(int i, int j) {
        return LCP(rank[i], rank[j]);
    }

    private void suffixSort(int[] s) {
        //int n = s.length;
        int[] count = new int[n], t;
        //this.SA = new int[n];
        //this.rank = new int[n];
        int[] nSA = new int[n];
        int[] nRank = new int[n];

        Integer[] tempArray = new Integer[n];
        for (int x = 0; x < n; x++) tempArray[x] = x;
        Arrays.sort(tempArray, (a, b) -> Integer.compare(s[a], s[b]));
        for (int x = 0; x < n; x++) SA[x] = tempArray[x];

        int i, k;
        for (rank[SA[0]] = 0, i = 1; i < n; i++) {
            rank[SA[i]] = (s[SA[i]] != s[SA[i - 1]]) ? rank[SA[i - 1]] + 1 : rank[SA[i - 1]];
        }
        for (k = 1; k < n && rank[SA[n - 1]] < n - 1; k <<= 1) {
            for (i = 0; i < n; i++) count[rank[SA[i]]] = i + 1;
            for (i = n - 1; i >= 0; i--) if (SA[i] >= k) nSA[--count[rank[SA[i] - k]]] = SA[i] - k;
            for (i = n - k; i < n; i++) nSA[--count[rank[i]]] = i;
            t = SA;
            SA = nSA;
            nSA = t;
            for (nRank[SA[0]] = 0, i = 1; i < n; i++) {
                nRank[SA[i]] = (SA[i] + k >= n || SA[i - 1] + k >= n || rank[SA[i]] != rank[SA[i - 1]] || rank[SA[i] + k] != rank[SA[i - 1] + k]) ? nRank[SA[i - 1]] + 1 : nRank[SA[i - 1]];
            }
            t = rank;
            rank = nRank;
            nRank = t;
        }
        //return SA;
    }
}
