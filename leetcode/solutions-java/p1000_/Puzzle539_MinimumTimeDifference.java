package p1000_;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-difference/
 *
 * @author half-dead
 */
public class Puzzle539_MinimumTimeDifference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] arr = new int[timePoints.size()];
            for (int i = 0; i < timePoints.size(); i++) {
                arr[i] = toInt(timePoints.get(i));
            }
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                min = Math.min(min, arr[i] - arr[i - 1]);
            }
            min = Math.min(arr[0] + 24 * 60 - arr[arr.length - 1], min);
            return min;
        }

        private int toInt(String time) {
            int h = time.charAt(0) - '0';
            h *= 10;
            h += time.charAt(1) - '0';
            int m = time.charAt(3) - '0';
            m *= 10;
            m += time.charAt(4) - '0';
            return h * 60 + m;
        }
    }
}
