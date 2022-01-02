package p2000_;

/**
 * https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
 *
 * @author half-dead
 */
public class Puzzle1894 {

    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long sum = 0L;
            for (int n : chalk) {
                sum += n;
            }
            if (sum <= k) {
                k %= sum;
            }
            for (int i = 0; i < chalk.length; i++) {
                if (chalk[i] > k) {
                    return i;
                }
                k -= chalk[i];
            }
            return 0;
        }
    }
}
