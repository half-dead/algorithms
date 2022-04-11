package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/finding-mk-average/
 *
 * @author half-dead
 */
public class Puzzle1825 {

    public static void main(String[] args) {
        MKAverage mk = new Puzzle1825().new MKAverage(3, 1);

        mk.addElement(17612);
        mk.addElement(74607);
        mk.calculateMKAverage();
        mk.addElement(8272);
        mk.addElement(33433);
        mk.calculateMKAverage();
        mk.addElement(15456);
        mk.addElement(64938);
        mk.calculateMKAverage();
        mk.addElement(99741);
    }

    class MKAverage {
        int m, k, index, counter, window;
        int[] data, leftHolder = new int[2], midHolder = new int[2], rightHolder = new int[2];

        TreeMap<Integer, Integer> left = new TreeMap<>(), mid = new TreeMap<>(), right = new TreeMap<>();

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            data = new int[m];
            window = m - k - k;
        }

        public void addElement(int num) {
            int oldValue;
            if (++counter > m) {
                oldValue = data[index];

                if (oldValue <= left.lastKey())
                    delete(oldValue, left, leftHolder);
                else if (oldValue >= right.firstKey())
                    delete(oldValue, right, rightHolder);
                else
                    delete(oldValue, mid, midHolder);
            }

            data[index] = num;
            index = (index + 1) % m;

            put(num, left, leftHolder);
            if (leftHolder[0] > k) {
                int key = left.lastKey();
                delete(key, left, leftHolder);
                put(key, mid, midHolder);

                if (midHolder[0] > window) {
                    key = mid.lastKey();
                    delete(key, mid, midHolder);
                    put(key, right, rightHolder);
                }
            }

            if (counter >= m) {
                trySwap(left, mid, leftHolder, midHolder);
                trySwap(mid, right, midHolder, rightHolder);
            }
        }

        public int calculateMKAverage() {
            if (counter < m) return -1;
            return midHolder[1] / window;
        }

        void put(int key, TreeMap<Integer, Integer> tm, int[] holder) {
            tm.put(key, tm.getOrDefault(key, 0) + 1);
            holder[0]++;
            holder[1] += key;
        }

        void delete(int key, TreeMap<Integer, Integer> tm, int[] holder) {
            int v = tm.get(key);
            if (v == 1) tm.remove(key);
            else tm.put(key, v - 1);

            holder[0]--;
            holder[1] -= key;
        }

        void trySwap(TreeMap<Integer, Integer> tm1, TreeMap<Integer, Integer> tm2, int[] holder1, int[] holder2) {
            int x = tm1.lastKey(), y = tm2.firstKey();
            if (x > y) {
                delete(x, tm1, holder1);
                delete(y, tm2, holder2);
                put(y, tm1, holder1);
                put(x, tm2, holder2);
            }
        }
    }
}
