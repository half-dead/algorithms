package p2500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intervals-between-identical-elements/
 *
 * @author half-dead
 */
public class Puzzle2121 {

    class Solution {
        public long[] getDistances(int[] arr) {
            int n = arr.length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
            }

            long[] res = new long[n];
            for (int key : map.keySet()) {
                List<Integer> indexes = map.get(key);
                int len = indexes.size() - 1;
                long[] intervals = new long[len];
                for (int i = 0; i < len; i++) {
                    intervals[i] = indexes.get(i + 1) - indexes.get(i);
                }

                long temp = 0L;
                for (int i = 0; i < len; i++) {
                    temp += (len - i) * intervals[i];
                }
                res[indexes.get(0)] = temp;

                for (int i = 1, a = len - 1; i < indexes.size(); i++) {
                    temp -= intervals[i - 1] * a;
                    res[indexes.get(i)] = temp;
                    a -= 2;
                }
            }
            return res;
        }
    }
}
