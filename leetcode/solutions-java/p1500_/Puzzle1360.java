package p1500_;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 *
 * @author half-dead
 */
public class Puzzle1360 {

    class Solution {
        int[] dom = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int daysBetweenDates(String date1, String date2) {
            String[] d1 = date1.split("-"), d2 = date2.split("-");
            return Math.abs(daysFrom19710101(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2])) - daysFrom19710101(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[2])));
        }

        int daysFrom19710101(int year, int month, int day) {
            int days = 0;
            for (int y = 1971; y < year; y++) days += leap(y) ? 366 : 365;
            for (int m = 1; m < month; m++) days += dom[m];
            if (leap(year) && month > 2) days++;
            return days + day;
        }

        boolean leap(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
    }
}
