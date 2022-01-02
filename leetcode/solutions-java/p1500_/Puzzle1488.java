package p1500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 *
 * @author half-dead
 */
public class Puzzle1488 {

    public static void main(String[] args) {
        Solution s = new Puzzle1488().new Solution();
        System.out.println(s.avoidFlood(new int[]{1, 0, 2, 0, 2, 1}));
    }

    class Solution {
        public int[] avoidFlood(int[] rains) {
            int len = rains.length;
            int[] ans = new int[len];
            Arrays.fill(ans, 1);

            // key: lake no, value: day index
            Map<Integer, Integer> fullLakes = new HashMap<>();
            // store indexes of days not raining
            TreeSet<Integer> sunnyDays = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                if (rains[i] != 0) {
                    ans[i] = -1;
                    Integer prev = fullLakes.put(rains[i], i);
                    if (prev != null) {
                        // the lake is already full, we have to choose a day from sunnyDays and dry this lake
                        // greedy approach, choose the smallest index greater than prev
                        Integer idx = sunnyDays.ceiling(prev);
                        if (idx == null) return new int[]{};

                        ans[idx] = rains[i];
                        sunnyDays.remove(idx);
                    }
                } else {
                    sunnyDays.add(i);
                }
            }

            return ans;
        }
    }

}
