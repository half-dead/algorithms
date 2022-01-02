package p0500_;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * @author half-dead
 */
public class Puzzle341_FlattenNestedListIterator {// This is the interface that allows for creating nested lists.

    // You should not implement it, or speculate about its implementation
    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private List<NestedInteger> list;
        private LinkedList<Iterator<NestedInteger>> q;
        private int curr;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = nestedList;
            this.q = new LinkedList<>();
            q.push(list.iterator());
        }

        public Integer next() {
            return curr;
        }

        public boolean hasNext() {
            Iterator<NestedInteger> it = q.peek();
            if (it == null) {
                return false;
            }
            if (it.hasNext()) {
                NestedInteger ni = it.next();
                if (ni.isInteger()) {
                    curr = ni.getInteger();
                    return true;
                } else {
                    q.push(ni.getList().iterator());
                    return hasNext();
                }
            } else {
                q.pop();
                return hasNext();
            }
        }
    }
}


