package p1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-closest-palindrome/
 *
 * @author half-dead
 */
public class Puzzle564 {

    class Solution {
        public String nearestPalindromic(String n) {
            long m = Long.parseLong(n);
            if (m == 1) return "0";

            long lo = find(n, false), hi = find(n, true);
            if (hi - m < m - lo) return "" + hi;
            return "" + lo;
        }

        long find(String base, boolean greater) {
            int n = base.length();

            String mid = n % 2 == 0 ? "" : ("" + base.charAt(n / 2));
            String left = base.substring(0, n / 2);
            String right = new StringBuilder(left).reverse().toString();

            String temp = left + mid + right;
            long candidate = Long.parseLong(temp);
            long m = Long.parseLong(base);
            if (candidate > m && greater) return candidate;
            if (candidate < m && !greater) return candidate;

            String part = n % 2 == 0 ? left : (left + mid);
            long partn = Long.parseLong(part);

            if (greater) {
                partn++;
                if ((partn + "").length() > part.length()) {
                    return Long.parseLong("1" + zeros.substring(0, n - 1) + "1");
                }
            } else {
                partn--;
                if (partn == 0 || (partn + "").length() < part.length()) {
                    return Long.parseLong(nines.substring(0, n - 1));
                }
            }
            StringBuilder tail = new StringBuilder().append(partn).reverse();
            if (n % 2 != 0) tail.deleteCharAt(0);
            return Long.parseLong((partn + "") + tail);
        }

        final String nines = "99999999999999999999";
        final String zeros = "00000000000000000000";
    }


    // the idea is same, but more readable and understandable
    class Solution1 {
        public String nearestPalindromic(String n) {
            int len = n.length();
            boolean even = (len % 2 == 0);

            int half = even ? len / 2 - 1 : len / 2;
            long left = Long.parseLong(n.substring(0, half + 1));

            List<Long> list = new ArrayList<>();
            list.add(constructPalindrome(left, even));
            list.add(constructPalindrome(left + 1, even));
            list.add(constructPalindrome(left - 1, even));
            list.add((long) Math.pow(10, len - 1) - 1); // 0 or 9.......9
            list.add((long) Math.pow(10, len) + 1); // 1[0....]1

            long ans = 0, minDiff = Long.MAX_VALUE, original = Long.parseLong(n);
            for (long num : list) {
                if (num == original) continue;
                long diff = Math.abs(num - original);
                if (diff < minDiff) {
                    minDiff = diff;
                    ans = num;
                } else if (diff == minDiff && num < ans) {
                    ans = num;
                }
            }
            return String.valueOf(ans);
        }

        private long constructPalindrome(long left, boolean even) {
            long res = left;
            if (!even) left /= 10;

            while (left > 0) {
                res = res * 10 + left % 10;
                left /= 10;
            }
            return res;
        }
    }
}
