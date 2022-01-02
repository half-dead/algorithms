package p0500_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/count-the-repetitions/
 *
 * @author half-dead
 */
public class Puzzle466 {

    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            for (char c : s2.toCharArray()) {
                if (s1.indexOf(c) == -1) return 0;
            }

            String unit = unit(s2);
            n2 = n2 * (s2.length() / unit.length());

            Deque<int[]> dq = new LinkedList<>();
            for (char c : unit.toCharArray()) dq.addLast(new int[]{c, 1});

            for (int i = 0, len = s1.length(); i < len; i++) {
                if (s1.charAt(i) != dq.peekFirst()[0]) continue;
                dq.addLast(dq.pollFirst());
                dq.peekLast()[1]++;
            }
            int k = dq.peekFirst()[1] - 1;
            if (k > 0) return (k * n1) / (n2);


            dq.clear();
            for (char c : s1.toCharArray()) {
                if (unit.indexOf(c) != -1) dq.addLast(new int[]{c, 1});
            }
            k = 0;
            for (int i = 0, len = unit.length(); i < len; i++) {
                while (dq.peekFirst()[0] != unit.charAt(i)) {
                    int[] x = dq.pollFirst();
                    x[1]++;
                    dq.addLast(x);
                }
                int[] x = dq.pollFirst();
                k = Math.max(k, x[1]);
                x[1]++;
                dq.addLast(x);
            }
            return n1 / (k * n2);
        }

        private String unit(String s) {
            int n = s.length();
            for (int i = 1; i <= n; i++) {
                if (n % i != 0) continue;
                String unit = s.substring(0, i);
                String temp = repeat(unit, n / i);
                if (s.equals(temp)) {
                    return unit;
                }
            }
            return s;
        }

        private String repeat(String s, int n) {
            StringBuilder sb = new StringBuilder(n * s.length());
            while (n-- > 0) sb.append(s);
            return sb.toString();
        }
    }
}
