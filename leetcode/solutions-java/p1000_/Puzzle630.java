package p1000_;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/course-schedule-iii/
 *
 * @author half-dead
 */
public class Puzzle630 {

    public static void main(String[] args) {
        Solution s = new Puzzle630().new Solution();
//        System.out.println(s.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
//        System.out.println(s.scheduleCourse(new int[][]{{1, 2}}));
//        System.out.println(s.scheduleCourse(new int[][]{{3, 2}, {4, 3}}));
//        System.out.println(s.scheduleCourse(new int[][]{{7, 16}, {2, 3}, {3, 12}, {3, 14}, {10, 19}, {10, 16}, {6, 8}, {6, 11}, {3, 13}, {6, 16}}));
        System.out.println(s.scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}}));
        System.out.println(s.scheduleCourse(new int[][]{{7, 11}, {1, 11}, {1, 3}, {2, 6}, {5, 6}, {7, 7}, {4, 8}, {2, 20}, {1, 17}, {8, 11}}));
        System.out.println(s.scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}}));
        System.out.println(s.scheduleCourse(new int[][]{{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}}));
    }

    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (x, y) -> {
                int d = x[0] - y[0];
                return d == 0 ? x[1] - y[1] : d;
            });

            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
                int d = x[1] - y[1];
                return d == 0 ? x[0] - y[0] : d;
            });
            int day = 0, ans = 0;
            for (int[] c : courses) {
                int start = c[1] - c[0];
                while (pq.size() > 0 && pq.peek()[1] <= start) {
                    int[] cand = pq.poll();
                    if (day + cand[0] <= cand[1]) {
                        day += cand[0];
                        ans++;
                        System.out.print("---- ");
                    }
                    System.out.println(Arrays.toString(cand));
                }
                pq.offer(c);
            }

            while (pq.size() > 0) {
                int[] cand = pq.poll();
                if (day + cand[0] <= cand[1]) {
                    day += cand[0];
                    ans++;
                    System.out.print("---- ");
                }
                System.out.println(Arrays.toString(cand));
            }
            System.out.println("\n\n\n");
            return ans;
        }
    }

}
