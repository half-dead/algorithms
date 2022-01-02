package p2500_;

/**
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 *
 * @author half-dead
 */
public class Puzzle2024 {

    // two pass, sliding window
    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            char[] dict = new char[]{'T', 'F'};
            char[] cs = answerKey.toCharArray();

            int ans = 0, n = cs.length;
            for (char target : dict) {
                int left = 0, right = 0, op = 0;

                while (left < n && right < n) {
                    if (cs[right++] != target) op++;

                    while (op > k) {
                        if (cs[left++] != target) op--;
                    }
                    ans = Math.max(ans, right - left);
                }
            }
            return ans;
        }
    }
}
