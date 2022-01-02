package p1500_;

/**
 * Element Appearing More Than 25% In Sorted Array
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * @author half-dead
 */
public class Puzzle1287 {
    class Solution {
        public int findSpecialInteger(int[] arr) {
            for (int len = arr.length, d = len >> 2, i = d; i < len; i++) if (arr[i] == arr[i - d]) return arr[i];
            return 0;
        }
    }
}
