package p0500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/
 *
 * @author half-dead
 */
public class Puzzle454_4SumII {

    class Solution {
        public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
            Map<Integer, Integer> ma = sum2(a, b);
            int count = 0;
            for (int ic : c) {
                for (int id : d) {
                    int num = -(ic + id);
                    if (ma.containsKey(num)) {
                        count += ma.get(num);
                    }
                }
            }
            return count;
        }

        private Map<Integer, Integer> sum2(int[] a, int[] b) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int ia : a)
                for (int ib : b) {
                    int ab = ia + ib;
                    map.put(ab, map.getOrDefault(ab, 0) + 1);
                }
            return map;
        }
    }

    class Solution2 {
        public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
            int[] m = new int[a.length * b.length], n = new int[c.length * d.length];
            int i = 0;
            for (int ia : a) for (int ib : b) m[i++] = ia + ib;
            i = 0;
            for (int ic : c) for (int id : d) n[i++] = ic + id;
            Arrays.sort(m);
            Arrays.sort(n);
            int mi = 0, ni = n.length - 1;
            int count = 0;
            while (mi < m.length && ni >= 0) {
                while (mi < m.length && m[mi] + n[ni] < 0) {
                    mi++;
                }
                if (mi < m.length) {
                    while (ni >= 0 && m[mi] + n[ni] > 0) {
                        ni--;
                    }
                }
                if (mi < m.length && ni >= 0 && m[mi] + n[ni] == 0) {
                    int cm = 1, cn = 1;
                    while (mi < m.length - 1 && m[mi] == m[mi + 1]) {
                        mi++;
                        cm++;
                    }
                    while (ni > 0 && n[ni] == n[ni - 1]) {
                        ni--;
                        cn++;
                    }
                    count += cm * cn;
                    mi++;
                    ni--;
                }
            }
            return count;
        }
    }
}
