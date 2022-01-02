package p1500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 *
 * @author half-dead
 */
public class Puzzle1361_ValidateBinaryTreeNodes {

    public static void main(String[] args) {
        Solution s = new Puzzle1361_ValidateBinaryTreeNodes().new Solution();
        // true
        System.out.println(s.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        // false
        System.out.println(s.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        // false
        System.out.println(s.validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1}));
        // false
        System.out.println(s.validateBinaryTreeNodes(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1}));
        // true
        System.out.println(s.validateBinaryTreeNodes(2, new int[]{-1, 0}, new int[]{-1, -1}));
        // false
        System.out.println(s.validateBinaryTreeNodes(4, new int[]{1, 2, 0, -1}, new int[]{-1, -1, -1, -1}));
    }

    class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
            int[] degrees = new int[n];
            for (int i = 0; i < n; i++) {
                if (left[i] != -1) if (++degrees[left[i]] > 1) return false;
                if (right[i] != -1) if (++degrees[right[i]] > 1) return false;
            }

            boolean hasRoot = false;
            int rootIdx = -1;
            for (int i = 0; i < n; i++) {
                if (degrees[i] == 0) {
                    if (hasRoot) return false;
                    else {
                        hasRoot = true;
                        rootIdx = i;
                    }
                }
            }
            return hasRoot && (left[rootIdx] != -1 || right[rootIdx] != -1 || n == 1);
        }
    }

    class DfsSolution {
        public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
            Set<Integer> roots = new HashSet<>();
            byte[] state = new byte[n];

            for (int i = 0; i < n; i++) {
                if (state[i] == 0)
                    if (dfs(i, left, right, state, roots)) roots.add(i);
                    else return false;
                else if (state[i] == 1) return false;
            }
            return roots.size() == 1;
        }

        public boolean dfs(int idx, int[] left, int[] right, byte[] state, Set<Integer> roots) {
            if (state[idx] == 1) return false;
            if (state[idx] == 2 && !roots.contains(idx)) return false;

            boolean b = true;
            if (state[idx] == 0) {
                state[idx] = 1;
                if (left[idx] != -1) b = dfs(left[idx], left, right, state, roots);
                if (right[idx] != -1) b = b && dfs(right[idx], left, right, state, roots);
            }
            if (b) {
                state[idx] = 2;
                roots.remove(idx);
            }
            return b;
        }
    }
}

