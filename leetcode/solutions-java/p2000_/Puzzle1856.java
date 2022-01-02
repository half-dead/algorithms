package p2000_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximum-subarray-min-product/
 *
 * @author half-dead
 */
public class Puzzle1856 {

    public static void main(String[] args) {
        Solution s = new Puzzle1856().new Solution();
        Solution2 s2 = new Puzzle1856().new Solution2();
//        System.out.println(s.maxSumMinProduct(new int[]{2, 3, 3, 1, 2}));
//        System.out.println(s.maxSumMinProduct(new int[]{2, 5, 4, 2, 4, 5, 3, 1, 2, 4}));
//        System.out.println(s.maxSumMinProduct(new int[]{4, 10, 6, 4, 8, 7, 8, 3, 5, 3, 4, 9, 9, 5, 10, 7, 10, 7, 6, 4}));
        System.out.println(s.maxSumMinProduct(new int[]{36, 9, 13, 27, 43, 25, 44, 48, 12, 40, 37, 20, 26, 36, 1,
                20, 19, 14, 28, 38, 39, 42, 21, 30, 29, 29, 44, 14, 33, 31, 48, 11, 43,
                6, 19, 33, 43, 41, 40, 22, 6, 49, 16, 44, 20, 15, 13, 10, 2, 3,
                16, 31, 40, 50, 5, 30, 27, 41, 37, 13, 46, 45, 25, 32, 26, 16, 10, 42, 45,
                1, 49, 50, 7, 50, 28, 15, 12, 45, 34, 30, 4, 36, 16, 8, 30, 9, 30, 43, 34, 36, 39, 21, 49, 29, 40, 47, 33, 28, 36, 29}));
        System.out.println(s2.maxSumMinProduct(new int[]{36, 9, 13, 27, 43, 25, 44, 48, 12, 40, 37, 20, 26, 36, 1,
                20, 19, 14, 28, 38, 39, 42, 21, 30, 29, 29, 44, 14, 33, 31, 48, 11, 43,
                6, 19, 33, 43, 41, 40, 22, 6, 49, 16, 44, 20, 15, 13, 10, 2, 3,
                16, 31, 40, 50, 5, 30, 27, 41, 37, 13, 46, 45, 25, 32, 26, 16, 10, 42, 45,
                1, 49, 50, 7, 50, 28, 15, 12, 45, 34, 30, 4, 36, 16, 8, 30, 9, 30, 43, 34, 36, 39, 21, 49, 29, 40, 47, 33, 28, 36, 29}));
    }

    // monotonic stack
    class Solution {
        public int maxSumMinProduct(int[] nums) {
            int len = nums.length;

            long[] sums = new long[len];
            for (int i = 0; i < len; i++) {
                sums[i] = i == 0 ? nums[i] : (sums[i - 1] + (long) nums[i]);
            }

            long max = 0L;
            Deque<Integer> stack = new ArrayDeque<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                while (!stack.isEmpty() && nums[stack.peek()] > curr) {
                    max = Math.max(cal(stack, i, nums, sums), max);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                max = Math.max(cal(stack, len, nums, sums), max);
            }
            return (int) (max % 1000000007);
        }

        private long cal(Deque<Integer> stack, int i, int[] nums, long[] sums) {
            int min = nums[stack.pop()];
            int right = i - 1, left = stack.isEmpty() ? 0 : stack.peek();
            long partialSum = sums[right] - sums[left] + (stack.isEmpty() ? nums[left] : 0);
            return min * partialSum;
        }

    }

    // sort & union find
    class Solution2 {
        public int maxSumMinProduct(int[] nums) {

            int len = nums.length;
            long[] sum = new long[len];
            int[][] data = new int[len][2];
            for (int i = 0; i < len; i++) {
                sum[i] = i == 0 ? nums[i] : (sum[i - 1] + (long) nums[i]);
                data[i][0] = nums[i];
                data[i][1] = i;
            }
            Arrays.sort(data, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            long max = 0L;
            int[] union = new int[len];
            boolean[] flags = new boolean[len];
            int[][] dsu = new int[len][2];
            for (int i = 0; i < len; i++) {
                union[i] = i;
                dsu[i][0] = dsu[i][1] = i;
            }

            for (int i = len - 1; i >= 0; i--) {
                int currNum = data[i][0], idx = data[i][1];
                long temp = 0L;

                boolean joinLeft = idx > 0 && flags[idx - 1];
                boolean joinRight = idx + 1 < len && flags[idx + 1];

                if (joinLeft && joinRight) {
                    int head = find(union, idx - 1), tail = find(union, idx + 1);
                    union(union, idx, head, dsu);
                    union(union, head, tail, dsu);
                    int root = union[idx], left = dsu[root][0], right = dsu[root][1];
                    long partialSum = sum[right] - sum[left] + nums[left];
                    temp = currNum * partialSum;
                } else if (joinLeft) {
                    union(union, idx, find(union, idx - 1), dsu);
                    int root = union[idx], left = dsu[root][0], right = dsu[root][1];
                    long partialSum = sum[right] - sum[left] + nums[left];
                    temp = currNum * partialSum;
                } else if (joinRight) {
                    union(union, idx, find(union, idx + 1), dsu);
                    int root = union[idx], left = dsu[root][0], right = dsu[root][1];
                    long partialSum = sum[right] - sum[left] + nums[left];
                    temp = currNum * partialSum;
                } else {
                    temp = (long) currNum * currNum;
                }

                flags[idx] = true;
                max = Math.max(max, temp);
            }

            return (int) (max % 1000000007);
        }

        private void union(int[] union, int x, int y, int[][] idx) {
            int min = Math.min(x, y), max = Math.max(x, y);
            idx[min][0] = Math.min(idx[min][0], idx[max][0]);
            idx[min][1] = Math.max(idx[min][1], idx[max][1]);
            union[max] = find(union, min);
        }

        private int find(int[] union, int idx) {
            while (union[idx] != idx) {
                union[idx] = find(union, union[idx]);
                idx = union[idx];
            }
            return union[idx];
        }
    }
}
