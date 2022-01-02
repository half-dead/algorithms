package p1000_;

/**
 * https://leetcode.com/problems/friend-circles/
 *
 * @author half-dead
 */
public class Puzzle547_FriendCircles {
    public static void main(String[] args) {
        Puzzle547_FriendCircles p = new Puzzle547_FriendCircles();
        Solution s = p.new Solution();
        int circleNum = s.findCircleNum(new int[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 1}
        });
        System.out.println(circleNum);
    }

    // This Solution can find out all the circles.
    class Solution {
        private boolean[] visited;

        public int findCircleNum(int[][] m) {
            int len = m.length;
            visited = new boolean[len];

            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    for (int j = 0; j < len; j++) {
                        if (i != j && m[i][j] == 1) {
                            m[j][i] = 0;
                            dfs(m, j, i);
                        }
                    }
                }
            }

            int[] result = new int[len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    result[i] += m[i][j];
                }
            }
            int count = 0, sum = 0;
            for (int i : result) {
                if (i > 1) {
                    count++;
                    sum += i;
                }
            }
            return count + len - sum;
        }

        private void dfs(int[][] m, int row, int mergeRow) {
            if (visited[row]) {
                return;
            }
            visited[row] = true;
            for (int i = 0; i < m.length; i++) {
                if (i != row && i != mergeRow && m[row][i] == 1) {
                    m[i][row] = 0;
                    dfs(m, i, mergeRow);
                    m[mergeRow][i] = 1;
                    m[row][i] = 0;
                }
            }
        }
    }

    class Solution1 {
        public int findCircleNum(int[][] m) {
            int count = 0;
            int[] visited = new int[m.length];
            for (int i = 0; i < m.length; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                dfs(m, i, visited);
                count++;
            }
            return count;
        }

        public void dfs(int[][] m, int i, int[] visited) {
            visited[i] = 1;
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 1 && visited[j] != 1) {
                    dfs(m, j, visited);
                }
            }
        }
    }
}
