package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author half-dead
 */
public class Puzzle2013 {

    class DetectSquares {

        Map<Integer, Map<Integer, Integer>> xmap;

        public DetectSquares() {
            xmap = new HashMap<>();
        }

        public void add(int[] point) {
            int x = point[0], y = point[1];

            Map<Integer, Integer> xslot = xmap.computeIfAbsent(x, v -> new HashMap<>());
            xslot.put(y, xslot.getOrDefault(y, 0) + 1);
        }

        public int count(int[] point) {
            int x = point[0], y = point[1], cnt = 0;

            Map<Integer, Integer> xslot = xmap.getOrDefault(x, new HashMap<>());

            if (xslot.size() == 0) return cnt;

            for (int qy : xslot.keySet()) {
                int edge = Math.abs(y - qy);
                if (edge == 0) continue;

                int left = x - edge, right = x + edge;
                Map<Integer, Integer> leftslot = xmap.getOrDefault(left, new HashMap<>());
                cnt += xslot.get(qy) * leftslot.getOrDefault(y, 0) * leftslot.getOrDefault(qy, 0);

                Map<Integer, Integer> rightslot = xmap.getOrDefault(right, new HashMap<>());
                cnt += xslot.get(qy) * rightslot.getOrDefault(y, 0) * rightslot.getOrDefault(qy, 0);
            }
            return cnt;
        }
    }

}
