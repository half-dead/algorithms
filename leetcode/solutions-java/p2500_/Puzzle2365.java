package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/task-scheduler-ii/
 *
 * @author half-dead
 */
public class Puzzle2365 {
    class Solution {
        public long taskSchedulerII(int[] tasks, int space) {
            long d = 0L;
            Map<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < tasks.length; i++) {
                int type = tasks[i];
                long min = map.getOrDefault(type, i + 1L);
                d = Math.max(d + 1, min);
                map.put(type, d + space + 1);
            }
            return d;
        }
    }
}
