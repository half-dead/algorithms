package p1000_;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle655_PrintBinaryTree {
    public static void main(String[] args) {
        Puzzle655_PrintBinaryTree p = new Puzzle655_PrintBinaryTree();
        Solution s = p.new Solution();
        TreeNode root = new TreeNode("[1,2,3,4,5,6,7,8]");
        List<List<String>> lists = s.printTree(root);
        p.print(lists);
        System.out.println();
    }

    void print(List<List<String>> lists) {
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    // STUPID DUMBASS PUZZLE!!!
    class Solution {
        int height;
        String empty = "-";

        public List<List<String>> printTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            calHeight(root, 1);

            int width = (1 << height) - 1, h = 1;
            TreeNode dummy = new TreeNode(0);

            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.addLast(root);

            List<List<String>> result = new ArrayList<>(height);
            while (h <= height) {
                ArrayDeque<TreeNode> next = new ArrayDeque<>();
                ArrayList<String> level = new ArrayList<>(width);
                int padding = (1 << (height - h)) - 1;
                int h1 = (1 << (h - 1)) - 1;
                while (q.size() > 0) {
                    TreeNode node = q.pollFirst();

                    fill(level, padding);
                    level.add(node != dummy ? Integer.toString(node.val) : empty);
                    fill(level, padding);

                    next.addLast(node.left != null ? node.left : dummy);
                    next.addLast(node.right != null ? node.right : dummy);
                    if (h1 > 0) {
                        fill(level, 1);
                        h1--;
                    }
                }
                h++;
                q = next;
                result.add(level);
            }
            return result;
        }

        private void calHeight(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (height < level) {
                height = level;
            }
            calHeight(root.left, level + 1);
            calHeight(root.right, level + 1);
        }

        private void fill(List<String> list, int n) {
            for (int i = 0; i < n; i++) {
                list.add(empty);
            }
        }
    }
}
