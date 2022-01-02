package p0500_;

// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
// Do not allocate extra space for another array, you must do this in place with constant memory.
//
// For example,
// Given input array A = [1,1,2],
//
// Your function should return length = 2, and A is now [1,2].

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Puzzle026_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Puzzle026_RemoveDuplicatesFromSortedArray p = new Puzzle026_RemoveDuplicatesFromSortedArray();
        Solution solution = p.new Solution();
        int[] arr = {1, 1};
        int len = solution.removeDuplicates(arr);
        System.out.println(len);
    }

    public class Solution {
        public int removeDuplicates(int[] arr) {
            if (arr.length < 2) return arr.length;
            int p = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    arr[p++] = arr[i];
                }
            }
            return p;
        }
    }
}
