package p1000_;

import struct.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return recur(pre, 0, pre.length - 1, post, 0, post.length - 1);
        }

        public TreeNode recur(int[] pre, int i, int j, int[] post, int m, int n) {
            if (i == j) {
                return new TreeNode(pre[i]);
            } else if (i > j) {
                return null;
            } else if (pre[i] == post[n]) {
                TreeNode root = new TreeNode(pre[i]);
                i++;
                n--;
                int half = 0;
                Set<Integer> set = new HashSet<>();
                while (half <= j - i + 1) {
                    int v1 = pre[i + half];
                    int v2 = post[m + half];
                    if (set.contains(v1)) {
                        set.remove(v1);
                    } else {
                        set.add(v1);
                    }
                    if (set.contains(v2)) {
                        set.remove(v2);
                    } else {
                        set.add(v2);
                    }
                    half++;
                    if (set.size() == 0) {
                        break;
                    }
                }
                root.left = recur(pre, i, i + half - 1, post, m, m + half - 1);
                root.right = recur(pre, i + half, j, post, m + half, n);
                return root;
            } else {
                return null;
            }
        }
    }

    class Solution1 {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return constructFromPrePost(pre, post, 0, 0, pre.length);
        }

        private TreeNode constructFromPrePost(int[] pre, int[] post, int preIdx, int postIdx, int len) {
            if (len <= 0) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preIdx]);
            if (len == 1) {
                return root;
            }
            preIdx++;
            int k = postIdx;
            while (pre[preIdx] != post[k]) {
                k++;
            }
            int leftNodeCount = k - postIdx + 1;
            root.left = constructFromPrePost(pre, post, preIdx, postIdx, leftNodeCount);
            root.right = constructFromPrePost(pre, post, (preIdx + leftNodeCount), (postIdx + leftNodeCount), len - leftNodeCount - 1);
            return root;
        }
    }
}
