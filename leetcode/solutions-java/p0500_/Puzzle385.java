package p0500_;

import struct.NestedInteger;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/mini-parser/
 *
 * @author half-dead
 */
public class Puzzle385 {
    /*     public NestedInteger();
     *     public NestedInteger(int value);
     *     public boolean isInteger();
     *     public Integer getInteger();
     *     public void setInteger(int value);
     *     public void add(NestedInteger ni);
     *     public List<NestedInteger> getList(); */
    class Solution {
        public NestedInteger deserialize(String s) {
            char[] cs = s.toCharArray();
            int x = 0;
            boolean number = false, neg = false;
            LinkedList<NestedInteger> q = new LinkedList<>();
            q.push(new NestedInteger());
            NestedInteger curr = null;
            for (int i = 0; i <= cs.length; i++) {
                char c = i == cs.length ? ']' : cs[i];
                if (c >= '0' && c <= '9') {
                    number = true;
                    x = x * 10 + (c - '0');
                } else if (c == '-') {
                    neg = true;
                } else if (c == '[') {
                    q.push(new NestedInteger());
                    curr = null;
                } else {
                    if (number) {
                        NestedInteger ni = new NestedInteger((neg ? -1 : 1) * x);
                        q.peek().add(ni);
                        x = 0;
                        neg = false;
                        number = false;
                    } else {
                        if (curr != null) q.peek().add(curr);
                    }
                    if (c == ']') curr = q.pop();
                }
            }
            return curr.getList().get(0);
        }
    }
}
