package p0500_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 *
 * @author half-dead
 */
public class Puzzle491 {

    public static void main(String[] args) {
        Solution s = new Puzzle491().new Solution();
        System.out.println(s.findSubsequences(new int[]{4, 6, 7, 7}));
    }

    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            bt(new LinkedList<>(), nums, 0, nums.length, result);
            return result;
        }

        void bt(LinkedList<Integer> q, int[] nums, int i, int n, List<List<Integer>> result) {
            if (q.size() > 1) result.add(new ArrayList<>(q));

            boolean[] seen = new boolean[201];
            for (int j = i; j < n; j++) {
                if ((q.isEmpty() || nums[j] >= q.peekLast()) && !seen[nums[j] + 100]) {
                    seen[nums[j] + 100] = true;
                    q.addLast(nums[j]);
                    bt(q, nums, j + 1, n, result);
                    q.removeLast();
                }
            }
        }
    }
}
