package p1500_;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 *
 * @author half-dead
 */
public class Puzzle1262 {

    class Solution {
        public int maxSumDivThree(int[] nums) {
            int m0 = 0, m1 = 0, m2 = 0, n0, n1, n2;
            for (int num : nums) {
                n0 = m0;
                n1 = m1;
                n2 = m2;

                int mod = num % 3;
                if (mod == 0) {
                    n0 = m0 + num;
                    if (m1 > 0) n1 = m1 + num;
                    if (m2 > 0) n2 = m2 + num;
                } else if (mod == 1) {
                    if (m2 > 0) n0 = Math.max(m0, m2 + num);
                    n1 = Math.max(m1, m0 + num);
                    if (m1 > 0) n2 = Math.max(m2, m1 + num);
                } else {
                    if (m1 > 0) n0 = Math.max(m0, m1 + num);
                    if (m2 > 0) n1 = Math.max(m1, m2 + num);
                    n2 = Math.max(m2, m0 + num);
                }

                m0 = n0;
                m1 = n1;
                m2 = n2;
            }
            return m0;
        }
    }
}
