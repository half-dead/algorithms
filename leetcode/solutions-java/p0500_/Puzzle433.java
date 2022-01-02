package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 *
 * @author half-dead
 */
public class Puzzle433 {

    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> valid = new HashSet<>();
            Collections.addAll(valid, bank);
            if (!valid.contains(end)) return -1;

            char[] acgt = new char[]{'A', 'C', 'G', 'T'};
            Queue<String> q = new LinkedList<>();
            q.offer(start);
            int step = 0;
            while (q.size() > 0) {
                int sz = q.size();
                while (sz-- > 0) {
                    String gene = q.poll();
                    if (end.equals(gene)) return step;

                    char[] cs = gene.toCharArray();
                    for (int i = 0; i < 8; i++) {
                        char original = cs[i];
                        for (char c : acgt) {
                            if (c == original) continue;

                            cs[i] = c;
                            String mutate = new String(cs);
                            if (valid.remove(mutate)) q.offer(mutate);
                        }
                        cs[i] = original;
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
