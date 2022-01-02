package p1000_;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/beautiful-array/
 *
 * @author half-dead
 */
public class Puzzle932_BeautifulArray {

    // Divide And Conquer
    class Solution {
        public int[] beautifulArray(int n) {
            return dac(n, 1, 1);
        }

        int[] dac(int count, int begin, int step) {
            if (count == 1) {
                return new int[]{begin};
            } else if (count == 2) {
                return new int[]{begin, begin + step};
            } else if (count == 3) {
                return new int[]{begin, begin + step + step, begin + step};
            } else {
                int[] r = new int[count];
                int half = count >> 1, i = 0;
                for (int n : dac(half + count % 2, begin, step << 1)) {
                    r[i++] = n;
                }
                for (int n : dac(half, begin + step, step << 1)) {
                    r[i++] = n;
                }
                return r;
            }
        }
    }

    // Brilliant idea.
    class MathSolution {
        public int[] beautifulArray(int n) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            while (res.size() < n) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i : res) {
                    if (i * 2 - 1 <= n) {
                        tmp.add(i * 2 - 1);
                    }
                }
                for (int i : res) {
                    if (i * 2 <= n) {
                        tmp.add(i * 2);
                    }
                }
                res = tmp;
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }
}
