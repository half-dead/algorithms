package p1500_;

import java.util.*;

/**
 * @author half-dead
 */
public class Puzzle1418 {

    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            TreeMap<Integer, Map<String, Integer>> tables = new TreeMap<>();
            TreeSet<String> foods = new TreeSet<>();
            for (List<String> order : orders) {
                Integer table = Integer.parseInt(order.get(1));
                String food = order.get(2);
                foods.add(food);
                Map<String, Integer> m = tables.computeIfAbsent(table, t -> new HashMap<>());
                m.put(food, m.getOrDefault(food, 0) + 1);
            }
            List<List<String>> res = new ArrayList<>(tables.size() + 1);

            List<String> header = new ArrayList<>(foods.size() + 1);
            header.add("Table");
            for (String food : foods) header.add(food);
            res.add(header);

            for (int table : tables.keySet()) {
                List<String> row = new ArrayList<>(foods.size() + 1);
                row.add(table + "");
                Map<String, Integer> fm = tables.get(table);
                for (String food : foods) row.add(fm.getOrDefault(food, 0) + "");
                res.add(row);
            }
            return res;
        }
    }
}
