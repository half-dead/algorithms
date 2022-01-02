package p0500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * @author half-dead
 */
public class Puzzle084_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Puzzle084_LargestRectangleInHistogram p = new Puzzle084_LargestRectangleInHistogram();
        Solution s = p.new Solution();
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        System.out.println(s.largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0}));//20
    }

    class DpSolution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) return 0;

            int[] left = new int[len], right = new int[len];
            left[0] = -1;
            right[len - 1] = len;
            for (int i = 1; i < heights.length; i++) {
                int idx = i - 1;
                while (idx >= 0 && heights[idx] >= heights[i]) {
                    idx = left[idx];
                }
                left[i] = idx;
            }
            for (int i = len - 2; i >= 0; i--) {
                int idx = i + 1;
                while (idx < len && heights[idx] >= heights[i]) {
                    idx = right[idx];
                }
                right[i] = idx;
            }
            int max = 0;
            for (int i = 0; i < len; i++) {
                max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
            }
            return max;
        }
    }

    public class Solution {
        public int largestRectangleArea(int[] arr) {
            LinkedList<Integer> q = new LinkedList<>();
            int len = arr.length, max = 0;
            for (int i = 0; i <= len; i++) {
                int h = i == len ? 0 : arr[i];
                if (q.isEmpty() || h >= arr[q.peek()]) {
                    q.push(i);
                } else {
                    int top = q.pop();
                    int area = arr[top] * (q.isEmpty() ? i : i - 1 - q.peek());
                    max = Math.max(max, area);
                    i--;
                }
            }
            return max;
        }
    }


}
