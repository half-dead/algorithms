package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 *
 * @author half-dead
 */
public class Puzzle301 {

    // BFS
    public class BFSSolution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();

            Set<String> seen = new HashSet<>();
            seen.add(s);

            Queue<String> q = new LinkedList<>();
            q.add(s);

            boolean found = false;
            while (!q.isEmpty()) {
                s = q.poll();
                if (isValid(s)) {
                    res.add(s);
                    found = true;
                }

                if (found) continue;

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c != '(' && c != ')') continue;

                    String t = s.substring(0, i) + s.substring(i + 1);
                    if (seen.add(t)) q.add(t);
                }
            }

            return res;
        }

        boolean isValid(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') count++;
                if (c == ')' && count-- == 0) return false;
            }
            return count == 0;
        }
    }

    // backtracking
    class BacktrackingSolution {
        char[] cs;
        int n;
        int[] max = new int[1];
        Set<String> res = new HashSet<>();

        public List<String> removeInvalidParentheses(String s) {
            cs = s.toCharArray();
            n = cs.length;
            bt(0, 0, new StringBuilder());
            return new ArrayList<>(res);
        }

        void bt(int i, int open, StringBuilder sb) {
            if (i == n && open == 0) {
                if (sb.length() > max[0]) {
                    res.clear();
                    max[0] = sb.length();
                }
                if (sb.length() == max[0]) res.add(sb.toString());
            }
            if (i == n || sb.length() + (n - i) < max[0]) return;

            if (cs[i] == '(') {
                sb.append(cs[i]);
                bt(i + 1, open + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                bt(i + 1, open, sb);
            } else if (cs[i] == ')') {
                if (open != 0) {
                    sb.append(cs[i]);
                    bt(i + 1, open - 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
                bt(i + 1, open, sb);
            } else {
                sb.append(cs[i]);
                bt(i + 1, open, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
