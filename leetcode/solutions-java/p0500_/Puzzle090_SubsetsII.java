package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * @author half-dead
 */
public class Puzzle090_SubsetsII {

    public static void main(String[] args) {
        Solution s = new Puzzle090_SubsetsII().new Solution();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));

        BacktrackSolution bs = new Puzzle090_SubsetsII().new BacktrackSolution();
        System.out.println(bs.subsetsWithDup(new int[]{1, 2, 2, 3}));
    }

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }

            List<List<Integer>> result = recurse(map);
            result.add(new ArrayList<>());
            return result;
        }

        public List<List<Integer>> recurse(Map<Integer, Integer> map) {
            List<List<Integer>> result = new ArrayList<>();
            for (int n : map.keySet()) {
                int count = map.get(n);
                List<List<Integer>> left = generateOne(n, count);
                result.addAll(left);

                Map<Integer, Integer> copy = new HashMap<>(map);
                copy.remove(n);
                if (copy.size() > 0) {
                    List<List<Integer>> right = recurse(copy);
                    result.addAll(right);
                    for (int i = 0; i < left.size(); i++) {
                        for (int j = 0; j < right.size(); j++) {
                            List<Integer> product = new ArrayList<>(left.get(i));
                            product.addAll(right.get(j));
                            result.add(product);
                        }
                    }
                }
                break;
            }
            return result;
        }

        public List<List<Integer>> generateOne(int n, int count) {
            List<List<Integer>> result = new ArrayList<>(count);
            for (int i = 1; i <= count; i++) {
                List<Integer> list = new ArrayList<>(i);
                for (int j = 0; j < i; j++) {
                    list.add(n);
                }
                result.add(list);
            }
            return result;
        }
    }

    class BacktrackSolution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null) {
                return result;
            }
            LinkedList<Integer> current = new LinkedList<>();
            Arrays.sort(nums);
            backtrack(nums, result, current, 0);
            return result;
        }

        public void backtrack(int[] nums, List<List<Integer>> result, LinkedList<Integer> temp, int start) {
            result.add(new ArrayList<>(temp));
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                backtrack(nums, result, temp, i + 1);
                temp.removeLast();
            }

        }
    }
}
