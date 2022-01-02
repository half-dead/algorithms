package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/132-pattern/description/
 *
 * @author half-dead
 */
public class Puzzle456_132Pattern {

    public static void main(String[] args) {
        Solution solution = new Puzzle456_132Pattern().new Solution();
        NeatSolution ns = new Puzzle456_132Pattern().new NeatSolution();
        System.out.println(ns.find132pattern(new int[]{3, 5, 0, 1, 2, 4}));
//        System.out.println(ns.find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    class Solution {

        public boolean find132pattern(int[] nums) {
            int n = nums.length, nj = Integer.MIN_VALUE, nk = Integer.MIN_VALUE;
            boolean flag = false;

            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] < nk) {
                    return true;
                }
                while (flag && nums[i] > nj) {
                    System.out.println("1 -> nj=" + nj + ", nk=" + nk);
                    nk = nj;
                    flag = false;
                }
                flag = true;
                nj = nums[i];
                System.out.println("2 -> nj=" + nj + ", nk=" + nk);
            }
            return false;
        }
    }

    class NeatSolution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length, top = n, nk = Integer.MIN_VALUE;

            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] < nk) {
                    return true;
                }
                while (top < n && nums[i] > nums[top]) {
                    System.out.println("1 -> nj=" + nums[top] + ", nk=" + nk);
                    nk = nums[top];
                    top++;
                }
                top--;
                nums[top] = nums[i];
                System.out.println("2 -> nj=" + nums[top] + ", nk=" + nk);
                System.out.println(Arrays.toString(nums));
            }
            return false;
        }
    }

    class MySolution {
        public boolean find132pattern(int[] nums) {
            int len = nums.length, len1 = nums.length - 1;
            for (int i = 0; i < len1; ) {
                while (i < len1 && nums[i] >= nums[i + 1]) {
                    i++;
                }
                int m = len1, mink = len1;
                while (m > 0 && nums[m - 1] >= nums[m]) {
                    if (nums[m - 1] > nums[m]) {
                        mink = m;
                    }
                    m--;
                }
                len1 = mink;

                int ni = nums[i];
                while (i < len1 && nums[i] <= nums[i + 1]) {
                    i++;
                }
                if (i == len1) {
                    return false;
                }
                int nj = nums[i];
                int k = i + 1;
                int ii = 0, kk = 0;
                while (k <= len1) {
                    while (k < len1 && nums[k] == nums[k + 1]) {
                        k++;
                    }
                    if (ni < nums[k] && nums[k] < nj) {
                        return true;
                    } else if (nums[k] < ni || nums[k] > nj) {
                        if (ii == 0) {
                            ii = k;
                        }
                        kk = k;
                    }
                    k++;
                }
                if (ii > 0) {
                    i = ii;
                    len1 = kk;
                } else {
                    return false;
                }
            }
            return false;
        }
    }
}
