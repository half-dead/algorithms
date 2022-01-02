package p2000_;

/**
 * https://leetcode.com/problems/reformat-phone-number/
 *
 * @author half-dead
 */
public class Puzzle1694 {

    class Solution {
        public String reformatNumber(String number) {
            number = number.replaceAll(" ", "").replaceAll("-", "");
            if (number.length() < 4) return number;

            int tail = 0;
            if (number.length() % 3 == 1) tail = 4;
            else if (number.length() % 3 == 2) tail = 2;

            String tails = number.substring(number.length() - tail);
            number = number.substring(0, number.length() - tail);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                sb.append(number.charAt(i));
                if (i % 3 == 2 && (tail > 0 || i + 1 < number.length()))
                    sb.append("-");
            }
            if (tail == 2) sb.append(tails);
            else if (tail == 4) sb.append(tails, 0, 2).append("-").append(tails, 2, 4);
            return sb.toString();
        }
    }
}
