package p2000_;

/**
 * https://leetcode.com/problems/largest-merge-of-two-strings/
 *
 * @author half-dead
 */
public class Puzzle1754 {

    class Solution {
        public String largestMerge(String w1, String w2) {
            char[] cs1 = w1.toCharArray(), cs2 = w2.toCharArray();
            int m = cs1.length, n = cs2.length;

            char[] res = new char[n + m];
            int i = 0, j = 0, k = 0;
            while (i < m || j < n) {
                if (i < m && j < n) {
                    if (cs1[i] == cs2[j]) {
                        res[k++] = larger(cs1, cs2, i, j) ? cs1[i++] : cs2[j++];
                    } else {
                        res[k++] = cs1[i] > cs2[j] ? cs1[i++] : cs2[j++];
                    }
                } else {
                    res[k++] = i < m ? cs1[i++] : cs2[j++];
                }
            }
            return new String(res);
        }

        private boolean larger(char[] a, char[] b, int i, int j) {
            while (i < a.length && j < b.length) {
                if (a[i] != b[j]) {
                    return a[i] > b[j];
                } else {
                    i++;
                    j++;
                }
            }
            return i < a.length;
        }
    }
}
