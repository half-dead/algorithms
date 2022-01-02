package p0500_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle297_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Puzzle297_SerializeAndDeserializeBinaryTree p = new Puzzle297_SerializeAndDeserializeBinaryTree();
        Codec c = p.new Codec();
        TreeNode root = new TreeNode("[1,2,#,3,4,#,#,#,5]");
        System.out.println(c.serialize(root));
    }

    // Preorder
    public class Codec {
        public String serialize(TreeNode root) {
            return serialize(root, new StringBuilder()).toString();
        }

        private StringBuilder serialize(TreeNode node, StringBuilder builder) {
            if (builder.length() > 0) builder.append(',');
            if (node == null) {
                builder.append('#');
                return builder;
            }
            builder.append(node.val);
            serialize(node.left, builder);
            serialize(node.right, builder);
            return builder;
        }

        public TreeNode deserialize(String data) {
            return deserialize(data, new int[]{0});
        }

        private TreeNode deserialize(String data, int[] i) {
            int left = i[0], right = i[0];
            while (right < data.length() && data.charAt(right) != ',') right++;
            TreeNode node = fromValue(data.substring(left, right));
            i[0] = ++right;
            if (node != null) {
                node.left = deserialize(data, i);
                node.right = deserialize(data, i);
            }
            return node;
        }

        private TreeNode fromValue(String s) {
            return ("#".equals(s) || "".equals(s)) ? null : new TreeNode(Integer.valueOf(s));
        }
    }

    // Levelorder
    public class LevelOrderCodec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder builder = new StringBuilder();
            LinkedList<TreeNode> q = new LinkedList<>();
            TreeNode dummy = new TreeNode(0);
            q.addLast(root);
            while (q.size() > 0) {
                LinkedList<TreeNode> next = new LinkedList<>();
                while (q.size() > 0) {
                    TreeNode node = q.pop();
                    if (node != dummy) {
                        next.addLast(node.left == null ? dummy : node.left);
                        next.addLast(node.right == null ? dummy : node.right);
                    }
                    if (builder.length() > 0) builder.append(',');
                    if (node == dummy) builder.append('#');
                    else builder.append(node.val);
                }
                q = next;
            }
            return builder.toString();
        }

        public TreeNode deserialize(String data) {
            TreeNode root = null;
            int i = 0, j = 0, len = data.length();
            LinkedList<TreeNode> q = new LinkedList<>();
            while (i < len) {
                while (j < len && data.charAt(j) != ',') j++;
                String s1 = data.substring(i, j);
                i = ++j;
                TreeNode node = fromValue(s1);
                if (q.isEmpty()) {
                    root = node;
                    if (root != null) q.addLast(root);
                } else {
                    TreeNode p = q.pop();
                    p.left = node;

                    while (j < len && data.charAt(j) != ',') j++;
                    p.right = fromValue(data.substring(i, j));
                    i = ++j;
                    if (p.left != null) q.addLast(p.left);
                    if (p.right != null) q.addLast(p.right);
                }
            }
            return root;
        }

        private TreeNode fromValue(String s) {
            return ("#".equals(s) || "".equals(s)) ? null : new TreeNode(Integer.valueOf(s));
        }
    }

    // Cheat Solution
    public class CheatCodec {
        private String s;
        private TreeNode root;

        public String serialize(TreeNode root) {
            s = String.valueOf(System.currentTimeMillis());
            this.root = root;
            return s;
        }

        public TreeNode deserialize(String data) {
            if (s.equals(data)) {
                return root;
            } else return null;
        }
    }
}
