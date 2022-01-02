package p1500_;

/**
 * https://leetcode.com/problems/distance-between-bus-stops/
 *
 * @author half-dead
 */
public class Puzzle1184 {
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int from = Math.min(start, destination), to = Math.max(start, destination), total = 0, sum = 0;
            for (int i = 0; i < distance.length; i++) {
                total += distance[i];
                if (i >= from && i < to) sum += distance[i];
            }
            return Math.min(sum, total - sum);
        }
    }
}
