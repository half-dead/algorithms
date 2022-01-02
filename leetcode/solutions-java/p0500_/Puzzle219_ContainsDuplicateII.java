package p0500_;

// Given an array of integers and an integer k, find out whether there are two
// distinct indices i and j in the array such that nums[i] = nums[j] and
// the absolute difference between i and j is at most k.


import java.util.*;

/**
 * @author half-dead
 */
public class Puzzle219_ContainsDuplicateII {

    class NeatSolution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums == null || nums.length < 2) {
                return false;
            }

            Set<Integer> set = new HashSet<>(Math.min(nums.length, k));
            for (int i = 0; i < nums.length; i++) {
                if (i > k) set.remove(nums[i - k - 1]);
                if (!set.add(nums[i])) return true;
            }
            return false;
        }
    }

    class MySolution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                map.computeIfAbsent(num, j -> new ArrayList<>()).add(i);
                if (checkNearBy(map.get(num), k)) {
                    return true;
                }
            }
            return false;
        }

        public boolean checkNearBy(List<Integer> list, int k) {
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) - list.get(i - 1) <= k) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
