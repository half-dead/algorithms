package p1500_;

/**
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 *
 * @author half-dead
 */
public class Puzzle1419 {

    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int c = 0, r = 0, o = 0, a = 0, max = 0;
            for (char ch : croakOfFrogs.toCharArray()) {
                switch (ch) {
                    case 'c':
                        ++c;
                        break;
                    case 'r':
                        if (c < ++r) return -1;
                        break;
                    case 'o':
                        if (r < ++o) return -1;
                        break;
                    case 'a':
                        if (o < ++a) return -1;
                        break;
                    case 'k':
                        max = Math.max(max, c--);
                        r--;
                        o--;
                        a--;
                }
            }
            return (c == 0 && r == 0 && o == 0 && a == 0) ? max : -1;
        }
    }
}
