package p1500_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sequential-digits/
 *
 * @author half-dead
 */
public class Puzzle1291 {
    public static void main(String[] args) {
        bfsSolution s = new Puzzle1291().new bfsSolution();
        System.out.println(s.sequentialDigits(1786, 23789049));
    }

    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            int minDigits = 0, maxDigits = 0;
            for (int n = low; n > 0; n /= 10) minDigits++;
            for (int n = high; n > 0; n /= 10) maxDigits++;

            List<Integer> result = new LinkedList<>();
            for (int digits = minDigits; digits <= maxDigits; digits++) {
                int firstDigitOfMin = 1, firstDigitOfMax = 10 - digits, min = 0, max = 0, step = 0, d = digits;
                while (d-- > 0) {
                    min = min * 10 + firstDigitOfMin++;
                    max = max * 10 + firstDigitOfMax++;
                    step = step * 10 + 1;
                }

                for (int n = min; n <= max; n += step) if (n >= low && n <= high) result.add(n);
            }
            return result;
        }
    }

    class bfsSolution {
        public List<Integer> sequentialDigits(int low, int high) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < 9; i++) q.add(i);

            List<Integer> ans = new ArrayList<>();
            while (q.size() > 0) {
                int curr = q.remove();
                if (curr >= low && curr <= high) ans.add(curr);
                int lastDigit = curr % 10, next = curr * 10 + lastDigit + 1;
                if (lastDigit < 9 && next <= high) q.add(next);
            }
            return ans;
        }
    }
}
