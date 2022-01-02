package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 *
 * @author half-dead
 */
public class Puzzle1414 {

    class Solution {
        public int findMinFibonacciNumbers(int k) {
            if (k <= 3) return 1;
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);

            int i = 0, j = 1, n = 1, res = 0;
            while (n < k) {
                n = list.get(i++) + list.get(j++);
                list.add(n);
            }

            while (k > 0) {
                n = list.get(j--);
                if (n <= k) {
                    k -= n;
                    res++;
                }
            }
            return res;
        }
    }
}
