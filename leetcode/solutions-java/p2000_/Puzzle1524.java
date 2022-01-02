package p2000_;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 *
 * @author half-dead
 */
public class Puzzle1524 {

    class Solution {
        public int numOfSubarrays(int[] arr) {
            long odd = 0L, even = 0L, res = 0L;
            for (int n : arr) {
                long nextodd = odd, nexteven = even;
                if (n % 2 == 0) {
                    nexteven = even + 1;
                } else {
                    nextodd = even + 1;
                    nexteven = odd;
                }
                odd = nextodd;
                even = nexteven;
                res += odd;
            }
            return (int) (res % 1000000007);
        }
    }
}
