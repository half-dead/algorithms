package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * @author half-dead
 */
public class Puzzle732_MyCalendarIII {

    public static void main(String[] args) {
        MyCalendarThree mc = new Puzzle732_MyCalendarIII().new MyCalendarThree();

        System.out.println(mc.book(22, 32)); // 1
        System.out.println(mc.book(1, 13));
        System.out.println(mc.book(55, 67));
        System.out.println(mc.book(24, 34)); // 2
        System.out.println(mc.book(12, 24));
        System.out.println(mc.book(13, 26)); // 3
        System.out.println(mc.book(12, 30)); // 4
        System.out.println(mc.book(76, 90));
        System.out.println(mc.book(48, 67));
        System.out.println(mc.book(67, 83));
        System.out.println(mc.book(30, 48));
        System.out.println(mc.book(40, 51));
        System.out.println(mc.book(59, 77));
        System.out.println(mc.book(17, 34)); // 5
        System.out.println(mc.book(71, 89));
        System.out.println(mc.book(71, 87));
        System.out.println(mc.book(49, 65));
        System.out.println(mc.book(73, 84)); // 6
        System.out.println(mc.book(50, 64));
        System.out.println(mc.book(19, 34));
        System.out.println(mc.book(60, 74));
    }

    // optimized segment tree, split a node based on given values instead of right-in-the-middle
    class MyCalendarThree {
        Node root = new Node(0, 1000000001, 0);
        int max = 0;

        public int book(int start, int end) {
            add(root, start, end);
            return max;
        }

        void add(Node root, int start, int end) {
            if (root.mid != -1) {
                if (start >= root.mid) add(root.right, start, end);
                else if (end <= root.mid) add(root.left, start, end);
                else {
                    add(root.left, start, root.mid);
                    add(root.right, root.mid, end);
                }
                return;
            }

            if (start == root.from && end == root.to) max = Math.max(max, ++root.count);
            else if (start == root.from) {
                root.left = new Node(start, end, root.count + 1);
                root.right = new Node(end, root.to, root.count);
                root.mid = end;
                max = Math.max(max, root.count + 1);
            } else if (end == root.to) {
                root.left = new Node(root.from, start, root.count);
                root.right = new Node(start, end, root.count + 1);
                root.mid = start;
                max = Math.max(max, root.count + 1);
            } else {
                root.left = new Node(root.from, start, root.count);
                root.right = new Node(start, root.to, root.count);
                root.mid = start;
                add(root.right, start, end);
            }
        }

        class Node {
            int from, to, count, mid = -1;
            Node left, right;

            public Node(int from, int to, int count) {
                this.from = from;
                this.to = to;
                this.count = count;
            }
        }
    }

    class MyLousy_MyCalendarThree {
        TreeMap<Integer, Segment> starts = new TreeMap<>();
        TreeSet<Integer> ends = new TreeSet<>();
        int max;

        public int book(int start, int end) {
            if (starts.size() == 0 || starts.firstKey() >= end || ends.last() <= start)
                return addSegment(start, end);

            java.util.SortedMap<Integer, Segment> head = starts.headMap(end);
            java.util.NavigableSet<Integer> exclude = ends.headSet(start, true);
            if (head.size() == exclude.size()) return addSegment(start, end);

            Map<Integer, Integer> keysToRemove = new HashMap<>();
            List<Segment> segmentsToAdd = new LinkedList<>();
            boolean hasTail = true;
            for (int startKey : head.keySet()) {
                Segment seg0 = head.get(startKey);
                int start0 = seg0.start, end0 = seg0.end, count0 = seg0.count;

                if (exclude.contains(end0)) continue;
                if (start0 == start && end0 == end) {
                    max = Math.max(max, ++seg0.count);
                    hasTail = false;
                    break;
                }

                keysToRemove.put(start0, end0);
                if (start0 != start)
                    segmentsToAdd.add(new Segment(Math.min(start0, start), Math.max(start0, start), start0 < start ? count0 : 1));

                segmentsToAdd.add(new Segment(Math.max(start0, start), Math.min(end0, end), count0 + 1));
                max = Math.max(max, count0 + 1);

                if (end0 >= end) {
                    if (end0 > end) segmentsToAdd.add(new Segment(Math.min(end0, end), Math.max(end0, end), count0));
                    hasTail = false;
                    break;
                } else {
                    start = end0;
                    hasTail = true;
                }
            }
            if (hasTail) addSegment(start, end);

            for (Map.Entry<Integer, Integer> entry : keysToRemove.entrySet()) {
                starts.remove(entry.getKey());
                ends.remove(entry.getValue());
            }
            for (Segment seg : segmentsToAdd) {
                starts.put(seg.start, seg);
                ends.add(seg.end);
            }
            return max;
        }

        private int addSegment(int start, int end) {
            Segment seg = new Segment(start, end, 1);
            starts.put(start, seg);
            ends.add(end);
            return (max = Math.max(max, 1));
        }

        class Segment {
            int start, end, count;

            public Segment(int start, int end, int count) {
                this.start = start;
                this.end = end;
                this.count = count;
            }
        }
    }


}
