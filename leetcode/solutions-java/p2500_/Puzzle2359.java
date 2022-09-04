package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
 *
 * @author half-dead
 */
public class Puzzle2359 {

    public static void main(String[] args) {
        Solution s = new Puzzle2359().new Solution();
        System.out.println(s.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
    }

    class Solution {
        public int closestMeetingNode(int[] edges, int a, int b) {
            int n = edges.length;
            int[] cnt = new int[n], cnt2 = new int[n];
            Arrays.fill(cnt, -1);
            Arrays.fill(cnt2, -1);

            for (int x = a, i = 0; x >= 0; i++) {
                if (cnt[x] >= 0) break;
                cnt[x] = i;
                x = edges[x];
            }

            for (int x = b, i = 0; x >= 0; i++) {
                if (cnt2[x] >= 0) break;
                cnt2[x] = i;
                x = edges[x];
            }

            int res = -1, min = n + 1;
            for (int i = 0; i < n; i++) {
                if (cnt[i] >= 0 && cnt2[i] >= 0) {
                    int newmin = Math.max(cnt[i], cnt2[i]);
                    if (res == -1) {
                        res = i;
                        min = newmin;
                    } else if (newmin < min) {
                        min = newmin;
                        res = i;
                    }
                }
            }
            return res;
        }
    }
}
