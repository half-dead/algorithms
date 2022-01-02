package p1000_;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * @author half-dead
 */
public class Puzzle990 {

    class Solution {
        public boolean equationsPossible(String[] equations) {
            int[] dsu = new int[128];
            for (char c = 'a'; c <= 'z'; c++) dsu[c] = c;

            for (String eq : equations) {
                if (eq.charAt(1) == '=') {
                    union(dsu, eq.charAt(0), eq.charAt(3));
                }
            }

            for (String eq : equations) {
                if (eq.charAt(1) == '!') {
                    int a = find(dsu, eq.charAt(0));
                    int b = find(dsu, eq.charAt(3));
                    if (a == b) return false;
                }
            }
            return true;
        }

        void union(int[] dsu, int a, int b) {
            if (dsu[a] != dsu[b]) {
                dsu[find(dsu, dsu[a])] = find(dsu, dsu[b]);
            }
        }

        int find(int[] dsu, int c) {
            while (dsu[c] != c) {
                int n = dsu[c];
                dsu[c] = find(dsu, n);
                c = n;
            }
            return dsu[c];
        }
    }
}
