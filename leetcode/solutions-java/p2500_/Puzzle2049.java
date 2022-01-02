package p2500_;

/**
 * https://leetcode.com/problems/count-nodes-with-the-highest-score/
 *
 * @author half-dead
 */
public class Puzzle2049 {

    public static void main(String[] args) {
        Solution s = new Puzzle2049().new Solution();
        System.out.println(s.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
    }

    class Solution {
        long score = 0;
        int cnt = 0;

        public int countHighestScoreNodes(int[] parents) {
            int n = parents.length;
            int[][] tree = new int[n][2];
            for (int i = 1; i < n; i++) {
                int parent = parents[i];
                if (tree[parent][0] == 0) tree[parent][0] = i;
                else tree[parent][1] = i;
            }
            postOrder(tree, 0, n);
            return cnt;
        }

        int postOrder(int[][] tree, int node, int n) {
            int left = 0, right = 0;
            if (tree[node][0] != 0) left = postOrder(tree, tree[node][0], n);
            if (tree[node][1] != 0) right = postOrder(tree, tree[node][1], n);

            int top = n - 1 - left - right;
            long curScore = (long) Math.max(left, 1) * Math.max(right, 1) * Math.max(top, 1);
            if (curScore == score) {
                cnt++;
            } else if (curScore > score) {
                score = curScore;
                cnt = 1;
            }
            return left + right + 1;
        }
    }
}
