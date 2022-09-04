package p2500_;

/**
 * https://leetcode.com/problems/apply-discount-to-prices/
 *
 * @author half-dead
 */
public class Puzzle2288 {

    public static void main(String[] args) {

    }

    class Solution {
        public String discountPrices(String sentence, int discount) {
            String[] words = sentence.split(" ");
            double d = 0.01D * (100 - discount);
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.charAt(0) == '$' && isAllDigit(word)) {
                    long orig = Long.parseLong(word.substring(1));
                    double price = orig * d;
                    words[i] = String.format("$%.2f", price);
                }
            }
            return String.join(" ", words);
        }

        boolean isAllDigit(String w) {
            if (w.length() < 2) return false;
            for (int i = 1; i < w.length(); i++) {
                char c = w.charAt(i);
                if (c < '0' || c > '9') return false;
            }
            return true;
        }
    }
}
