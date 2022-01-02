package p0500_;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author half-dead
 */
public class Puzzle239_SlidingWindowMaximum {
    public static void main(String[] args) {
        Puzzle239_SlidingWindowMaximum p = new Puzzle239_SlidingWindowMaximum();
        Solution s = p.new Solution();
        int[] arr = s.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        System.out.println(Arrays.toString(arr));
    }

    class QueueSolution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 1) {
                return nums;
            }
            int[] result = new int[nums.length - k + 1];
            int left = 0, right = 0, i = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            while (right < nums.length) {
                if (i < k) {
                    while (queue.size() > 0 && queue.peekFirst() < nums[right]) {
                        queue.removeFirst();
                    }
                    while (queue.size() > 0 && queue.peekLast() < nums[right]) {
                        queue.removeLast();
                    }
                    queue.addLast(nums[right]);
                    i++;
                    right++;
                }
                if (i == k) {
                    result[left] = nums[left] == queue.peekFirst() ? queue.removeFirst() : queue.peekFirst();
                    left++;
                    i--;
                }
            }
            return result;
        }
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) return new int[0];

            int[] res = new int[nums.length - k + 1];
            int max = Integer.MIN_VALUE, maxIndex = 0;
            for (int i = 0; i < k; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

            res[0] = max;
            for (int i = 1; i < res.length; i++) {
                int nextIdx = i + k - 1;
                if (nums[nextIdx] >= max) {
                    max = nums[nextIdx];
                    maxIndex = nextIdx;
                    res[i] = max;
                } else if (maxIndex != i - 1) {
                    res[i] = max;
                } else {
                    max = nums[i];
                    maxIndex = i;
                    for (int j = i + 1; j < i + k; j++) {
                        if (max <= nums[j]) {
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                    res[i] = max;
                }
            }
            return res;
        }
    }
}
