package p1500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 *
 * @author half-dead
 */
public class Puzzle1305 {

    class LinkedListSolution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new LinkedList<>(), list2 = new LinkedList<>();
            inorder(root1, list1);
            inorder(root2, list2);

            int size = list1.size() + list2.size();
            List<Integer> result = new ArrayList<>(size);

            Iterator<Integer> it1 = list1.iterator(), it2 = list2.iterator();
            int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
            if (it1.hasNext()) n1 = it1.next();
            if (it2.hasNext()) n2 = it2.next();

            for (int i = 0; i < size; i++) {
                if (n1 <= n2) {
                    result.add(n1);
                    n1 = it1.hasNext() ? it1.next() : Integer.MAX_VALUE;
                } else {
                    result.add(n2);
                    n2 = it2.hasNext() ? it2.next() : Integer.MAX_VALUE;
                }
            }
            return result;
        }

        private void inorder(TreeNode node, List<Integer> list) {
            if (node == null) return;
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }

    class CountingSolution {
        final int HK = 100_000;
        int total;

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            int[] count = new int[200001];
            total = 0;
            dfs(root1, count);
            dfs(root2, count);
            List<Integer> result = new ArrayList<>(total);
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    int n = i - HK;
                    while (count[i]-- > 0) result.add(n);
                }
            }
            return result;
        }

        private void dfs(TreeNode node, int[] count) {
            if (node == null) return;
            total++;
            count[node.val + HK]++;
            dfs(node.left, count);
            dfs(node.right, count);
        }
    }
}
