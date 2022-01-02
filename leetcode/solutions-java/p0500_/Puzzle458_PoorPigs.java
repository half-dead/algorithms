/*
https://leetcode.com/problems/poor-pigs/submissions/

There are 1000 buckets, one and only one of them contains poison, the rest are filled with water.
They all look the same. If a pig drinks that poison it will die within 15 minutes.
What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

Answer this question, and write an algorithm for the follow-up general case.

Follow-up:
    If there are n buckets and a pig drinking poison will die within m minutes,
    how many pigs (x) you need to figure out the "poison" bucket within p minutes?
    There is exact one bucket with poison.
 */

package p0500_;

/**
 * genius solution:
 * https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
 *
 * @author half-dead
 */
public class Puzzle458_PoorPigs {

    // 用n维数组标记法，而不是二进制标记法
    class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            if (buckets == 1) {
                return 0;
            }
            int round = minutesToTest / minutesToDie;
            int size = round + 1;
            int result = 1, count = size;
            while (count < buckets) {
                count *= size;
                result++;
            }
            return result;
        }
    }
}
