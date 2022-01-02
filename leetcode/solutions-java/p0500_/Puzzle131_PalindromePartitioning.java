package p0500_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * @author half-dead
 */
public class Puzzle131_PalindromePartitioning {
    public static void main(String[] args) {
        Puzzle131_PalindromePartitioning p = new Puzzle131_PalindromePartitioning();
        Solution s = p.new Solution();
        System.out.println(s.partition("aab"));
    }

    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            backtracking(result, new LinkedList<>(), s.toCharArray(), 0);
            return result;
        }

        void backtracking(List<List<String>> result, LinkedList<String> current, char[] chars, int begin) {
            if (begin == chars.length) result.add(new ArrayList<>(current));

            for (int i = begin; i < chars.length; i++) {
                if (isPalindrome(chars, begin, i)) {
                    current.addLast(new String(chars, begin, i - begin + 1));
                    backtracking(result, current, chars, i + 1);
                    current.removeLast();
                }
            }
        }

        boolean isPalindrome(char[] chars, int left, int right) {
            while (left <= right)
                if (chars[left++] != chars[right--]) return false;
            return true;
        }
    }
}
