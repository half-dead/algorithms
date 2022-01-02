package p2000_;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 *
 * @author half-dead
 */
public class Puzzle1673 {

    // greedy, array
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int[] res = new int[k];
            for (int i = 0, j = 0, n = nums.length; i < n; i++) {
                while (j > 0 && res[j - 1] > nums[i] && n - i >= k - j + 1)
                    j--;
                if (j < k)
                    res[j++] = nums[i];
            }
            return res;
        }
    }


    // greedy, monotonic deque
    class DequeSolution {
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            if (k == n) return nums;

            int[] res = new int[k];
            Deque<Integer> stack = new LinkedList<>();
            int left = 0, right = n - 1 - (k - 1), i = 0;
            while (right < n) {
                while (left <= right) {
                    while (!stack.isEmpty() && nums[stack.peekLast()] > nums[left]) {
                        stack.pollLast();
                    }
                    stack.addLast(left++);
                }
                int minIndex = stack.pollFirst();
                res[i++] = nums[minIndex];
                right = n - 1 - (k - i - 1);
            }
            while (i < k) res[i++] = nums[stack.pollFirst()];
            return res;
        }
    }

    // greedy, monotonic stack
    class StackSolution {
        public int[] mostCompetitive(int[] nums, int k) {
            Deque<Integer> stack = new LinkedList<>();
            int[] result = new int[k];
            for (int i = 0, n = nums.length; i < n; i++) {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && n - i + stack.size() > k)
                    stack.pop();

                if (stack.size() < k)
                    stack.push(i);
            }
            for (int i = k - 1; i >= 0; i--)
                result[i] = nums[stack.pop()];
            return result;
        }
    }
}
