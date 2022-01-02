package p1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 *
 * @author half-dead
 */
public class Puzzle658 {

    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int n = arr.length, pos = Arrays.binarySearch(arr, x);
            if (pos < 0) pos = -pos - 1;
            int start = pos - k, end = pos;
            while (start < 0 || (end < n && x - arr[start] > arr[end] - x)) {
                start++;
                end++;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = start; i < end; i++) list.add(arr[i]);
            return list;
        }
    }
}
