package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 *
 * @author half-dead
 */
public class Puzzle1541 {

    class Solution2 {
        public int minInsertions(String s) {
            int result = 0;
            s = s.replaceAll("\\)\\)", "]");

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    result++;
                }
            }

            LinkedList<Character> q = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    q.push('(');
                } else {
                    if (q.size() == 0) {
                        result++;
                    } else {
                        q.pop();
                    }
                }
            }
            return result + q.size() * 2;
        }
    }

    class Solution {
        public int minInsertions(String s) {
            int result = 0, cnt = 0, q = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    if (cnt != 0) {
                        result++;
                        if (q > 0) {
                            q--;
                        } else {
                            result++;
                        }
                    }
                    q++;
                    cnt = 0;
                } else {
                    cnt++;
                    if (cnt == 2) {
                        if (q > 0) {
                            q--;
                        } else {
                            result++;
                        }
                        cnt = 0;
                    }
                }
            }
            if (cnt > 0) {
                result++;
                if (q > 0) {
                    q--;
                } else {
                    result++;
                }
            }

            return result + 2 * q;
        }
    }
}
