package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/frog-jump/
 *
 * @author half-dead
 */
public class Puzzle403_FrogJump {
    public static void main(String[] args) {
        Puzzle403_FrogJump p = new Puzzle403_FrogJump();
        Solution s = p.new Solution();
//        System.out.println(s.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
//        System.out.println(s.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
        int len = 1000;
        int[] stones = new int[len + 1];
        for (int i = 0; i < len; i++) stones[i] = i;
        stones[1000] = 1043;
        System.out.println(s.canCross(stones));
    }

    // 几种方案: 递归，动态规划，HashSet

    class Solution0 {
        public boolean canCross(int[] stones) {
            int target = stones[stones.length - 1];
            Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
            for (int stone : stones) map.put(stone, new HashSet<>());
            map.get(0).add(0);

            Set<Integer> q = new HashSet<>();
            q.add(0);
            while (q.size() > 0) {
                Set<Integer> next = new HashSet<>();
                for (int stone : q) {
                    Set<Integer> prevJumps = map.get(stone);
                    for (int prevJump : prevJumps) {
                        for (int diff = -1; diff <= 1; diff++) {
                            int currJump = prevJump + diff, nextStone = stone + currJump;
                            if (nextStone == target) return true;
                            if (currJump > 0 && map.containsKey(nextStone)) {
                                map.get(nextStone).add(currJump);
                                next.add(nextStone);
                            }
                        }
                    }
                }
                q = next;
            }
            return false;
        }
    }

    // 时间复杂度很高，遇到特殊case就挂了，如[0,1,2,3.......999,1050]
    class Solution {
        public boolean canCross(int[] stones) {
            for (int i = 1; i < stones.length; i++) if (stones[i] - stones[i - 1] > i) return false;
            return hop(stones, 0, 1);
        }

        private boolean hop(int[] stones, int idx, int step) {
            if (idx == stones.length - 1) return true;
            if (idx < 0 || step <= 0) return false;
            return hop(stones, Arrays.binarySearch(stones, stones[idx] + step + 1), step + 1) ||
                    hop(stones, Arrays.binarySearch(stones, stones[idx] + step), step) ||
                    hop(stones, Arrays.binarySearch(stones, stones[idx] + step - 1), step - 1);
        }
    }
}
