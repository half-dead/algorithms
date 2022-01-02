package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers/
 *
 * @author half-dead
 */
public class Puzzle2094 {

    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            int[] freq = new int[10];
            for (int d : digits) freq[d]++;

            List<Integer> list = new ArrayList<>();
            for (int v = 100; v < 1000; v += 2) {
                boolean possible = true;
                for (int x = v; x > 0; x /= 10) {
                    if (freq[x % 10]-- == 0) possible = false;
                }

                if (possible) {
                    list.add(v);
                }

                for (int x = v; x > 0; x /= 10) {
                    freq[x % 10]++;
                }
            }

            int[] res = new int[list.size()];
            int i = 0;
            for (int v : list) {
                res[i++] = v;
            }
            return res;

        }
    }
}
