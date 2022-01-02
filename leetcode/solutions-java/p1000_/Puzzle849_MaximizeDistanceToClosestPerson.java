package p1000_;

/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 *
 * @author half-dead
 */
public class Puzzle849_MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        Puzzle849_MaximizeDistanceToClosestPerson p = new Puzzle849_MaximizeDistanceToClosestPerson();
        Solution s = p.new Solution();
        System.out.println(s.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(s.maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(s.maxDistToClosest(new int[]{0, 0, 0, 1}));
    }

    class Solution {
        public int maxDistToClosest(int[] seats) {
            int prev = -1, max = 1;
            for (int i = 0; i < seats.length; i++)
                if (seats[i] == 1) {
                    if (prev == -1) max = i;
                    else max = Math.max(max, (i - prev) / 2);
                    prev = i;
                }
            return Math.max(max, seats.length - 1 - prev);
        }
    }
}
