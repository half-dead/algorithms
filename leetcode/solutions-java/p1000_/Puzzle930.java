package p1000_;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * @author half-dead
 */
public class Puzzle930 {

    public static void main(String[] args) {
        Solution s = new Puzzle930().new Solution();
        System.out.println(s.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0));
        System.out.println(s.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

    class Solution {
        public int numSubarraysWithSum(int[] a, int target) {
            int n = a.length, sum = 0, from = 0, to = 0, left0, right0 = 0, res = 0;
            while (to <= n) {
                if (to < n) sum += a[to];

                if (sum > target || (to == n && sum == target)) {
                    if (target == 0) res += right0 * (right0 + 1) / 2;
                    else {
                        for (left0 = 0; from < to && a[from] == 0; ) {
                            from++;
                            left0++;
                        }
                        res += (left0 + 1) * (right0 + 1);
                    }
                    sum--;
                    from++;
                }

                if (to == n) break;
                right0 = a[to++] == 0 ? right0 + 1 : 0;
            }
            return res;
        }
    }

    // not easy to think of.
    class Solution1 {
        public int numSubarraysWithSum(int[] a, int target) {
            return atMost(a, target) - atMost(a, target - 1);
        }

        public int atMost(int[] a, int target) {
            if (target < 0) return 0;
            int res = 0, i = 0, n = a.length;
            for (int j = 0; j < n; j++) {
                target -= a[j];
                while (target < 0)
                    target += a[i++];
                res += j - i + 1;
            }
            return res;
        }
    }
}
