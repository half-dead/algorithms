package p1000_;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * @author half-dead
 */
public class Puzzle997_FindTheTownJudge {
    public static void main(String[] args) {
        Puzzle997_FindTheTownJudge p = new Puzzle997_FindTheTownJudge();
        Solution s = p.new Solution();
        System.out.println(s.findJudge(2, new int[][]{{1, 2}}));
    }

    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[][] map = new int[n + 1][2];
            for (int[] r : trust) {
                map[r[0]][0]++;
                map[r[1]][1]++;
            }
            for (int i = 1; i <= n; i++) if (map[i][1] == n - 1 && map[i][0] == 0) return i;
            return -1;
        }
    }
}
