package p1500_;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 *
 * @author half-dead
 */
public class Puzzle1497 {

    class Solution {
        public boolean canArrange(int[] arr, int k) {
            int[] cnt = new int[k];
            for (int n : arr) cnt[(n % k + k) % k]++;
            for (int lo = 1, hi = k - 1; lo <= hi; lo++, hi--) {
                if (cnt[lo] != cnt[hi]) return false;
                if (lo == hi && cnt[lo] % 2 != 0) return false;
            }
            return true;
        }
    }
}
