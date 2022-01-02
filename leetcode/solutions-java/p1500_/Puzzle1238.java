package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/circular-permutation-in-binary-representation/
 *
 * @author half-dead
 */
public class Puzzle1238 {

    // gray code
    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 1 << n; ++i)
                res.add(start ^ i ^ i >> 1);
            return res;
        }
    }

    class DfsSolution {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> res = recur(n);
            int idx = res.indexOf(start);
            if (idx != 0) {
                reverse(res, 0, idx);
                reverse(res, idx + 1, res.size() - 1);
            }
            return res;
        }

        void reverse(List<Integer> list, int from, int to) {
            while (from < to) {
                int temp = list.get(from);
                list.set(from, list.get(to));
                list.set(to, temp);
                from++;
                to--;
            }
        }

        List<Integer> base = Arrays.asList(0, 1);

        List<Integer> recur(int n) {
            if (n == 1) {
                return base;
            }
            List<Integer> prev = recur(n - 1);
            List<Integer> res = new ArrayList<>(prev.size() * 2);
            res.addAll(prev);
            int significantOne = prev.size();
            for (int i = prev.size() - 1; i >= 0; i--) {
                res.add(significantOne | (prev.get(i)));
            }
            return res;
        }
    }
}
