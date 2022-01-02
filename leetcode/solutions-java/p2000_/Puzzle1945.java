package p2000_;

/**
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 *
 * @author half-dead
 */
public class Puzzle1945 {
    public static void main(String[] args) {
        Solution s = new Puzzle1945().new Solution();
        System.out.println(s.getLucky("leetcode", 2));
    }

    class Solution {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(1 + s.charAt(i) - 'a');
            }
            int sum = 0;
            while (k-- > 0) {
                sum = 0;
                for (int i = 0; i < sb.length(); i++) {
                    sum += sb.charAt(i) - '0';
                }
                sb = new StringBuilder("" + sum);
            }
            return sum;
        }
    }
}
