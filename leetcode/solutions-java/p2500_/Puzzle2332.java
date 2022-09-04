package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/the-latest-time-to-catch-a-bus/
 *
 * @author half-dead
 */
public class Puzzle2332 {
    // greedy, simulation
    class Solution {
        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
            Arrays.sort(buses);
            Arrays.sort(passengers);

            int m = buses.length, n = passengers.length;
            int i = 0, j = 0;
            int res = 0;
            while (j < n) {
                while (i < m && buses[i] < passengers[j]) {
                    res = Math.max(res, buses[i++]);
                }

                if (i == m) break;

                int cnt = 0;
                while (j < n && cnt < capacity && passengers[j] <= buses[i]) {
                    if (j == 0 && passengers[j] > 1) {
                        res = Math.max(res, passengers[j] - 1);
                    } else if (j > 0 && passengers[j - 1] + 1 < passengers[j]) {
                        res = Math.max(res, passengers[j] - 1);
                    }
                    cnt++;
                    j++;
                }
                if (cnt < capacity && buses[i] != passengers[j - 1]) {
                    res = Math.max(res, buses[i]);
                }
                i++;
            }

            if (i < m) res = buses[m - 1];
            return res;
        }
    }
}
