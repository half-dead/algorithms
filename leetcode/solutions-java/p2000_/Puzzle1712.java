package p2000_;

/**
 * https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/
 *
 * @author half-dead
 */
public class Puzzle1712 {

    public static void main(String[] args) {
        Solution s = new Puzzle1712().new Solution();
        System.out.println(s.waysToSplit(new int[]{1, 1, 1}));//1
        System.out.println(s.waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));//3
        System.out.println(s.waysToSplit(new int[]{3, 2, 1}));//0
        System.out.println(s.waysToSplit(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));//36
        System.out.println(s.waysToSplit(new int[]{7, 0, 5}));//0
        System.out.println(s.waysToSplit(new int[]{2, 8, 10, 0, 2}));//1
        System.out.println(s.waysToSplit(new int[]{8892, 2631, 7212, 1188, 6580, 1690, 5950, 7425, 8787, 4361, 9849, 4063, 9496, 9140, 9986, 1058, 2734, 6961, 8855, 2567, 7683, 4770, 40, 850, 72, 2285, 9328, 6794, 8632, 9163, 3928, 6962, 6545, 6920, 926, 8885, 1570, 4454, 6876, 7447, 8264, 3123, 2980, 7276, 470, 8736, 3153, 3924, 3129, 7136, 1739, 1354, 661, 1309, 6231, 9890, 58, 4623, 3555, 3100, 3437}));
    }

    class Solution {
        public int waysToSplit(int[] nums) {
            int mod = 1000000007, len = nums.length;
            for (int i = 1; i < len; i++) {
                nums[i] += nums[i - 1];
            }

            long res = 0L;
            for (int i = 0, j = i + 1, k = i + 1; i < len - 2; i++) {
                j = Math.max(i + 1, j);
                while (j < len - 1 && nums[i] > nums[j] - nums[i]) {
                    j++;
                }

                k = Math.max(j, k);
                while (k < len - 1 && nums[k] - nums[i] <= nums[len - 1] - nums[k]) {
                    k++;
                }
                res += k - j;
            }
            return (int) (res % mod);
        }
    }

    class BinarySearchSolution {
        public int waysToSplit(int[] nums) {
            final int mod = 1000000007, len = nums.length;

            int[] preSum = new int[len];
            preSum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            if (preSum[len - 1] == 0) {
                long v = ((long) (len - 1)) * (len - 2) / 2;
                return (int) (v % mod);
            }

            long res = 0L;
            int[] temp = new int[]{1, 1};
            for (int pl = 0; pl < len - 2; pl++) {
                int v = find(preSum, pl, temp);
                if (v < 0) {
                    break;
                }
                res += v;
            }
            return (int) (res % mod);
        }

        private int find(int[] nums, int i, int[] temp) {
            int sumLeft = nums[i];
            int lo = Math.max(i + 1, temp[0]), hi = nums.length - 2;
            while (lo <= hi) {
                int mid = (lo + hi) / 2, sumMid = nums[mid] - nums[i];
                if (sumLeft > sumMid) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (lo > nums.length - 2) {
                return -1;
            }

            int start = hi + 1;

            lo = Math.max(start, temp[1]);
            hi = nums.length - 2;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int sumMid = nums[mid] - nums[i], sumRight = nums[nums.length - 1] - nums[mid];
                if (sumMid > sumRight) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (hi == i) return -1;

            temp[0] = start;
            temp[1] = lo - 1;
            return lo - start;
        }
    }
}
