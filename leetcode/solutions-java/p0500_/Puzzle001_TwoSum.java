package p0500_;

// Given an array of integers, find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
// You may assume that each input would have exactly one solution.
//
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

import java.util.HashMap;

/**
 * https://oj.leetcode.com/problems/two-sum/
 */
public class Puzzle001_TwoSum {

    /**
     * tricky O(n) solution, need extra space.
     */
    public class Solution1 {
        public int[] twoSum(int[] numbers, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < numbers.length; i++) {
                int cur = numbers[i];
                Integer pos = map.get(cur);
                if (pos != null) {
                    idx1 = pos;
                    idx2 = i;
                    break;
                }
                map.put(target - cur, i);
            }
            return new int[]{idx1 + 1, idx2 + 1};
        }
    }

    /**
     * a stupid O(n^2) solution, TLE
     */
    public class Solution2 {
        public int[] twoSum(int[] numbers, int target) {
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] <= target) {
                    for (int j = 0; j < numbers.length; j++) {
                        if (j != i && numbers[j] == target - numbers[i]) {
                            idx1 = i < j ? i : j;
                            idx2 = i < j ? j : i;
                        }
                    }
                }
            }
            return new int[]{idx1 + 1, idx2 + 1};
        }
    }
}
