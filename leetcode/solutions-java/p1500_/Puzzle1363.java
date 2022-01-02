package p1500_;

/**
 * https://leetcode.com/problems/largest-multiple-of-three/
 *
 * @author half-dead
 */
public class Puzzle1363 {

    class Solution {
        public String largestMultipleOfThree(int[] digits) {
            int[] cnt = new int[10], m1 = new int[]{1, 4, 7, 2, 5, 8}, m2 = new int[]{2, 5, 8, 1, 4, 7};
            int sum = 0;
            for (int d : digits) {
                cnt[d]++;
                sum += d;
            }

            // if sum % 3 == 1, try to remove one 147 or two 258
            // if sum % 3 == 2, try to remove one 258 or two 147
            while (sum % 3 != 0) {
                for (int i : sum % 3 == 1 ? m1 : m2) {
                    if (cnt[i] > 0) {
                        cnt[i]--;
                        sum -= i;
                        break;
                    }
                }
            }

            if (sum == 0) return cnt[0] > 0 ? "0" : "";

            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) while (cnt[i]-- > 0) sb.append(i);
            return sb.toString();
        }
    }
}
