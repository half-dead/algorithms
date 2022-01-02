package p2000_;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/even-odd-tree/
 *
 * @author half-dead
 */
public class Puzzle1609 {

    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            int level = 0;

            Queue<TreeNode> q = new LinkedList<>(), next;
            q.offer(root);

            while (q.size() > 0) {
                next = new LinkedList<>();
                boolean first = false;
                int prev = 0;

                while (q.size() > 0) {
                    TreeNode node = q.poll();
                    if (node.val % 2 == level % 2) {
                        return false;
                    }

                    if (node.left != null) {
                        next.offer(node.left);
                    }
                    if (node.right != null) {
                        next.offer(node.right);
                    }

                    if (!first) {
                        first = true;
                    } else {
                        if (level % 2 == 0 && node.val <= prev) {
                            return false;
                        } else if (level % 2 != 0 && node.val >= prev) {
                            return false;
                        }
                    }
                    prev = node.val;
                }
                level++;
                q = next;
            }
            return true;
        }
    }
}
