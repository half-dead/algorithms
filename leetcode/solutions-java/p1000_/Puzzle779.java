package p1000_;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 *
 * @author half-dead
 */
public class Puzzle779 {

    class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) return 0;
            if (n == 2) return k - 1;
            int prev = kthGrammar(n - 1, (k + 1) / 2);
            return (prev + k) % 2 == 0 ? 1 : 0;
        }
    }
}
