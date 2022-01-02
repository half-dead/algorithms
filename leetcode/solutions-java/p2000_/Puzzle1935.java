package p2000_;

/**
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/
 *
 * @author half-dead
 */
public class Puzzle1935 {

    class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            char[] bl = brokenLetters.toCharArray();
            int res = 0;
            for (String word : text.split(" ")) {
                boolean broken = false;
                for (char bc : bl) {
                    if (word.indexOf(bc) != -1) {
                        broken = true;
                        break;
                    }
                }
                if (!broken) res++;
            }
            return res;
        }
    }
}
