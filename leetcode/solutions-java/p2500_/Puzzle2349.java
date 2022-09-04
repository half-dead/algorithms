package p2500_;

import java.util.*;

/**
 * @author half-dead
 */
public class Puzzle2349 {

    class NumberContainers {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, TreeSet<Integer>> first = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            Integer prev = map.put(index, number);
            if (prev != null && prev != number) {
                first.get(prev).remove(index);
            }
            first.computeIfAbsent(number, x -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            TreeSet<Integer> ts = first.getOrDefault(number, new TreeSet<>());
            return ts.size() > 0 ? ts.first() : -1;
        }
    }


}
