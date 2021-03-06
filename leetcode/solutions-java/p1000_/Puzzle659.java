package p1000_;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 *
 * @author half-dead
 */
public class Puzzle659 {

    public static void main(String[] args) {
        Solution s = new Puzzle659().new Solution();
        System.out.println(s.isPossible(new int[]{14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 35, 36, 36, 36, 37, 37, 37, 38, 38, 38, 39, 39, 39, 40, 40, 40, 41, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 47, 48, 48, 48, 49, 49, 49, 50, 50, 50, 51, 51, 51, 52, 52, 52, 53, 53, 53, 54, 54, 54, 55, 55, 55, 56, 56, 56, 57, 57, 57, 58, 58, 58, 59, 59, 59, 60, 60, 60, 61, 61, 61, 62, 62, 62, 62, 63, 63, 63, 63, 64, 64, 64, 64, 65, 65, 65, 65, 65, 66, 66, 66, 66, 66, 67, 67, 67, 67, 67, 68, 68, 68, 68, 68, 68, 69, 69, 69, 69, 69, 69, 70, 70, 70, 70, 70, 70, 71, 71, 71, 71, 71, 71, 72, 72, 72, 72, 72, 72, 73, 73, 73, 73, 73, 73, 74, 74, 74, 74, 74, 74, 75, 75, 75, 75, 75, 75, 76, 76, 76, 76, 76, 76, 77, 77, 77, 77, 77, 77, 78, 78, 78, 78, 78, 78, 79, 79, 79, 79, 79, 79, 80, 80, 80, 80, 80, 80, 80, 81, 81, 81, 81, 81, 81, 81, 82, 82, 82, 82, 82, 82, 82, 83, 83, 83, 83, 83, 83, 83, 84, 84, 84, 84, 84, 84, 84, 85, 85, 85, 85, 85, 85, 85, 86, 86, 86, 86, 86, 86, 86, 86, 87, 87, 87, 87, 87, 87, 87, 87, 88, 88, 88, 88, 88, 88, 88, 88, 89, 89, 89, 89, 89, 89, 89, 89, 90, 90, 90, 90, 90, 90, 90, 90, 91, 91, 91, 91, 91, 91, 91, 92, 92, 92, 92, 92, 92, 92, 93, 93, 93, 93, 93, 93, 93, 94, 94, 94, 94, 94, 94, 95, 95, 95, 95, 95, 95, 96, 96, 96, 96, 96, 96, 97, 97, 97, 97, 97, 97, 98, 98, 98, 98, 98, 98, 99, 99, 99, 99, 99, 99, 100, 100, 100, 100, 100, 101, 101, 101, 101, 101, 102, 102, 102, 102, 102, 103, 103, 103, 103, 103, 104, 104, 104, 104, 104, 105, 105, 105, 105, 105, 106, 106, 106, 106, 106, 107, 107, 107, 107, 107, 108, 108, 108, 108, 108, 109, 109, 109, 109, 109, 110, 110, 110, 110, 110, 111, 111, 111, 111, 111, 112, 112, 112, 113, 113, 113, 114, 114, 114, 115, 115, 115, 116, 116, 116, 117, 117, 117, 118, 118, 118, 119, 119, 119, 120, 120, 120, 121, 121, 121, 122, 122, 122, 123, 123, 123, 124, 124, 124, 125, 125, 125, 126, 126, 126, 127, 127, 127, 128, 128, 128, 129, 129, 129, 130, 130, 130, 131, 131, 131, 132, 132, 132, 133, 133, 133, 134, 134, 135, 135, 136, 136, 137, 137, 138, 138, 139, 139, 140, 140, 141, 141, 142, 142, 143, 143, 144, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170}));
    }

    class Solution {
        public boolean isPossible(int[] nums) {
            if (nums.length == 0) return true;
            int p1 = 0, p2 = 0, p3 = 0;
            int last = Integer.MIN_VALUE;
            int c1 = 0, c2 = 0, c3 = 0;

            for (int i = 0; i < nums.length; ) {

                int cur = nums[i], cnt = 0;
                while (i < nums.length && cur == nums[i]) {
                    i++;
                    cnt++;
                }

                if (cur - last == 1) {
                    if (cnt < p1 + p2) return false;

                    c2 = p1;
                    c3 = p2 + Math.min(p3, cnt - p1 - p2);
                    c1 = Math.max(0, cnt - p1 - p2 - p3);
                } else {
                    if (p1 != 0 || p2 != 0) return false;
                    c1 = cnt;
                    c2 = 0;
                    c3 = 0;
                }

                last = cur;
                p1 = c1;
                p2 = c2;
                p3 = c3;
            }

            return p1 == 0 && p2 == 0;
        }
    }

    class Solution1 {
        public boolean isPossible(int[] nums) {
            PriorityQueue<int[]> pending = new PriorityQueue<>((e, f) -> e[0] == f[0] ? e[1] - f[1] : e[0] - f[0]);
            Map<Integer, Integer> finished = new HashMap<>();

            for (int n : nums) {
                if (!pending.isEmpty() && n > pending.peek()[0] + 1) return false;

                Integer cnt = finished.get(n - 1);
                if (pending.size() > 0 && n == pending.peek()[0] + 1) {
                    int[] top = pending.poll();
                    top[0] = n;
                    top[1]++;
                    if (top[1] == 3) {
                        finished.put(n, finished.getOrDefault(n, 0) + 1);
                    } else {
                        pending.offer(top);
                    }
                } else if (cnt != null) {
                    finished.put(n, finished.getOrDefault(n, 0) + 1);
                    if (cnt == 1) finished.remove(n - 1);
                    else finished.put(n - 1, cnt - 1);
                } else {
                    pending.offer(new int[]{n, 1});
                }
            }
            return pending.size() == 0;
        }
    }
}
