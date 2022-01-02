package p1500_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle1471 {

    // sort, O(NlogN) time, O(k) space
    class SortSolution {
        public int[] getStrongest(int[] arr, int k) {
            Arrays.sort(arr);
            int median = arr[(arr.length - 1) / 2], lo = 0, hi = arr.length - 1;
            int[] res = new int[k];
            while (--k >= 0) {
                res[k] = arr[hi] - median >= median - arr[lo] ? arr[hi--] : arr[lo++];
            }
            return res;
        }
    }
}
