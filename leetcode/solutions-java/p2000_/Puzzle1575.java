package p2000_;

/**
 * https://leetcode.com/problems/count-all-possible-routes/
 *
 * @author half-dead
 */
public class Puzzle1575 {

    public static void main(String[] args) {
        Solution solution = new Puzzle1575().new Solution();
        System.out.println(solution.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
    }

    class Solution {
        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            if (Math.abs(locations[start] - locations[finish]) < fuel) return 0;

            int mod = (int) 1e9 + 7, n = locations.length, res = 0;
            int[][] dp = new int[n][fuel + 1];
            dp[start][fuel] = 1;
            while (true) {
                int[][] temp = new int[n][fuel + 1];
                boolean end = true;
                for (int from = 0; from < n; from++) {
                    for (int to = 0; to < n; to++) {
                        if (from == to) continue;
                        int cost = Math.abs(locations[from] - locations[to]);
                        for (int f = cost; f <= fuel; f++) {
                            if (dp[from][f] == 0) continue;
                            end = false;
                            temp[to][f - cost] += dp[from][f];
                            temp[to][f - cost] %= mod;
                        }
                    }
                }
                dp = temp;
                for (int x : dp[finish]) {
                    res = (res + x) % mod;
                }
                if (end) break;
            }
            return res;
        }
    }
}
