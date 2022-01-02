package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1832 {

    class Solution {
        public boolean checkIfPangram(String sentence) {
            int seen = 0;
            for (char c : sentence.toCharArray()) {
                seen = seen | (1 << c - 'a');
            }
            return seen == (1 << 26) - 1;
        }
    }
}
