package p2500_;

/**
 * @author half-dead
 */
public class Puzzle2038 {

    class Solution {
        public boolean winnerOfGame(String colors) {
            char[] cs = colors.toCharArray();
            int n = cs.length, a = 0, b = 0;
            for (int i = 1; i < n - 1; i++) {
                if (cs[i - 1] == cs[i] && cs[i] == cs[i + 1]) {
                    if (cs[i] == 'A') a++;
                    else b++;
                }
            }
            return a > b;
        }
    }
}
