package p1500_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/tweet-counts-per-frequency/
 *
 * @author half-dead
 */
public class Puzzle1348 {

    class TweetCounts {
        Map<String, TreeMap<Integer, Integer>> mem;
        public TweetCounts() {
            mem = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            TreeMap<Integer, Integer> slot = mem.computeIfAbsent(tweetName, x -> new TreeMap<>());
            slot.put(time, slot.getOrDefault(time, 0) + 1);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            TreeMap<Integer, Integer> slot = mem.get(tweetName);
            if (slot == null) return null;

            int interval = 60;
            if (freq.equals("hour")) interval = 60 * 60;
            else if (freq.equals("day")) interval = 60 * 60 * 24;

            int[] arr = new int[(endTime - startTime) / interval + 1];
            for (Map.Entry<Integer, Integer> entry : slot.subMap(startTime, endTime + 1).entrySet()) {
                arr[(entry.getKey() - startTime) / interval] += entry.getValue();
            }
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
    }

}
