package p2000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author half-dead
 */
public class Puzzle1743 {

    public static void main(String[] args) {
        Solution s = new Puzzle1743().new Solution();
        System.out.println(s.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}}));
    }

    class Solution {
        public int[] restoreArray(int[][] ps) {
            Set<Integer> ht = new HashSet<>();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] p : ps) {
                if (!ht.remove(p[0])) ht.add(p[0]);
                if (!ht.remove(p[1])) ht.add(p[1]);
                map.computeIfAbsent(p[0], a -> new HashSet<>()).add(p[1]);
                map.computeIfAbsent(p[1], a -> new HashSet<>()).add(p[0]);
            }
            int[] res = new int[ps.length + 1];
            int prev = ht.iterator().next();
            for (int i = 0; ; ) {
                res[i] = prev;
                if (++i < res.length) {
                    int next = map.get(prev).iterator().next();
                    map.get(next).remove(prev);
                    prev = next;
                } else break;
            }
            return res;
        }
    }

}
