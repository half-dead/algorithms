package p0500_;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/
 *
 * @author half-dead
 */
public class Puzzle284 {


    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> it;
        Integer i;

        public PeekingIterator(Iterator<Integer> iterator) {
            it = iterator;
            i = it.hasNext() ? it.next() : null;
        }

        public Integer peek() {
            return i;
        }

        @Override
        public Integer next() {
            Integer res = i;
            i = it.hasNext() ? it.next() : null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return i != null;
        }
    }
}
