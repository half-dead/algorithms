package p2500_;

/**
 * https://leetcode.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/
 *
 * @author half-dead
 */
public class Puzzle2086 {

    class Solution {
        public int minimumBuckets(String street) {
            char[] cs = street.toCharArray();
            int n = cs.length, bucket = -2, res = 0;
            for (int i = 0; i < n; i++) {
                if (cs[i] == '.' || bucket == i - 1) continue;

                res++;
                if (i + 1 < n && cs[i + 1] == '.') bucket = i + 1;
                else if (i > 0 && cs[i - 1] == '.') bucket = i - 1;
                else return -1;
            }
            return res;
        }
    }
}
