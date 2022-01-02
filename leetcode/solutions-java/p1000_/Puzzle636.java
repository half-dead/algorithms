package p1000_;

import util.Print;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle636 {

    public static void main(String[] args) {
        Solution s = new Puzzle636().new Solution();
        Print.pt(s.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))); // 3, 4
        Print.pt(s.exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"))); // 7, 1
        Print.pt(s.exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))); // 8
    }

    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n], stack = new int[logs.size() >> 1], tmp = new int[3];
            int prevTime = 0, pos = 0;
            for (String log : logs) {
                parse(log.toCharArray(), tmp);
                int fid = tmp[0], time = tmp[2];
                if (tmp[1] == 's') {
                    if (pos > 0) res[stack[pos - 1]] += time - prevTime;
                    stack[pos++] = fid;
                } else {
                    res[stack[--pos]] += ++time - prevTime;
                }
                prevTime = time;
            }
            return res;
        }

        void parse(char[] cs, int[] tmp) {
            int i, n, len = cs.length;
            for (i = 0, n = 0; cs[i] != ':'; i++) n = n * 10 + cs[i] - '0';
            tmp[0] = n;

            tmp[1] = cs[++i];
            while (cs[i] != ':') i++;

            for (n = 0, i++; i < len; i++) n = n * 10 + cs[i] - '0';
            tmp[2] = n;
        }
    }

    class Solution1 {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];
            LinkedList<Integer> stack = new LinkedList<>();
            int prevTime = 0;
            for (String log : logs) {
                int p1 = log.indexOf(':'), p2 = log.indexOf(':', p1 + 4);
                int fid = Integer.parseInt(log.substring(0, p1)), time = Integer.parseInt(log.substring(p2 + 1));
                if (log.charAt(p1 + 1) == 's') {
                    if (!stack.isEmpty()) res[stack.peek()] += time - prevTime;
                    stack.push(fid);
                    prevTime = time;
                } else {
                    res[stack.pop()] += time - prevTime + 1;
                    prevTime = time + 1;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];

            LinkedList<U> stack = new LinkedList<>();
            for (String log : logs) {
                int p1 = log.indexOf(':'), p2 = log.indexOf(':', p1 + 4);
                int fid = Integer.parseInt(log.substring(0, p1)), time = Integer.parseInt(log.substring(p2 + 1));
                boolean start = log.charAt(p1 + 1) == 's';

                if (start) stack.push(new U(time));
                else {
                    int sleep = 0;
                    U u;
                    while (stack.peek().finished) sleep += ((u = stack.pop()).end - u.start + 1);
                    (u = stack.peek()).end = time;
                    u.finished = true;
                    res[fid] += time - u.start + 1 - sleep;
                }
            }
            return res;
        }

        class U {
            int start, end;
            boolean finished;

            public U(int start) {
                this.start = start;
            }
        }
    }


}
