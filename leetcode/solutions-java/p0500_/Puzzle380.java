package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * @author half-dead
 */
public class Puzzle380 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random rand;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random(System.currentTimeMillis());
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int idx = map.get(val);
            if (idx != list.size() - 1) {
                int temp = list.get(list.size() - 1);
                list.set(idx, temp);
                map.put(temp, idx);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

}
