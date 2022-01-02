package p2000_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sentence-similarity-iii/
 *
 * @author half-dead
 */
public class Puzzle1813 {

    class Solution1 {
        public boolean areSentencesSimilar(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }

            String longer = s1, shorter = s2;
            if (s2.length() > s1.length()) {
                longer = s2;
                shorter = s1;
            }

            String t1 = " " + shorter + " ", t2 = " " + longer + " ";
            if (t2.startsWith(t1) || t2.endsWith(t1)) {
                return true;
            }

            int pos = shorter.indexOf(' ');
            while (pos < shorter.length() && pos >= 0) {
                String a = " " + shorter.substring(0, pos + 1);
                String b = shorter.substring(pos) + " ";
                if (t2.startsWith(a) && t2.endsWith(b)) {
                    return true;
                }
                pos = shorter.indexOf(' ', pos + 1);
            }
            return false;
        }
    }

    class Solution {
        public boolean areSentencesSimilar(String s1, String s2) {
            Deque<String> q1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
            Deque<String> q2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
            while (!q1.isEmpty() && !q2.isEmpty() && q1.peekFirst().equals(q2.peekFirst())) {
                q1.pollFirst();
                q2.pollFirst();
            }
            while (!q1.isEmpty() && !q2.isEmpty() && q1.peekLast().equals(q2.peekLast())) {
                q1.pollLast();
                q2.pollLast();
            }
            return q1.isEmpty() || q2.isEmpty();
        }
    }
}
