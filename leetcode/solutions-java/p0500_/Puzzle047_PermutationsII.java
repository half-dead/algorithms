/*
https://leetcode.com/problems/permutations-ii/description/

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
 */

package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle047_PermutationsII {

    public static void main(String[] args) {
        Puzzle047_PermutationsII p = new Puzzle047_PermutationsII();
        Solution s = p.new Solution();
        List<List<Integer>> lists = s.permuteUnique(new int[]{2,2,1,1});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println(lists.size());
    }

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            dfs(nums, 0, result);
            return result;
        }

        private void dfs(int[] nums, int index, List<List<Integer>> result) {
            if (index == (nums.length - 1)) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }
                result.add(list);
                return;
            }

            for (int i = index; i < nums.length; i++) {
                boolean swap = true;
                for (int j = index; j < i; j++) {
                    if (nums[j] == nums[i]) {
                        swap = false;
                        break;
                    }
                }
                if (swap) {
                    swap(nums, index, i);
                    dfs(nums, index + 1, result);
                    swap(nums, index, i);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j || nums[i] == nums[j]) {
                return;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
