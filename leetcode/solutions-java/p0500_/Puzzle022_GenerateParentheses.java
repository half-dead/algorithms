package p0500_;

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
// For example, given n = 3, a solution set is:
// "((()))", "(()())", "(())()", "()(())", "()()()"

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Puzzle022_GenerateParentheses {

    public class Solution {
        public List<String> generateParenthesis(int n) {
            LinkedList<String> list = new LinkedList<>();
            recur("", n, 0, list, 2 * n);
            return list;
        }

        public void recur(String prefix, int left, int right, List<String> list, int maxLen) {
            if (prefix.length() == maxLen) {
                list.add(prefix);
                return;
            }
            if (right > 0) {
                recur(prefix + ")", left, right - 1, list, maxLen);
            }
            if (left > 0) {
                recur(prefix + "(", left - 1, right + 1, list, maxLen);
            }
        }
    }

    public class StupidSolution {
        public List<String> generateParenthesis(int n) {
            LinkedList<String> list = new LinkedList<>();
            list.addLast("()");
            for (int i = 0; i < n - 1; i++) {
                int size = list.size();
                Set<String> temp = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    String pop = list.pop();
                    for (int k = 0; k < pop.length(); k++) {
                        String str = pop.substring(0, k) + "()" + pop.substring(k);
                        if (temp.add(str)) {
                            list.addLast(str);
                        }
                    }
                }
            }
            return list;
        }
    }

}
