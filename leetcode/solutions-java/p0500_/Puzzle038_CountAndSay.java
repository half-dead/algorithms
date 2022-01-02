package p0500_;

// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.
//
// Note: The sequence of integers will be represented as a string.

/**
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class Puzzle038_CountAndSay {

    public static void main(String[] args) {
        Puzzle038_CountAndSay puzzle038 = new Puzzle038_CountAndSay();
        Solution solution = puzzle038.new Solution();
        String s = solution.countAndSay(50);
        System.out.println(s);
    }

    public class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            StringBuilder prev = new StringBuilder(100);
            StringBuilder next = new StringBuilder(100);
            prev.append('1');
            for (int i = 1; i < n; i++) {
                char c1 = prev.charAt(0);
                int count = 1;
                int len = prev.length();
                for (int j = 1; j < len; j++) {
                    char c2 = prev.charAt(j);
                    if (c2 == c1) {
                        count++;
                    } else {
                        next.append(count).append(c1);
                        c1 = c2;
                        count = 1;
                    }
                }
                next.append(count).append(c1);
                prev = next;
                next = new StringBuilder(100);
            }
            return prev.toString();
        }
    }
}
