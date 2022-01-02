package p1000_;

/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 *
 * @author half-dead
 */
public class Puzzle825 {

    class Solution {
        public int numFriendRequests(int[] ages) {
            int[] cnt = new int[121];
            for (int age : ages) cnt[age]++;
            for (int age = 1; age <= 120; age++) cnt[age] += cnt[age - 1];

            int res = 0;
            for (int i = 15; i <= 120; i++) {
                int n = cnt[i] - cnt[i - 1],from = (i >> 1) + 7;
                if (n == 0) continue;
                if (n > 1) res += n * (n - 1);
                res += n * (cnt[i] - n - cnt[from]);
            }
            return res;
        }
    }
}
