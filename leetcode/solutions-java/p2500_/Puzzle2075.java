package p2500_;

/**
 * https://leetcode.com/problems/decode-the-slanted-ciphertext/
 *
 * @author half-dead
 */
public class Puzzle2075 {

    class Solution {
        public String decodeCiphertext(String encodedText, int rows) {
            int n = encodedText.length(), m = n / rows;
            if (n == 0) return "";

            StringBuilder sb = new StringBuilder();
            int r = 0, c = 0, start = 0;
            while (start < m) {
                int i = r * m + c;
                sb.append(encodedText.charAt(i));
                r++;
                c++;
                if (r == rows || c == m) {
                    r = 0;
                    c = ++start;
                }
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }
}
