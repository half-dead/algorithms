package p2500_;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/stock-price-fluctuation/
 *
 * @author half-dead
 */
public class Puzzle2034 {

class StockPrice {

    Map<Integer, Integer> line;
    TreeMap<Integer, Integer> tm;

    int latest = 0;

    public StockPrice() {
        line = new HashMap<>();
        tm = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        latest = Math.max(latest, timestamp);

        int op = line.getOrDefault(timestamp, 0);
        if (op == price) return;

        if (op != 0) {
            int cnt = tm.get(op) - 1;
            if (cnt == 0) tm.remove(op);
            else tm.replace(op, cnt);
        }
        line.put(timestamp, price);
        tm.put(price, tm.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return line.get(latest);
    }

    public int maximum() {
        return tm.lastKey();
    }

    public int minimum() {
        return tm.firstKey();
    }
}
}
