package p2500_;

/**
 * https://leetcode.com/problems/watering-plants/
 *
 * @author half-dead
 */
public class Puzzle2079 {

    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int n = plants.length, res = 0;
            int water = capacity, oneway = 1;
            for (int i = 0; i < n; i++) {
                water -= plants[i];
                res++;
                if (i + 1 < n && water < plants[i + 1]) {
                    res += oneway * 2;
                    water = capacity;
                }
                oneway++;
            }
            return res;
        }
    }
}
