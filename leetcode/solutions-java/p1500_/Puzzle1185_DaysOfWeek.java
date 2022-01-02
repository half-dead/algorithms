package p1500_;

/**
 * https://leetcode.com/problems/day-of-the-week/
 *
 * @author half-dead
 */
public class Puzzle1185_DaysOfWeek {

    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            // with the knowledge of '1971-1-1' is Friday
            String[] dict = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

            int count = 0;
            for (int y = 1971; y < year; y++) {
                if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) count += 366;
                else count += 365;
            }

            int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) daysOfMonth[1]++;

            for (int m = 1; m < month; m++) {
                count += daysOfMonth[m - 1];
            }
            count += day - 1;
            return dict[count % 7];
        }
    }
}
