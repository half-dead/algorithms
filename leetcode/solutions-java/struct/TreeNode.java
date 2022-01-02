package struct;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author halfdead
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(String fullString) {

        TreeNode root = null;

        String treeString = fullString.substring(1, fullString.length() - 1);
        List<String> nodeValueList = Arrays.asList(treeString.split(","));

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        Iterator<String> iterator = nodeValueList.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            if (queue.isEmpty()) {
                root = fromValue(s);
                queue.addLast(root);
            } else {
                TreeNode parent = queue.pop();
                parent.left = fromValue(s);
                if (iterator.hasNext()) {
                    parent.right = fromValue(iterator.next());
                }
                if (parent.left != null) queue.addLast(parent.left);
                if (parent.right != null) queue.addLast(parent.right);
            }
        }

        val = root.val;
        left = root.left;
        right = root.right;
    }

    public TreeNode fromValue(String value) {
        return "#".equals(value) ? null : new TreeNode(Integer.valueOf(value));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        inorderTraversal(builder);
        return builder.toString();
    }

    public void inorderTraversal(StringBuilder builder) {
        if (left != null) {
            left.inorderTraversal(builder);
        }
        builder.append(" ").append(val);
        if (right != null) {
            right.inorderTraversal(builder);
        }

    }
}
