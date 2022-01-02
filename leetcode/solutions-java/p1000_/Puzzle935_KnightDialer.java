package p1000_;

/**
 * https://leetcode.com/problems/knight-dialer/
 *
 * @author half-dead
 */
public class Puzzle935_KnightDialer {
    public static void main(String[] args) {
        Puzzle935_KnightDialer p = new Puzzle935_KnightDialer();
        Solution s = p.new Solution();
        for (int i = 1; i < 150; i++) {
            System.out.println(s.knightDialer(i));
        }
    }

    class Solution {
        int[][] graph = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int mod = 1000000007;

        public int knightDialer(int n) {
            int[] begin = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            for (int i = 1; i < n; i++) {
                int[] next = new int[10];
                for (int j = 0; j < 10; j++)
                    for (int adjacent : graph[j])
                        next[adjacent] = (next[adjacent] + begin[j]) % mod;
                begin = next;
            }
            int count = 0;
            for (int num : begin) count = (count + num) % mod;
            return count;
        }
    }

}
