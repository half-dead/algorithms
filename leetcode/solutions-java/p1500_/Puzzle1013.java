package p1500_;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * @author half-dead
 */
public class Puzzle1013 {

    public static void main(String[] args) {
        Solution s = new Puzzle1013().new Solution();
        System.out.println(s.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
        System.out.println(s.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }

    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int sum = 0;
            for (int a : arr) sum += a;

            int part = sum / 3;
            if (part * 3 != sum) return false;

            int left = 0, right = arr.length - 1, p1 = arr[left++], p2 = arr[right--];
            while (left < right && p1 != part) p1 += arr[left++];
            while (left < right && p2 != part) p2 += arr[right--];
            return left <= right && p1 == part && p2 == part;
        }
    }
}
