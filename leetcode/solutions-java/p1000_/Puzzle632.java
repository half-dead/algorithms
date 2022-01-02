package p1000_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 * @author half-dead
 */
public class Puzzle632 {

    public static void main(String[] args) {
        Solution s = new Puzzle632().new Solution();
        System.out.println(Arrays.toString(s.smallestRange(Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        ))));
    }

    // use long(hi-32 bits is val, lo-32 bits is index) instead of 2-elements array
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int n = nums.size(), m = 0, left = 0, right = 0, window = 0, N32 = 32;
            long start = 0, end = 0, range = Integer.MAX_VALUE, delta = 100000;
            for (List<Integer> row : nums) m += row.size();

            long[] merged = new long[m];
            for (int i = 0, j = 0; i < n; i++)
                for (int v : nums.get(i))
                    merged[j++] = i | ((v + delta) << N32);
            Arrays.sort(merged);

            int[] cnt = new int[n];
            while (right < m) {
                if (window < n && cnt[(int) merged[right]]++ == 0) window++;

                while (window == n) {
                    if (--cnt[(int) merged[left]] == 0) {
                        window--;

                        long d = (merged[right] >> N32) - (merged[left] >> N32);
                        if (d < range) {
                            range = d;
                            start = merged[left];
                            end = merged[right];
                        }
                    }
                    left++;
                }

                right++;
            }
            return new int[]{(int) ((start >> N32) - delta), (int) ((end >> N32) - delta)};
        }
    }

    // merge, sort, sliding window
    class Solution0 {
        public int[] smallestRange(List<List<Integer>> nums) {
            int n = nums.size(), m = 0, start = 0, end = 0, range = Integer.MAX_VALUE;
            for (List<Integer> row : nums) m += row.size();

            int[][] merged = new int[m][2];
            for (int i = 0, j = 0; i < n; i++) for (int v : nums.get(i)) merged[j++] = new int[]{v, i};
            Arrays.sort(merged, Comparator.comparingInt(x -> x[0]));

            int[] cnt = new int[n];
            int left = 0, right = 0, window = 0;
            while (right < m) {
                if (window < n && cnt[merged[right][1]]++ == 0) window++;

                while (window == n) {
                    if (--cnt[merged[left][1]] == 0) {
                        window--;

                        int d = merged[right][0] - merged[left][0];
                        if (d < range) {
                            range = d;
                            start = merged[left][0];
                            end = merged[right][0];
                        }
                    }
                    left++;
                }

                right++;
            }
            return new int[]{start, end};
        }
    }

    // priority queue
    class Solution1 {
        public int[] smallestRange(List<List<Integer>> nums) {
            int n = nums.size(), max = Integer.MIN_VALUE, range = Integer.MAX_VALUE, start = 0, end = 0;
            int[] lens = new int[n], cursors = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> nums.get(x).get(cursors[x])));

            for (int i = 0; i < n; i++) {
                List<Integer> row = nums.get(i);
                lens[i] = row.size();
                max = Math.max(max, row.get(0));
                pq.offer(i);
            }

            while (pq.size() == n) {
                int i = pq.poll();
                List<Integer> row = nums.get(i);

                int lo = row.get(cursors[i]);
                if (max - lo < range) {
                    range = max - lo;
                    start = lo;
                    end = max;
                }
                if (++cursors[i] == lens[i]) break;
                pq.offer(i);
                max = Math.max(max, row.get(cursors[i]));
            }
            return new int[]{start, end};
        }
    }
}
