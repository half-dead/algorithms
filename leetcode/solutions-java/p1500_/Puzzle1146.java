package p1500_;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/snapshot-array/
 *
 * @author half-dead
 */
public class Puzzle1146 {
    class SnapshotArray {
        private TreeMap<Integer, Integer>[] snapshots;
        private int count;

        public SnapshotArray(int length) {
            count = 0;
            snapshots = new TreeMap[length];
            for (int i = 0; i < length; i++) snapshots[i] = new TreeMap<>();
        }

        public void set(int index, int val) {
            snapshots[index].put(count, val);
        }

        public int snap() {
            return count++;
        }

        public int get(int index, int snapId) {
            Map.Entry<Integer, Integer> entry = snapshots[index].floorEntry(snapId);
            return entry == null ? 0 : entry.getValue();
        }
    }

}
