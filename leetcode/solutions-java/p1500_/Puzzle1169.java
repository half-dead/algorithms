package p1500_;

import java.util.*;

/**
 * @author half-dead
 */
public class Puzzle1169 {

    class Solution {
        public List<String> invalidTransactions(String[] transactions) {
            Map<String, TreeMap<Integer, String>> map = new HashMap<>();
            for (String t : transactions) {
                String[] arr = t.split(",");
                map.computeIfAbsent(arr[0], x -> new TreeMap<>()).put(Integer.parseInt(arr[1]), t);
            }

            List<String> res = new ArrayList<>();
            for (String t : transactions) {
                String[] arr = t.split(",");
                int amount = Integer.parseInt(arr[2]);
                if (amount >= 1000) {
                    res.add(t);
                    continue;
                }

                String name = arr[0], city = arr[3];
                int minute = Integer.parseInt(arr[1]);
                SortedMap<Integer, String> range = map.get(name).subMap(minute - 60, minute + 61);
                for (String v : range.values()) {
                    if (!v.split(",")[3].equals(city)) {
                        res.add(t);
                        break;
                    }
                }
            }

            return res;
        }
    }
}
