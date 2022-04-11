package p2500_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 *
 * @author half-dead
 */
public class Puzzle2215 {

    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).filter(i -> !set1.contains(i)).boxed().collect(Collectors.toSet());
            Arrays.stream(nums2).forEach(set1::remove);
            return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
        }
    }
}
