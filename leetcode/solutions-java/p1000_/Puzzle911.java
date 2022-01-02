package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/online-election/
 *
 * @author half-dead
 */
public class Puzzle911 {

    class TopVotedCandidate {
        int[] res, times;

        public TopVotedCandidate(int[] persons, int[] times) {
            int n = persons.length;
            this.res = new int[n];
            this.times = times;

            int[] cnt = new int[n];
            for (int i = 0, max = 0; i < n; i++) {
                if (++cnt[persons[i]] >= max) {
                    max = cnt[res[i] = persons[i]];
                } else {
                    res[i] = res[i - 1];
                }
            }
        }

        public int q(int t) {
            int pos = Arrays.binarySearch(times, t);
            return pos >= 0 ? res[pos] : res[-pos - 2];
        }
    }

}
