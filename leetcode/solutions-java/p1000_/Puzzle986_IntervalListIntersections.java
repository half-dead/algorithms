package p1000_;

import struct.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 *
 * @author half-dead
 */
public class Puzzle986_IntervalListIntersections {
    class Solution {
        public Interval[] intervalIntersection(Interval[] a, Interval[] b) {
            int lenA = a.length, lenB = b.length;
            int aIndex = 0, bIndex = 0;
            List<Interval> list = new ArrayList<>();
            while (aIndex < lenA && bIndex < lenB) {
                Interval ai = a[aIndex];
                Interval bi = b[bIndex];
                if (ai.end < bi.start) {
                    aIndex++;
                } else if (bi.end < ai.start) {
                    bIndex++;
                } else {
                    list.add(new Interval(Math.max(ai.start, bi.start), Math.min(ai.end, bi.end)));
                    if (ai.end > bi.end) {
                        bIndex++;
                    } else if (ai.end < bi.end) {
                        aIndex++;
                    } else {
                        aIndex++;
                        bIndex++;
                    }
                }
            }
            Interval[] result = new Interval[list.size()];
            list.toArray(result);
            return result;
        }
    }
}
