package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author half-dead
 */
public class Puzzle1700 {

    class Solution {
        public int countStudents(int[] stu, int[] sandw) {
            int[] count = {0, 0};
            int n = stu.length, k;
            for (int a : stu) count[a]++;
            for (k = 0; k < n && count[sandw[k]] > 0; k++) count[sandw[k]]--;
            return n - k;
        }
    }

    class Solution1 {
        public int countStudents(int[] students, int[] sandwiches) {
            int i = 0, j = 0, n = students.length;
            int ones = Arrays.stream(students).sum(), zeros = n - ones;
            while (j < n) {
                if (students[i] == 2) {
                    i++;
                } else if (students[i] == sandwiches[j++]) {
                    ones -= students[i];
                    zeros -= (1 - students[i]);
                    students[i++] = 2;
                } else {
                    if (sandwiches[j] == 0 && zeros == 0) break;
                    else if (sandwiches[j] == 1 && ones == 0) break;
                    else i++;
                }
                i %= n;
            }
            return zeros + ones;
        }
    }
}
