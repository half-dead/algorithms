package p1000_;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 *
 * @author half-dead
 */
public class Puzzle981_TimeBasedKeyValueStore {
    class TimeMap {
        private Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> tm = map.get(key);
            Integer i = tm.floorKey(timestamp);
            return i == null ? "" : tm.get(i);
        }
    }

}
