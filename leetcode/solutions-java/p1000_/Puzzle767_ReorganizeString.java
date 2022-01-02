package p1000_;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/
 *
 * @author half-dead
 */
public class Puzzle767_ReorganizeString {
    public static void main(String[] args) {
        Solution s = new Puzzle767_ReorganizeString().new Solution();
        System.out.println(s.reorganizeString("aab"));
    }

    class Solution {
        public String reorganizeString(String s) {
            int N26 = 26, len = s.length(), maxCnt = 0, maxLetter = 0, idx = 0;
            int[] count = new int[N26];
            for (char c : s.toCharArray()) count[c - 'a']++;

            for (int i = 0; i < N26; i++)
                if (count[i] > maxCnt) {
                    maxCnt = count[i];
                    maxLetter = i;
                }
            if (maxCnt > (len + 1) / 2) return "";

            char[] chars = new char[len];
            while (count[maxLetter]-- > 0) {
                chars[idx] = (char) ('a' + maxLetter);
                idx += 2;
            }
            for (int i = 0; i < N26; i++) {
                while (count[i]-- > 0) {
                    chars[idx = idx >= len ? 1 : idx] = (char) ('a' + i);
                    idx += 2;
                }
            }
            return new String(chars);
        }
    }

    class GreedySolution {
        public String reorganizeString(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;

            int max = 0;
            for (int c : count) max = Math.max(max, c);
            if (max > (s.length() + 1) / 2) return "";

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < 26; i++) if (count[i] > 0) pq.add((count[i] << 8) | i);

            StringBuilder sb = new StringBuilder(s.length());
            int N256 = 1 << 8, N31 = 31;
            while (pq.size() > 0) {
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char) ('a' + (pq.peek() & N31))) {
                    int top = pq.poll();
                    sb.append((char) ('a' + ((top -= N256) & N31)));
                    if (top >= N256) pq.add(top);
                } else {
                    int top1 = pq.poll(), top2 = pq.poll();
                    sb.append((char) ('a' + ((top2 -= N256) & N31)));
                    pq.add(top1);
                    if (top2 >= N256) pq.add(top2);
                }
            }
            return sb.toString();
        }
    }
}
