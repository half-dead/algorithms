/*
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle042_TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int count = 0;
            while (left < right) {
                while (left < right && height[left] <= height[left + 1]) {
                    left++;
                }
                while (right > left && height[right] <= height[right - 1]) {
                    right--;
                }
                if (right - left <= 1) {
                    break;
                }
                int i = left + 1, target = height[left];
                while (i <= right) {
                    if (height[i] >= target) {
                        int j = left + 1;
                        while (j < i) {
                            count += target - height[j];
                            j++;
                        }
                        left = i;
                        break;
                    } else {
                        i++;
                    }
                }

                i = right - 1;
                target = height[right];
                while (i >= left) {
                    if (height[i] >= target) {
                        int j = right - 1;
                        while (j > i) {
                            count += target - height[j];
                            j--;
                        }
                        right = i;
                        break;
                    } else {
                        i--;
                    }
                }
            }
            return count;
        }
    }

    class NeatSolution {
        public int trap(int[] A) {
            int a = 0, b = A.length - 1, max = 0, leftmax = 0, rightmax = 0;
            while (a <= b) {
                leftmax = Math.max(leftmax, A[a]);
                rightmax = Math.max(rightmax, A[b]);
                if (leftmax < rightmax) {
                    max += (leftmax - A[a]);
                    a++;
                } else {
                    max += (rightmax - A[b]);
                    b--;
                }
            }
            return max;

        }
    }
}
