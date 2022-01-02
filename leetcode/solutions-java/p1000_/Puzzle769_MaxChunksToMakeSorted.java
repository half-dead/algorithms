package p1000_;

/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 *
 * @author half-dead
 */
public class Puzzle769_MaxChunksToMakeSorted {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int len = arr.length;
            int i = 0;
            int count = 0;
            while (i < len) {
                while (i < len && arr[i] == i) {
                    i++;
                    count++;
                }

                if (i < len) {
                    int max = arr[i];
                    while (i <= max && i < len) {
                        max = Math.max(max, arr[i]);
                        i++;
                    }
                    count++;
                }
            }
            return count;
        }
    }

    class SimpleSolution {
        public int maxChunksToSorted(int[] arr) {
            int ans = 0, max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if (max == i) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
