package p1000_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * @author half-dead
 */
public class Puzzle652 {

    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            Map<String, Integer> seen = new HashMap<>();
            List<TreeNode> res = new ArrayList<>();
            dfs(root, res, seen);
            return res;
        }

        String dfs(TreeNode node, List<TreeNode> res, Map<String, Integer> seen) {
            if (node == null) return "#,";
            String code = dfs(node.left, res, seen) + dfs(node.right, res, seen) + node.val + ",";

            int cnt = seen.getOrDefault(code, 0);
            if (cnt == 1) res.add(node);
            seen.put(code, cnt + 1);
            return code;
        }
    }
}
