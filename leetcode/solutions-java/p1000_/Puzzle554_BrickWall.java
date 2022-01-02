/*
https://leetcode.com/problems/brick-wall/description/
 */

package p1000_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author half-dead
 */
public class Puzzle554_BrickWall {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> sums = new HashMap<>(wall.get(0).size());
            int maxSum = 0;
            for (List<Integer> row : wall) {
                int sum = 0;
                for (int w : row) {
                    sum += w;
                    sums.put(sum, sums.getOrDefault(sum, 0) + 1);
                }
                maxSum = sum;
            }
            sums.remove(maxSum);
            int max = 0;
            for (int occurance : sums.values()) {
                if (max < occurance) {
                    max = occurance;
                }
            }
            return wall.size() - max;
        }
    }
}
