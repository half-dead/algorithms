package p0500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * @author half-dead
 */
public class Puzzle032_LongestValidParentheses {

    public static void main(String[] args) {
        Puzzle032_LongestValidParentheses p = new Puzzle032_LongestValidParentheses();
        Solution s = p.new Solution();
        System.out.println(s.longestValidParentheses("()()))))()()("));
        System.out.println(s.longestValidParentheses(")()())()()("));
        System.out.println(s.longestValidParentheses("(())()"));
    }

    class DpSolution {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')') {
                    int j = i - 1;
                    int matchingIndex = i - 1 - dp[j];
                    if (matchingIndex >= 0 && s.charAt(matchingIndex) == '(') {
                        dp[i] = dp[j] + 2;
                        j = matchingIndex - 1;
                        while (j >= 0 && dp[j] > 0) {
                            dp[i] += dp[j];
                            j -= dp[j];
                        }
                    }

                }
            }
            int max = 0;
            for (int i : dp) {
                max = Math.max(max, i);
            }
            return max;
        }
    }

    class StackSolution {
        public int longestValidParentheses(String s) {
            int max = 0;
            LinkedList<Integer> stack = new LinkedList<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }
    }

    // NEAT!!
    public class Solution {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') left++;
                else right++;

                if (left == right) {
                    maxLen = Math.max(maxLen, 2 * right);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxLen = Math.max(maxLen, 2 * left);
                } else if (left >= right) {
                    left = right = 0;
                }
            }
            return maxLen;
        }
    }
}
