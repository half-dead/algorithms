package p1000_;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 *
 * @author half-dead
 */
public class Puzzle856_ScoreOfParentheses {
    class Solution {
        public int scoreOfParentheses(String s) {
            int len = s.length();
            Deque<Integer> q = new ArrayDeque<>();
            int i = 0;
            while (i < len) {
                char c = s.charAt(i);
                if (c == '(') {
                    q.push(0);
                } else {
                    int n = 0;
                    while (q.size() > 0 && q.peek() != 0) {
                        n += q.pop();
                    }
                    q.pop();
                    q.push(n == 0 ? 1 : (n * 2));
                }
                i++;
            }
            int sum = 0;
            while (q.size() > 0) {
                sum += q.pop();
            }
            return sum;
        }
    }

    // r don't understand this.
    class Solution2 {
        public int scoreOfParentheses(String s) {
            int ans = 0, bal = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    bal++;
                } else {
                    bal--;
                    if (s.charAt(i - 1) == '(') {
                        ans += 1 << bal;
                    }
                }
            }
            return ans;
        }
    }
}
