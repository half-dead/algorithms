package p0500_;

import struct.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author half-dead
 */
public class Puzzle449 {
    public static void main(String[] args) {
        Codec c = new Puzzle449().new Codec();
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(2);
        String data = c.serialize(r);
        System.out.println(data);
        System.out.println(c.deserialize(data));
    }

    public class Codec {
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.val).append(',');
            serialize(node.left, sb);
            serialize(node.right, sb);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(Queue<String> q, int min, int max) {
            if (q.isEmpty()) return null;

            String s = q.peek();
            int val = Integer.parseInt(s);
            if (val < min || val > max) return null;

            q.poll();
            TreeNode node = new TreeNode(val);
            node.left = deserialize(q, min, val);
            node.right = deserialize(q, val, max);
            return node;
        }
    }

    // works for any binary tree, not just BST
    public class QCodec {
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (q.size() > 0) {
                int sz = q.size();
                while (sz-- > 0) {
                    TreeNode node = q.poll();
                    if (node == null) {
                        sb.append("#,");
                        continue;
                    }
                    sb.append(node.val + ",");
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            boolean neg = false, left = true;
            TreeNode dummy = new TreeNode(0), tmp = null, parent = null;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(dummy);
            for (char c : data.toCharArray()) {
                if (c == '#') continue;
                if (c == '-') neg = true;
                else if (c == ',') {
                    if (neg) tmp.val = -tmp.val;

                    if (left) parent = q.poll();
                    if (parent == dummy) parent.left = tmp;
                    else {
                        if (left) parent.left = tmp;
                        else parent.right = tmp;
                        left = !left;
                    }
                    if (tmp != null) q.offer(tmp);
                    neg = false;
                    tmp = null;
                } else {
                    if (tmp == null) tmp = new TreeNode(0);
                    tmp.val = tmp.val * 10 + (c - '0');
                }
            }
            return dummy.left;
        }
    }
}
