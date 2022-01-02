package p1000_;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author half-dead
 */
public class Puzzle855 {

    class ExamRoom {
        TreeSet<Range> ranges;
        Map<Integer, Range> heads, tails;
        int n;

        public ExamRoom(int n) {
            this.n = n;
            heads = new HashMap<>();
            tails = new HashMap<>();
            ranges = new TreeSet<>();

            Range root = new Range(0, n - 1);
            ranges.add(root);
            heads.put(0, root);
            tails.put(n - 1, root);
        }

        public int seat() {
            Range cand = ranges.pollFirst();
            heads.remove(cand.start);
            tails.remove(cand.end);

            int left = cand.seat - 1, right = cand.seat + 1;
            if (cand.start <= left) {
                Range r = new Range(cand.start, left);
                ranges.add(r);
                heads.put(r.start, r);
                tails.put(r.end, r);
            }
            if (right <= cand.end) {
                Range r = new Range(right, cand.end);
                ranges.add(r);
                heads.put(r.start, r);
                tails.put(r.end, r);
            }
            return cand.seat;
        }

        public void leave(int p) {
            int start = p, end = p;
            Range left = tails.get(p - 1), right = heads.get(p + 1);
            if (left != null) {
                ranges.remove(left);
                heads.remove(left.start);
                tails.remove(left.end);
                start = left.start;
            }
            if (right != null) {
                ranges.remove(right);
                heads.remove(right.start);
                tails.remove(right.end);
                end = right.end;
            }
            Range r = new Range(start, end);
            ranges.add(r);
            heads.put(r.start, r);
            tails.put(r.end, r);
        }

        class Range implements Comparable<Range> {
            final int start, end;
            final int distance, seat;

            Range(int start, int end) {
                this.start = start;
                this.end = end;
                if (start == 0) {
                    distance = end + 1;
                    seat = 0;
                } else if (end == n - 1) {
                    distance = end - (start - 1);
                    seat = end;
                } else {
                    seat = (start + end) / 2;
                    distance = Math.min(seat - start + 1, end + 1 - seat);
                }
            }

            public int compareTo(Range o) {
                int diff = o.distance - this.distance;
                return diff == 0 ? seat - o.seat : diff;
            }
        }
    }

}
