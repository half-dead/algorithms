package p0500_;

// Given an array and a value, remove all instances of that value in place and return the new length.
//
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

/**
 * https://oj.leetcode.com/problems/remove-element/
 */
public class Puzzle027_RemoveElement {

    public static void main(String[] args) {
        Puzzle027_RemoveElement p = new Puzzle027_RemoveElement();
        Solution s = p.new Solution();
        int i = s.removeElement(new int[]{4, 5, 4, 6, 1, 2, 1, 5, 4, 4, 3, 2, 1, 242}, 4);
        System.out.println(i);

    }

    public class Solution {
        public int removeElement(int[] arr, int elem) {
            int index = 0;
            for (int i : arr) {
                if (i != elem) {
                    arr[index++] = i;
                }
            }
            return index;
        }
    }

}
