package p0500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * @author half-dead
 */
public class Puzzle279_PerfectSquares {
    public static void main(String[] args) {
        Puzzle279_PerfectSquares p = new Puzzle279_PerfectSquares();
        Solution s = p.new Solution();
//        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(34578));
    }

    // mathimatical solution
    // Based on Lagrange's Four Square theorem, there are only 4 possible results: 1, 2, 3, 4.
    class Solution {
        public int numSquares(int n) {
            if (isSquare(n)) return 1;
            while (n % 4 == 0) n >>>= 2;
            if (n % 8 == 7) return 4;
            for (int m = 1, square = 1; square < n; square = ++m * m) if (isSquare(n - square)) return 2;
            return 3;
        }

        private boolean isSquare(int n) {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        }
    }

    class Solution1 {
        Map<Integer, Integer> map = new HashMap<>();

        public int numSquares(int n) {
            if (n < 4) return n;
            int sqrt = (int) Math.floor(Math.sqrt(n));
            if (sqrt * sqrt == n) return 1;

            if (map.containsKey(n)) return map.get(n);

            int min = Integer.MAX_VALUE;
            while (sqrt > 0) {
                int square = sqrt * sqrt, count = n / square;
                if (count >= min) break;
                count += numSquares(n % square);
                min = Math.min(count, min);
                sqrt--;
            }
            map.put(n, min);
            return min;
        }
    }

    public class Solution2 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
            return dp[n];
        }
    }

}
