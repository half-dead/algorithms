package p0500_;

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
// The solution set must not contain duplicate triplets.
// For example, given array S = {-1 0 1 2 -1 -4},
//
// A solution set is:
// (-1, 0, 1)
// (-1, -1, 2)

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Puzzle015_3Sum {

    public static void main(String[] args) {
        Puzzle015_3Sum p = new Puzzle015_3Sum();
        StupidSolution solution = p.new StupidSolution();
        int[] nums = new int[]{7, 5, -8, -6, -13, 7, 10, 1, 1, -4, -14, 0, -1, -10, 1, -13, -4, 6, -11, 8, -6, 0, 0, -5, 0, 11, -9, 8, 2, -6, 4, -14, 6, 4, -5, 0, -12, 12, -13, 5, -6, 10, -10, 0, 7, -2, -5, -12, 12, -9, 12, -9, 6, -11, 1, 14, 8, -1, 7, -13, 8, -11, -11, 0, 0, -1, -15, 3, -11, 9, -7, -10, 4, -2, 5, -4, 12, 7, -8, 9, 14, -11, 7, 5, -15, -15, -4, 0, 0, -11, 3, -15, -15, 7, 0, 0, 13, -7, -12, 9, 9, -3, 14, -1, 2, 5, 2, -9, -3, 1, 7, -12, -3, -1, 1, -2, 0, 12, 5, 7, 8, -7, 7, 8, 7, -15};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
        System.out.println(lists.size());
        Set<String> set = new HashSet<>(lists.size());
        for (List<Integer> list : lists) {
            set.add(list.toString());
        }
        System.out.println(set.size());

        VeryStupidSolution solution1 = p.new VeryStupidSolution();
        solution1.threeSum(nums);

    }

    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new LinkedList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                    int j = i + 1, k = nums.length - 1, sum = -nums[i];
                    while (j < k) {
                        if (nums[j] + nums[k] == sum) {
                            list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            while (j < k && nums[j] == nums[j + 1]) j++;
                            while (j < k && nums[k] == nums[k - 1]) k--;
                            j++;
                            k--;
                        } else if (nums[j] + nums[k] < sum) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
            return list;
        }
    }

    public class StupidSolution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
                return result;
            }

            fori:
            for (int i = 0; i < nums.length; i++) {
                int exp1 = -nums[i];
                if (exp1 == 0 && i + 2 < nums.length && nums[i + 2] == 0) {
                    result.add(Arrays.asList(0, 0, 0));
                    return result;
                }
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
                if (i > 0 && nums[i] == nums[i - 1] && -nums[i] - nums[i] <= nums[nums.length - 1]) {
                    for (int t = i + 1; t < nums.length; t++) {
                        if (nums[t] == -nums[i] - nums[i]) {
                            result.add(Arrays.asList(nums[i], nums[i], nums[t]));
                            break;
                        }
                    }
                }

                forj:
                for (int j = i + 1; j < nums.length; j++) {
                    int exp2 = exp1 - nums[j];
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    if (exp2 == nums[j] && exp2 == nums[j - 1]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[j]));
                        continue fori;
                    }

                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] == exp2) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            continue forj;
                        }
                    }
                }
            }
            return result;
        }
    }

    public class VeryStupidSolution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<String> set = new LinkedHashSet<>();
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    for (int k = j; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            if (set.add(nums[i] + "," + nums[j] + "," + nums[k])) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            }
                        }
                    }
                }
            }
            return result;
        }
    }

}
