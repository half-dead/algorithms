package p2500_;

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 *
 * @author half-dead
 */
public class Puzzle2125 {

    class Solution {
        public int numberOfBeams(String[] bank) {
            int prev = 0, res = 0;
            for (String row : bank) {
                int cnt = 0;
                for (char c : row.toCharArray()) {
                    if (c == '1') cnt++;
                }
                res += prev * cnt;
                if (cnt > 0) {
                    prev = cnt;
                }
            }
            return res;
        }
    }
}
