package p1500_;

/**
 * https://leetcode.com/problems/day-of-the-year/
 *
 * @author half-dead
 */
public class Puzzle1154 {
    public static void main(String[] args) {
        Solution s = new Puzzle1154().new Solution();
        System.out.println(s.dayOfYear("2019-02-10"));
        System.out.println(s.dayOfYear("2016-02-29"));
    }

    class Solution {
        public int dayOfYear(String date) {
            String[] ymd = date.split("-");
            int y = Integer.parseInt(ymd[0]), m = Integer.parseInt(ymd[1]), d = Integer.parseInt(ymd[2]), sum = 0;
            boolean leap = y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
            int[] months = new int[]{0, 31, leap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 1; i < m; i++) sum += months[i];
            return sum + d;
        }
    }
}
