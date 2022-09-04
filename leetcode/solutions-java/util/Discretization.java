package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author half-dead
 */
class Discretization {
    Map<Long, Integer> map;

    public Discretization(final List<? extends Number> nums) {
        map = new HashMap<>();
        List<Number> buffer = new ArrayList<>(nums);
        buffer.sort((x, y) -> Long.compare(x.longValue(), y.longValue()));
        for (int i = 0, j = 0; i < buffer.size(); i++) {
            if (i > 0 && buffer.get(i).longValue() == buffer.get(i - 1).longValue()) continue;
            map.put(buffer.get(i).longValue(), j++);
        }
    }

    public int size() {
        return map.size();
    }

    public Integer getIndex(long num) {
        return map.get(num);
    }
}
