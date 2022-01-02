package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/k-similar-strings/
 *
 * @author half-dead
 */
public class Puzzle854 {

    // BFS
    class Solution {
        public int kSimilarity(String a, String b) {
            int swaps = 0;

            Deque<String> dq = new LinkedList<>();
            dq.addLast(a);

            Set<String> visited = new HashSet<>();
            visited.add(a);

            for (int size = dq.size(); size > 0; size = dq.size()) {
                while (size-- > 0) {
                    String prev = dq.poll();
                    if (b.equals(prev)) return swaps;

                    for (String next : findNeighbours(prev, b))
                        if (visited.add(next)) dq.addLast(next);
                }
                swaps++;
            }

            return -1;
        }

        private List<String> findNeighbours(String a, String b) {
            List<String> res = new ArrayList<>();
            char[] cs = a.toCharArray();

            int i = 0, n = cs.length;
            while (cs[i] == b.charAt(i)) i++;

            for (int j = i + 1, c = b.charAt(i); j < n; j++) {
                if (cs[j] == c) {
                    swap(cs, i, j);
                    res.add(new String(cs));
                    swap(cs, i, j);
                }
            }
            return res;
        }

        private void swap(char[] cs, int i, int j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }
}
