package p1500_;

import java.util.Arrays;

/**
 * Generate a String With Characters That Have Odd Counts
 * https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 *
 * @author half-dead
 */
public class Puzzle1374 {
    class Solution {
        public String generateTheString(int n) {
            char[] a = new char[n];
            Arrays.fill(a, 'a');
            a[0] = (char) ('a' + (1 - n % 2));
            return new String(a);
        }
    }
}
