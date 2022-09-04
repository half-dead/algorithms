package p2500_;

/**
 * https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
 *
 * @author half-dead
 */
public class Puzzle2259 {
    class Solution {
        public String removeDigit(String number, char digit) {
            int i = number.indexOf(digit), n = number.length();
            String res = number.substring(0, i) + number.substring(i + 1, n);
            while (i >= 0) {
                int ni = number.indexOf(digit, i + 1);
                if (ni > i + 1) {
                    String temp = number.substring(0, ni) + number.substring(ni + 1, n);
                    if (temp.compareTo(res) > 0) {
                        res = temp;
                    }
                }
                i = ni;
            }
            return res;
        }
    }

}
