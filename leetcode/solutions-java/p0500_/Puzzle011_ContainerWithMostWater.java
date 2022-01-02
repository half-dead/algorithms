package p0500_;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Puzzle011_ContainerWithMostWater {
    public static void main(String[] args) {
        Puzzle011_ContainerWithMostWater p = new Puzzle011_ContainerWithMostWater();
        Solution solution = p.new Solution();
        int area = solution.maxArea(new int[]{5, 2, 12, 1, 5, 3, 4, 11, 9, 4});
        System.out.println(area);
    }

    public class Solution {
        public int maxArea(int[] arr) {
            int area = Math.min(arr[0], arr[arr.length - 1]) * (arr.length - 1);
            int begin = 0, end = arr.length - 1;
            int valBegin = arr[begin], valEnd = arr[end];
            while (begin < end) {
                if (arr[begin] < arr[end]) {
                    while (arr[++begin] < valBegin && begin < end) {
                    }
                    valBegin = arr[begin];
                } else {
                    while (arr[--end] < valEnd && begin < end) {
                    }
                    valEnd = arr[end];
                }
                area = Math.max(area, Math.min(valBegin, valEnd) * (end - begin));
            }
            return area;
        }
    }

    // O(n^2), TLE...
    public class VeryStupidSolution {
        public int maxArea(int[] height) {
            int area = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int temp = Math.min(height[i], height[j]) * (j - i);
                    if (temp > area) {
                        area = temp;
                    }
                }
            }
            return area;
        }
    }
}
