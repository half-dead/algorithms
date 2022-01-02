package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-underground-system/
 *
 * @author half-dead
 */
public class Puzzle1396 {

    class UndergroundSystem {

        Map<Integer, P> pending = new HashMap<>();
        Map<String, int[]> finished = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            pending.put(id, new P(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            P p = pending.remove(id);
            int cost = t - p.time;
            String key = p.station + "," + stationName;
            int[] a = finished.computeIfAbsent(key, k -> new int[]{0, 0});
            a[0] += cost;
            a[1]++;
        }

        public double getAverageTime(String startStation, String endStation) {
            int[] a = finished.get(startStation + "," + endStation);
            return (double) a[0] / a[1];
        }

        class P {
            String station;
            int time;

            P(String s, int t) {
                station = s;
                time = t;
            }
        }
    }

}
