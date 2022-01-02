package p1500_;

import java.util.Arrays;

/**
 * Maximum Number of Balloons
 * https://leetcode.com/problems/maximum-number-of-balloons/
 *
 * @author half-dead
 */
public class Puzzle1189 {
    class Solution {
        public int maxNumberOfBalloons(String text) {
            // ablno
            int[] count = new int[5];
            for (char c : text.toCharArray()) {
                switch (c) {
                    case 'a':
                        count[0]++;
                        break;
                    case 'b':
                        count[1]++;
                        break;
                    case 'l':
                        count[2]++;
                        break;
                    case 'n':
                        count[3]++;
                        break;
                    case 'o':
                        count[4]++;
                        break;
                    default:
                        break;
                }
            }
            count[2] >>= 1;
            count[4] >>= 1;
            Arrays.sort(count);
            return count[0];
        }
    }
}
