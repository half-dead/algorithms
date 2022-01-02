package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/random-pick-with-blacklist/
 *
 * @author half-dead
 */
public class Puzzle710 {

    class Solution {

        Random rand;
        int max;
        Map<Integer, Integer> map;

        public Solution(int n, int[] blacklist) {
            rand = new Random(System.currentTimeMillis());
            max = n - blacklist.length;

            Set<Integer> set = new HashSet<>(blacklist.length);
            for (int x = n - 1; x >= max; x--) set.add(x);

            for (int b : blacklist) if (b >= max) set.remove(b);

            Iterator<Integer> it = set.iterator();
            map = new HashMap<>(set.size());
            for (int b : blacklist) if (b < max) map.put(b, it.next());
        }

        public int pick() {
            int seed = rand.nextInt(max);
            return map.getOrDefault(seed, seed);
        }
    }
}
