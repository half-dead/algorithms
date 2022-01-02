package p0500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * @author half-dead
 */
public class Puzzle199_BinaryTreeRightSideView {

    public static void main(String[] args) {
        Solution s = new Puzzle199_BinaryTreeRightSideView().new Solution();
        System.out.println(s.rightSideView(new TreeNode("[1,2,#,3]")));
        System.out.println(s.rightSideView(new TreeNode("[1,2,3,#,5,#,4]")));
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            recur(root, list, 1);
            return list;
        }

        public void recur(TreeNode root, List<Integer> list, int level) {
            if (root == null) return;
            if (list.size() < level) {
                list.add(root.val);
            }
            recur(root.right, list, level + 1);
            recur(root.left, list, level + 1);
        }
    }
}
