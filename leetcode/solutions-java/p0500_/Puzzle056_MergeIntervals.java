package p0500_;

// Given a collection of intervals, merge all overlapping intervals.
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

import struct.Interval;

import java.util.*;

/**
 * @author half-dead
 */
public class Puzzle056_MergeIntervals {

    public static void main(String[] args) {
        Puzzle056_MergeIntervals p = new Puzzle056_MergeIntervals();
        Solution solution = p.new Solution();

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(2, 3));
        list.add(new Interval(5, 8));
        list.add(new Interval(6, 7));
        list.add(new Interval(9, 10));

        List<Interval> merge = solution.merge(list);
        System.out.println(merge);
    }

    class Solution {

        public List<Interval> merge(List<Interval> intervals) {
            int n = intervals.size();
            int[] starts = new int[n];
            int[] ends = new int[n];
            for (int i = 0; i < n; i++) {
                starts[i] = intervals.get(i).start;
                ends[i] = intervals.get(i).end;
            }
            Arrays.sort(starts);
            Arrays.sort(ends);
            List<Interval> res = new ArrayList<>();
            for (int i = 0, j = 0; i < n; i++) {
                if (i == n - 1 || starts[i + 1] > ends[i]) {
                    res.add(new Interval(starts[j], ends[i]));
                    j = i + 1;
                }
            }
            return res;
        }
    }

    class MySolution {
        public List<Interval> merge(List<Interval> intervals) {

            Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

            List<Interval> result = new ArrayList<>();
            if (intervals.size() == 0) {
                return result;
            }

            Iterator<Interval> iterator = intervals.iterator();
            Interval prev = iterator.next();
            while (iterator.hasNext()) {
                Interval curr = iterator.next();
                if (curr.start >= prev.start && curr.start <= prev.end) {
                    prev = new Interval(Math.min(prev.start, curr.start), Math.max(prev.end, curr.end));
                } else {
                    result.add(prev);
                    prev = curr;
                }
            }
            if (prev != null) {
                result.add(prev);
            }
            return result;
        }
    }

}
