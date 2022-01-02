package p1000_;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/stickers-to-spell-word/
 *
 * @author half-dead
 */
public class Puzzle691 {

    public static void main(String[] args) {
        Solution s = new Puzzle691().new Solution();
        System.out.println(s.minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }

    // BFS + bitmasking
    class Solution {
        int n, mask;

        public int minStickers(String[] stickers, String word) {
            n = word.length();
            mask = 1 << (n - 1);
            int m = stickers.length, target = (1 << n) - 1, cnt = 0;

            // sort every sticker and word
            for (int i = 0; i < m; i++) stickers[i] = sort(stickers[i]);
            word = sort(word);

            // prepare BFS data structure
            boolean[] seen = new boolean[target];
            seen[0] = true;

            Deque<Integer> q = new LinkedList<>();
            q.addLast(0);

            // apply BFS
            while (q.size() > 0) {

                int size = q.size();
                while (size-- > 0) {

                    int state = q.pollFirst();
                    for (String sticker : stickers) {
                        int next = nextState(sticker, word, state);
                        if (next == target) return cnt + 1;

                        if (seen[next]) continue;

                        q.addLast(next);
                        seen[next] = true;
                    }
                }
                cnt++;
            }
            return -1;
        }

        private int nextState(String sticker, String word, int state) {
            int j = 0, res = state, tempMask = mask;
            for (int i = 0; i < n; i++) {
                if ((state & tempMask) == 0) {
                    // if state[i] is not set, try to find that char in sticker
                    // since both sticker and word is sorted by character, we only need traverse sticker one time
                    int index = sticker.indexOf(word.charAt(i), j);
                    if (index >= 0) {
                        // set bit
                        res |= tempMask;
                        if ((j = index + 1) >= sticker.length())
                            break;
                    }
                }
                tempMask >>= 1;
            }
            return res;
        }

        // sort by character, so that we can find common parts of two strings faster
        private String sort(String s) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}
