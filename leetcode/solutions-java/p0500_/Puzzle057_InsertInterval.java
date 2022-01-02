/*
https://leetcode.com/problems/insert-interval/description/

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

Example 2:
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

package p0500_;

import struct.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle057_InsertInterval {


    class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            int size = intervals.size();
            List<Interval> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Interval current = intervals.get(i);
                if (current.end >= newInterval.start && current.start <= newInterval.end) {
                    newInterval.start = Math.min(current.start, newInterval.start);
                    newInterval.end = Math.max(current.end, newInterval.end);
                } else if (newInterval.end < current.start) {
                    result.add(newInterval);
                    newInterval = current;
                } else {
                    result.add(current);
                }
            }
            result.add(newInterval);
            return result;

        }
    }
}
