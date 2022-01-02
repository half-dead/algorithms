package p1000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * @author half-dead
 */
public class Puzzle873_LengthOfLongestFibonacciSubSequence {
    public static void main(String[] args) {
        Puzzle873_LengthOfLongestFibonacciSubSequence p = new Puzzle873_LengthOfLongestFibonacciSubSequence();
        Solution s = p.new Solution();
        int i = s.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
        System.out.println(i);
    }


    class DpSolution {
        public int lenLongestFibSubseq(int[] arr) {
            int res = 0, len = arr.length;
            int[][] dp = new int[len][len];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(arr[i], i);
            }
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    int n = arr[i] - arr[j];
                    int k = map.getOrDefault(n, -1);
                    dp[j][i] = (n < arr[j] && k >= 0) ? dp[k][j] + 1 : 2;
                    res = Math.max(res, dp[j][i]);
                }
            }
            return res > 2 ? res : 0;
        }
    }

    class SetSolution {
        public int lenLongestFibSubseq(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int x : arr) {
                set.add(x);
            }

            int len = arr.length, ans = 0;
            for (int i = 0; i < len - 1; i++)
                for (int j = i + 1; j < len; j++) {
                    int n1 = arr[i], n2 = arr[j], n3 = n1 + n2;
                    int length = 2;
                    while (set.contains(n3)) {
                        int temp = n3;
                        n3 += n2;
                        n2 = temp;
                        ans = Math.max(ans, ++length);
                    }
                }

            return ans >= 3 ? ans : 0;
        }
    }


    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int len = arr.length, max = 0;
            for (int i = 0; i < len - 2; i++) {
                int i1 = i;
                for (int j = i + 1; j < len - 1; j++) {
                    int i2 = j, i3 = i2 + 1, currLen = 0;
                    while (i3 < len) {
                        int sum = arr[i1] + arr[i2];
                        int idx = binarySearch(arr, i3, sum);
                        if (sum < arr[i3] || idx == -1) {
                            i1 = i;
                            break;
                        } else {
                            currLen = currLen == 0 ? 3 : (currLen + 1);
                            i1 = i2;
                            i2 = idx;
                            i3 = idx + 1;
                        }
                    }
                    max = Math.max(max, currLen);
                }
            }
            return max;
        }

        private int binarySearch(int[] arr, int left, int val) {
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == val) {
                    return mid;
                } else if (arr[mid] > val) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
