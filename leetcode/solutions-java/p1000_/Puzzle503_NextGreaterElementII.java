package p1000_;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * @author half-dead
 */
public class Puzzle503_NextGreaterElementII {

    public static void main(String[] args) {
        Puzzle503_NextGreaterElementII p = new Puzzle503_NextGreaterElementII();
        Solution s = p.new Solution();
        int[] ints = s.nextGreaterElements(new int[]{1, 6, 9, 4, 5, 8, 2, 7, 3});
        System.out.println(Arrays.toString(ints));
    }

    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = (len << 1) - 1; i >= 0; i--) {
                int idx = i % len;
                int num = nums[idx];
                while (q.size() > 0 && q.peek() <= num) {
                    q.pop();
                }
                res[idx] = q.size() == 0 ? -1 : q.peek();
                q.push(num);
            }
            return res;
        }
    }

    class StupidSolution {
        public int[] nextGreaterElements(int[] nums) {
            if (nums.length == 0) {
                return new int[]{};
            }
            int max = nums[0];
            for (int n : nums) {
                max = Math.max(max, n);
            }
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max) {
                    res[i] = -1;
                } else {
                    for (int j = i + 1 - nums.length; j < i; j++) {
                        int k = j < 0 ? j + nums.length : j;
                        if (nums[i] < nums[k]) {
                            res[i] = nums[k];
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}
