package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/
 *
 * @author half-dead
 */
public class Puzzle1717 {

    // use two integer other than stack
    class Solution {
        public int maximumGain(String s, int x, int y) {
            char p = x >= y ? 'a' : 'b', q = x >= y ? 'b' : 'a';

            int res = 0, hi = Math.max(x, y), lo = Math.min(x, y), cp = 0, cq = 0;
            for (char c : s.toCharArray()) {
                if (c == p) {
                    cp++;
                } else if (c == q) {
                    if (cp > 0) {
                        res += hi;
                        cp--;
                    } else {
                        cq++;
                    }
                } else {
                    res += lo * Math.min(cp, cq);
                    cp = cq = 0;
                }
            }
            res += lo * Math.min(cp, cq);
            return res;
        }
    }

    // Stack
    class Solution1 {
        public int maximumGain(String s, int x, int y) {
            char p = x >= y ? 'a' : 'b', q = x >= y ? 'b' : 'a';

            int res = 0, hi = Math.max(x, y), lo = Math.min(x, y);
            LinkedList<Character> stack = new LinkedList<>();
            char[] cs = s.toCharArray();
            for (int i = 0; i <= cs.length; i++) {
                char c = i == cs.length ? 'c' : cs[i];
                if (c > 'b') {
                    int cp = 0;
                    while (stack.size() > 0) {
                        if (stack.peek() == p) {
                            cp++;
                            stack.pop();
                        } else {
                            res += lo * Math.min(stack.size(), cp);
                            break;
                        }
                    }
                    stack.clear();
                } else {
                    if (stack.size() > 0 && stack.peek() == p && c == q) {
                        res += hi;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            return res;
        }
    }
}
