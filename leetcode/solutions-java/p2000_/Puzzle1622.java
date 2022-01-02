package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/fancy-sequence/
 *
 * @author half-dead
 */
public class Puzzle1622 {

    public static void main(String[] args) {
        Fancy fancy = new Puzzle1622().new Fancy();
        fancy.append(2);   // fancy sequence: [2]
        fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
        fancy.append(7);   // fancy sequence: [5, 7]
        fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
        fancy.getIndex(0); // return 10
        fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
        fancy.append(10);  // fancy sequence: [13, 17, 10]
        fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
        fancy.getIndex(0); // return 26
        fancy.getIndex(1); // return 34
        fancy.getIndex(2); // return 20
        System.out.println();
    }

    class Fancy {

        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        Map<Integer, int[]> cache = new HashMap<>();
        int mod = (int) (1e9 + 7);

        public Fancy() {

        }

        public void append(int val) {
            list.add(val);
        }

        public void addAll(int inc) {
            int key = list.size();
            List<Integer> slot = tm.computeIfAbsent(key, x -> new ArrayList<>());
            int lastop = 0, size = slot.size();
            if (size > 0) {
                lastop = slot.get(size - 1);
            }

            if (lastop > 0) {
                slot.set(size - 1, lastop + inc);
            } else {
                slot.add(inc);
            }
        }

        public void multAll(int m) {
            int key = list.size();
            List<Integer> slot = tm.computeIfAbsent(key, x -> new ArrayList<>());
            int lastop = 0, size = slot.size();
            if (size > 0) {
                lastop = slot.get(size - 1);
            }

            if (lastop < 0) {
                slot.set(size - 1, lastop - m);
            } else {
                slot.add(-m);
            }
        }

        public int getIndex(int idx) {
            int size = list.size();
            if (idx >= size) return -1;

            int[] begin = cache.get(idx);
            if (begin == null) {
                begin = new int[]{idx + 1, 0};
            }

            long val = list.get(idx);

            java.util.NavigableMap<Integer, List<Integer>> submap = tm.tailMap(begin[0], true);
            for (int key : submap.keySet()) {
                int i = 0;
                if (key == begin[0]) {
                    i = begin[1];
                }
                List<Integer> oplist = submap.get(key);
                while (i < oplist.size()) {
                    int op = oplist.get(i++);
                    val = op > 0 ? (val + op) : (val * -op);
                    val %= mod;
                }
            }
            if (submap.size() > 0) {
                cache.put(idx, new int[]{tm.lastEntry().getKey(), tm.lastEntry().getValue().size()});
            }
            list.set(idx, (int) val);
            return (int) val;
        }
    }
}
