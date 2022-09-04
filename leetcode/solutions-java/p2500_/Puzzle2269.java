package p2500_;

/**
 * https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 *
 * @author half-dead
 */
public class Puzzle2269 {
    class Solution {
        public int divisorSubstrings(int num, int k) {
            String s = "" + num;
            int ans = 0, n = s.length();
            for (int i = 0; i <= n - k; i++) {
                String temp = s.substring(i, i + k);
                int v = Integer.parseInt(temp);
                if (v != 0 && num % v == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
