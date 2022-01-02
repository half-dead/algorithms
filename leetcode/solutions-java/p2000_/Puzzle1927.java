package p2000_;

/**
 * https://leetcode.com/problems/sum-game/
 *
 * @author half-dead
 */
public class Puzzle1927 {

    // greedy
    // alice's strategy: place '9' on the larger side, '0' on the smaller side
    // bob's strategy: do the contrary of alice
    // so, in the end, every two '?' will be replaced to one '0' and one '9'
    class Solution {
        public boolean sumGame(String num) {
            int n = num.length(), qLeft = 0, qRight = 0, sumLeft = 0, sumRight = 0;
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                char ci = num.charAt(i), cj = num.charAt(j);
                if (ci == '?') qLeft++;
                else sumLeft += (ci - '0');

                if (cj == '?') qRight++;
                else sumRight += (cj - '0');
            }
            sumLeft += (qLeft / 2) * 9;
            sumRight += (qRight / 2) * 9;
            return (qLeft + qRight) % 2 == 1 || sumLeft != sumRight;
        }
    }
}
