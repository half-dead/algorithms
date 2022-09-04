package p2500_;

/**
 * https://leetcode.com/problems/calculate-digit-sum-of-a-string/
 *
 * @author half-dead
 */
public class Puzzle2243 {

    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                int i = 0, len = s.length();
                String temp = "";
                while (i < len) {
                    String part = s.substring(i, Math.min(i + k, len));
                    int sum = 0;
                    for (char c : part.toCharArray()) {
                        sum += c - '0';
                    }
                    temp += sum;
                    i += k;
                }
                s = temp;
            }
            return s;
        }
    }
}
