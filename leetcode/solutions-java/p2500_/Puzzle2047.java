package p2500_;

/**
 * https://leetcode.com/problems/number-of-valid-words-in-a-sentence/submissions/
 *
 * @author half-dead
 */
public class Puzzle2047 {

    public static void main(String[] args) {
        Solution s = new Puzzle2047().new Solution();
        System.out.println(s.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    class Solution {
        public int countValidWords(String sentence) {
            int res = 0;
            String[] tokens = sentence.split(" ");
            java.util.regex.Pattern p = java.util.regex.Pattern.compile("^([a-z]+([-][a-z]+)?)?[!.,]?$");
            for (String token : tokens) {
                if (token.length() > 0 && p.matcher(token).matches())
                    res++;
            }
            return res;
        }
    }
}
