package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-good-days-to-rob-the-bank/
 *
 * @author half-dead
 */
public class Puzzle2100 {

    // two pass, O(n) time & space
    class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            List<Integer> res = new ArrayList<>();

            int n = security.length;
            int[] decr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && security[i - 1] >= security[i]) {
                    decr[i] = decr[i - 1] + 1;
                } else {
                    decr[i] = 0;
                }
            }

            int incr = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && security[i] <= security[i + 1]) {
                    incr++;
                } else {
                    incr = 0;
                }
                if (incr >= time && decr[i] >= time) res.add(i);
            }
            return res;
        }
    }
}
