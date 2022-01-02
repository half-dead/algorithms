package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bag-of-tokens/
 *
 * @author half-dead
 */
public class Puzzle948 {
    public static void main(String[] args) {
        Solution s = new Puzzle948().new Solution();

        System.out.println(s.bagOfTokensScore(new int[]{26}, 51));
        System.out.println(s.bagOfTokensScore(new int[]{100}, 50));
        System.out.println(s.bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(s.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        System.out.println(s.bagOfTokensScore(new int[]{48, 87, 26}, 81));
    }

    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            int len = tokens.length;
            Arrays.sort(tokens);

            int left = 0, right = len - 1, max = 0, points = 0;
            while (left <= right) {
                if (power >= tokens[left]) {
                    power -= tokens[left++];
                    max = Math.max(max, ++points);
                } else if (points > 0) {
                    power += tokens[right--];
                    points--;
                } else break;
            }
            return max;
        }
    }
}
