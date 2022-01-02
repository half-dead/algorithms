package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *
 * @author half-dead
 */
public class Puzzle381 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        Iterator<Integer> it = set.iterator();
        System.out.println(it.next());
        set.add(2);
        System.out.println(set.iterator().next());
    }

    class RandomizedCollection {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());

        public RandomizedCollection() {
        }

        public boolean insert(int val) {
            boolean b = map.containsKey(val);
            map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
            list.add(val);
            return !b;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            Set<Integer> indexies = map.get(val);
            int swapIndex = indexies.iterator().next();
            indexies.remove(swapIndex);
            if (indexies.size() == 0) map.remove(val);

            if (swapIndex != list.size() - 1) {
                int temp = list.get(list.size() - 1);
                list.set(swapIndex, temp);
                Set<Integer> tmpIndexies = map.get(temp);
                tmpIndexies.add(swapIndex);
                tmpIndexies.remove(list.size() - 1);
            }
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
