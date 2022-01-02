package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/jump-game-vii/
 *
 * @author half-dead
 */
public class Puzzle1871 {

    public static void main(String[] args) {
        Solution s = new Puzzle1871().new Solution();
        System.out.println(s.canReach("011010", 2, 3));
        System.out.println(s.canReach("00111010", 3, 5));
    }

    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length(), maxReached = 0;
            if (s.charAt(len - 1) == '1') return false;

            LinkedList<Integer> q = new LinkedList<>();
            q.addLast(0);
            while (q.size() > 0) {
                int i = q.pollFirst();
                if (i == len - 1) return true;

                for (int next = Math.max(maxReached + 1, i + minJump); next <= Math.min(i + maxJump, len - 1); next++) {
                    if (s.charAt(next) == '0') {
                        q.addLast(next);
                    }
                }
                maxReached = Math.max(maxReached, i + maxJump);
            }
            return false;
        }
    }
}

