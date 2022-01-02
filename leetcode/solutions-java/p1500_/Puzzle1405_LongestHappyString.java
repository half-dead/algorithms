package p1500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-happy-string/
 *
 * @author half-dead
 */
public class Puzzle1405_LongestHappyString {

    public static void main(String[] args) {
        Solution s = new Puzzle1405_LongestHappyString().new Solution();
        String s1 = s.longestDiverseString(7, 1, 1);
        System.out.println(s1);
    }

    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            if (a > 0) pq.add(new Pair('a', a));
            if (b > 0) pq.add(new Pair('b', b));
            if (c > 0) pq.add(new Pair('c', c));

            StringBuilder result = new StringBuilder();
            char prev = '\0';
            int cnt = 0;
            while (pq.size() > 0) {
                Pair first = pq.poll();

                if (first.c == prev) {
                    if (cnt == 2) {
                        if (pq.size() > 0) {
                            Pair second = pq.poll();
                            result.append(second.c);
                            if (--second.cnt > 0) pq.add(second);
                            prev = second.c;
                            cnt = 1;
                            pq.add(first);
                        } else {
                            break;
                        }
                    } else {
                        cnt++;
                        result.append(first.c);
                        if (--first.cnt > 0) pq.add(first);
                    }
                } else {
                    prev = first.c;
                    cnt = 1;
                    result.append(first.c);
                    if (--first.cnt > 0) pq.add(first);
                }
            }
            return result.toString();
        }
    }

    class Pair implements Comparable<Pair> {
        char c;
        int cnt;

        public Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            return o.cnt - this.cnt;
        }
    }
}
