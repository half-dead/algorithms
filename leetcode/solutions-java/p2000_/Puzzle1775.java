package p2000_;

/**
 * https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
 *
 * @author half-dead
 */
public class Puzzle1775 {
    public static void main(String[] args) {
        Solution s = new Puzzle1775().new Solution();
        System.out.println(s.minOperations(new int[]{
                5, 6, 4, 3, 1, 2
        }, new int[]{
                6, 3, 3, 1, 4, 5, 3, 4, 1, 3, 4
        }));

    }

    // count sort, greedy
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            if (len1 > len2 * 6 || len1 * 6 < len2) return -1;

            int[] f1 = new int[7], f2 = new int[7];
            for (int n : nums1) f1[n]++;
            for (int n : nums2) f2[n]++;

            int s1 = 0, s2 = 0;
            for (int i = 1; i < 7; i++) {
                s1 += i * f1[i];
                s2 += i * f2[i];
            }

            if (s1 == s2) return 0;
            int[] smq, bgq;
            if (s1 > s2) {
                bgq = f1;
                smq = f2;
            } else {
                smq = f1;
                bgq = f2;
            }

            int diff = Math.abs(s1 - s2), res = 0, smi = 1, bgi = 6, delta = 5;
            while (diff > 0) {
                int avail = delta * (smq[smi] + bgq[bgi]);
                if (avail >= diff) {
                    res += (diff + delta - 1) / delta;
                    break;
                }
                res += smq[smi++] + bgq[bgi--];
                delta--;
                diff -= avail;
            }
            return res;
        }
    }
}
