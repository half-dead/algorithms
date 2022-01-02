package p1000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/dota2-senate/
 *
 * @author half-dead
 */
public class Puzzle649_Dota2Senate {

    public static void main(String[] args) {
        Solution s = new Puzzle649_Dota2Senate().new Solution();
        System.out.println(s.predictPartyVictory("RDD"));
    }

    // 6ms
    class Solution {
        public String predictPartyVictory(String senate) {
            LinkedList<Integer> rq = new LinkedList<>(), dq = new LinkedList<>();
            int len = senate.length();
            for (int i = 0; i < len; i++) {
                if (senate.charAt(i) == 'R') rq.addLast(i);
                else dq.addLast(i);
            }
            while (rq.size() > 0 && dq.size() > 0) {
                int rIdx = rq.pollFirst(), dIdx = dq.pollFirst();
                if (rIdx < dIdx) rq.addLast(rIdx + len);
                else dq.addLast(dIdx + len);
            }
            return rq.size() > 0 ? "Radiant" : "Dire";
        }
    }

    // 4ms
    class Solution2 {
        public String predictPartyVictory(String senate) {
            while (senate.length() > 0) {
                int radiantCount = 0, direCount = 0;
                StringBuilder nextRound = new StringBuilder();
                for (char c : senate.toCharArray()) {
                    if (c == 'R') {
                        if (direCount > 0) {
                            direCount--;
                            nextRound.append('D');
                        } else radiantCount++;
                    } else {
                        if (radiantCount > 0) {
                            radiantCount--;
                            nextRound.append('R');
                        } else direCount++;
                    }
                }

                int idx;
                while (radiantCount > 0 && (idx = nextRound.indexOf("D")) >= 0) {
                    nextRound.deleteCharAt(idx);
                    radiantCount--;
                    nextRound.append('R');
                }
                while (direCount > 0 && (idx = nextRound.indexOf("R")) >= 0) {
                    nextRound.deleteCharAt(idx);
                    direCount--;
                    nextRound.append('D');
                }

                if (radiantCount > 0) return "Radiant";
                if (direCount > 0) return "Dire";

                senate = nextRound.toString();
            }
            return "";
        }
    }
}
