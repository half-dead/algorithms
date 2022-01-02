package p1000_;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/stamping-the-sequence/
 *
 * @author half-dead
 */
public class Puzzle936 {

    // greedy
    class Solution {
        public int[] movesToStamp(String stamp, String target) {
            char[] cs = target.toCharArray(), ct = stamp.toCharArray();

            Deque<Integer> stack = new LinkedList<>();
            int n = target.length(), m = stamp.length(), remain = n;
            boolean[] visited = new boolean[n];
            while (remain > 0) {
                int start = 0, cnt = 0;
                List<Integer> temp = new ArrayList<>();
                // greedly find matches as many as possible, these matches doesn't affect each other
                // meanning the order of how we stamp at these indexes doesn't matter, the result will be the same
                while (start <= n - m) {
                    if (!visited[start] && match(cs, ct, start)) {
                        temp.add(start);
                        visited[start] = true;
                        start += m;
                    } else start++;
                }

                // there are still alphabets(non ?), but could't find a match at any index
                if (temp.size() == 0) return new int[0];

                // replace alphabets with ?, count how many are replaced at this round
                for (int x : temp) {
                    for (int j = 0; j < m; j++) {
                        if (cs[x + j] != '?') cnt++;
                        cs[x + j] = '?';
                    }
                }

                // reduce remaining after each round
                remain -= cnt;
                // push to stack
                for (int x : temp) stack.push(x);
            }

            int[] res = new int[stack.size()];
            for (int i = 0; i < res.length; i++) res[i] = stack.pop();
            return res;
        }

        // could apply KMP here
        boolean match(char[] cs, char[] stamp, int i) {
            int cnt = 0;
            for (int j = 0; j < stamp.length; j++) {
                if (cs[i + j] == stamp[j]) cnt++;
                else if (cs[i + j] != '?') return false;
            }
            return cnt > 0;
        }
    }
}
