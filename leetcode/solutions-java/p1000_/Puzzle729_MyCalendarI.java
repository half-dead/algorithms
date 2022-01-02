package p1000_;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-i/
 *
 * @author half-dead
 */
public class Puzzle729_MyCalendarI {

    public static void main(String[] args) {
        Puzzle729_MyCalendarI p = new Puzzle729_MyCalendarI();
        MyCalendar c = p.new MyCalendar();
        System.out.println(c.book(10, 20));
        System.out.println(c.book(15, 25));
        System.out.println(c.book(20, 30));

    }

    class MyCalendar {
        private TreeMap<Integer, Integer> startMap;

        public MyCalendar() {
            startMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer left = startMap.floorKey(end - 1);
            if (left != null && startMap.get(left) > start) {
                return false;
            }
            startMap.put(start, end);
            return true;
        }
    }
}
