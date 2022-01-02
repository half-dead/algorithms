package p1000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * @author half-dead
 */
public class Puzzle907 {
    public static void main(String[] args) {
        Solution s = new Puzzle907().new Solution();
        BruteForceSolution bfs = new Puzzle907().new BruteForceSolution();
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 5, 7, 2, 4, 6, 3, 8, 9};
        System.out.println(s.sumSubarrayMins(arr));
        System.out.println(bfs.sumSubarrayMins(arr));
    }

    // O(N) time, O(N) space
    class Solution {
        public int sumSubarrayMins(int[] a) {
            int sum = 0, mod = 1000000007;
            LinkedList<U> stack = new LinkedList<>();
            for (int n : a) {
                if (stack.isEmpty() || n >= stack.peek().num) {
                    stack.push(new U(n));
                } else {
                    int right = 1;
                    while (!stack.isEmpty() && stack.peek().num >= n) {
                        U u = stack.pop();
                        sum = (sum + u.num * u.left * right) % mod;
                        right += u.left;
                    }
                    stack.push(new U(n, right));
                }
            }
            int right = 1;
            while (!stack.isEmpty()) {
                U u = stack.pop();
                sum = (sum + u.num * u.left * right) % mod;
                right += u.left;
            }
            return sum;
        }

        class U {
            int num, left = 1;

            public U(int num) {
                this.num = num;
            }

            public U(int num, int left) {
                this.num = num;
                this.left = left;
            }
        }
    }

    // O(N*N) time, O(1) space, TLE
    class BruteForceSolution {
        public int sumSubarrayMins(int[] a) {
            int n = a.length, sum = 0, mod = 1000000007;
            for (int from = 0; from < n; from++) {
                int min = Integer.MAX_VALUE;
                for (int to = from; to < n; to++) {
                    min = Math.min(min, a[to]);
                    sum += min;
                }
                sum = sum % mod;
            }
            return sum;
        }
    }
}
