package p2000_;

/**
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 *
 * @author half-dead
 */
public class Puzzle1545 {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1010101010101010101010101010101", 2));
    }

    // intuitive, brute force with recursion
    class Solution {
        public char findKthBit(int n, int k) {
            return (char) ('0' + recur((1 << n) - 1, k));
        }

        int recur(int n, int k) {
            int m = n >> 1;
            if (k <= m) return recur(m, k);
            if (k == m + 1) return n == 1 ? 0 : 1;
            return 1 - recur(m, n - k + 1);
        }
    }
}
