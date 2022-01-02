package p0500_;

/**
 * https://leetcode.com/problems/h-index-ii/
 *
 * @author half-dead
 */
public class Puzzle275 {
    public static void main(String[] args) {
        Solution s = new Puzzle275().new Solution();
        System.out.println(s.hIndex(new int[]{0, 0, 0, 0}));
        System.out.println(s.hIndex(new int[]{0, 1, 2, 3}));
        System.out.println(s.hIndex(new int[]{4, 4, 4, 4}));
    }

    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length, lo = 0, hi = len - 1;
            while (lo <= hi) {
                int mid = (hi + lo) / 2;
                int h = len - mid;

                if (citations[mid] == h) {
                    return h;
                } else if (citations[mid] > h) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return len - lo - 1;
        }
    }
}
