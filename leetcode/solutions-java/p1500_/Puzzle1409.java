package p1500_;

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/
 *
 * @author half-dead
 */
public class Puzzle1409 {
    class Solution {
        public int[] processQueries(int[] queries, int m) {
            int[] BIT = new int[2 * m + 1], pos = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                pos[i] = i + m;
                update(BIT, i + m, 1);
            }

            int len = queries.length, i = 0, n = m;
            int[] res = new int[len];
            for (int q : queries) {
                res[i++] = query(BIT, pos[q] - 1);
                update(BIT, pos[q], -1);
                pos[q] = n--;
                update(BIT, pos[q], 1);
            }
            return res;
        }

        private void update(int[] tree, int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += i & (-i);
            }
        }

        private int query(int[] tree, int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);
            }
            return sum;
        }
    }

    // BruteForce, O(N^2) time
    class Solution1 {
        public int[] processQueries(int[] queries, int m) {
            int[] idx = new int[m];
            for (int i = 0; i < m; i++) idx[i] = i;

            int[] res = new int[queries.length];
            int j = 0;
            for (int q : queries) {
                int pos = idx[q - 1], cnt = 0;
                for (int i = 0; i < m; i++) {
                    if (idx[i] < pos) {
                        idx[i]++;
                        cnt++;
                    }
                    if (cnt == pos) break;
                }
                idx[q - 1] = 0;

                res[j++] = pos;
            }
            return res;
        }
    }
}
