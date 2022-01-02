package p1000_;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * @author half-dead
 */
public class Puzzle852 {

    // binary search
    class Solution {
        public int peakIndexInMountainArray(int[] a) {
            int lo = 0, hi = a.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (a[mid] > a[mid + 1]) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        }
    }
}
