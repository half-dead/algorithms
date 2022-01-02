package p1000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 *
 * @author half-dead
 */
public class Puzzle955 {

    public static void main(String[] args) {
        Solution s = new Puzzle955().new Solution();
        System.out.println(s.minDeletionSize(new String[]{"ca", "bb", "ac"}));
        System.out.println(s.minDeletionSize(new String[]{"xc", "yb", "za"}));
        System.out.println(s.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(s.minDeletionSize(new String[]{"xga", "xfb", "yfa"}));
    }

    class Solution {
        public int minDeletionSize(String[] a) {
            int rows = a.length, cols = a[0].length();
            boolean[] skip = new boolean[rows - 1];

            int ans = 0;
            outer:
            for (int c = 0; c < cols; c++) {
                for (int r = 0; r < rows - 1; r++)
                    if (!skip[r] && a[r].charAt(c) > a[r + 1].charAt(c)) {
                        ans++;
                        continue outer;
                    }

                boolean skipAll = true;
                for (int r = 0; r < rows - 1; r++)
                    if (a[r].charAt(c) < a[r + 1].charAt(c)) skip[r] = true;
                    else skipAll = false;
                if (skipAll) break;
            }
            return ans;
        }
    }

    class Solution2 {
        public int minDeletionSize(String[] a) {
            int rows = a.length, cols = a[0].length(), min = 0;
            if (rows == 1) return 0;

            List<Integer> q = new ArrayList<>(rows - 1);
            for (int r = 1; r < rows; r++) q.add(r);

            for (int c = 0; c < cols; c++) {
                boolean larger = false, eq = false;
                List<Integer> nq = new ArrayList<>();

                for (int r : q) {
                    int d = a[r - 1].charAt(c) - a[r].charAt(c);
                    if (d > 0) {
                        larger = true;
                        break;
                    } else if (d == 0) eq = nq.add(r);
                }

                if (larger) min++;
                else if (eq) q = nq;
                else break;
            }
            return min;
        }
    }
}
