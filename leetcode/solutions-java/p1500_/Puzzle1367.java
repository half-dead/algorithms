package p1500_;

import struct.ListNode;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1367 {

    class Solution1 {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (head == null) return true;
            if (root == null) return false;
            return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        boolean dfs(TreeNode root, ListNode node) {
            if (node == null) return true;
            if (root == null) return false;
            return root.val == node.val && (dfs(root.left, node.next) || dfs(root.right, node.next));
        }
    }

    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            List<Integer> q = new ArrayList<>(), dp = new ArrayList<>();
            q.add(head.val);
            dp.add(0);
            int i = 0;
            head = head.next;
            while (head != null) {
                while (i > 0 && head.val != q.get(i))
                    i = dp.get(i - 1);
                if (head.val == q.get(i)) ++i;
                q.add(head.val);
                dp.add(i);
                head = head.next;
            }
            return dfs(root, 0, q, dp);
        }

        private boolean dfs(TreeNode root, int i, List<Integer> A, List<Integer> dp) {
            if (root == null) return false;
            while (i > 0 && root.val != A.get(i))
                i = dp.get(i - 1);
            if (root.val == A.get(i)) ++i;
            return i == dp.size() || dfs(root.left, i, A, dp) || dfs(root.right, i, A, dp);
        }
    }
}
