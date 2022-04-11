package p2000_;

/**
 * https://leetcode.com/problems/sum-of-floored-pairs/
 *
 * @author half-dead
 */
public class Puzzle1862 {

    public static void main(String[] args) {
        Solution s = new Puzzle1862().new Solution();
        int m = 100000;
        int[] arr = new int[m];
        for (int i = 1; i <= m; i++) arr[i - 1] = i;
        System.out.println(s.sumOfFlooredPairs(arr));
    }

    // cnt by frequency, prefix sum, sieve, math
    class Solution {
        public int sumOfFlooredPairs(int[] nums) {
            int mod = (int) 1e9 + 7, max = 0;

            for (int x : nums) max = Math.max(max, x);

            int[] freq = new int[max + 1], ps = new int[max + 1];
            for (int x : nums) freq[x]++;
            for (int i = 1; i <= max; i++) ps[i] = ps[i - 1] + freq[i];

            long ans = 0L;
            for (int step = 1; step <= max; step++) {
                if (freq[step] == 0) continue;

                ans += (long) freq[step] * freq[step];

                int prev = ps[step];
                for (int t = 1, j = step * 2 - 1; ; t++, j += step) {
                    int curr = ps[Math.min(max, j)];
                    ans += (long) freq[step] * (curr - prev) * t;
                    prev = curr;
                    if (j > max) break;
                }
            }
            return (int) (ans % mod);
        }
    }
}
