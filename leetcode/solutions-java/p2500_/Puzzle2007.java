package p2500_;

/**
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 *
 * @author half-dead
 */
public class Puzzle2007 {

    class Solution {
        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;

            int[] empty = new int[0], res = new int[n / 2], buckets = new int[100001];
            if (n % 2 != 0) return empty;

            for (int val : changed) buckets[val]++;

            for (int j = 0, i = 100000; i >= 0; i--) {
                if (buckets[i] == 0) continue;

                if (i % 2 != 0) return empty;
                if (buckets[i] > buckets[i / 2]) return empty;
                buckets[i / 2] -= buckets[i];

                for (int k = 0, x = i / 2; k < buckets[i]; k++) res[j++] = x;
            }
            return res;
        }
    }
}
