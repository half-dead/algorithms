package p1000_;

import struct.ListNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 *
 * @author half-dead
 */
public class Puzzle725_SplitLinkedListInParts {

    public static void main(String[] args) {
        Puzzle725_SplitLinkedListInParts p = new Puzzle725_SplitLinkedListInParts();
        Solution s = p.new Solution();
        ListNode[] nodes = s.splitListToParts(new ListNode(new int[]{1, 2, 3, 4, 5, 6,7,8}), 5);
        System.out.println(Arrays.toString(nodes));
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] res = new ListNode[k];
            ListNode node = root;
            int size = 0;
            while (node != null) {
                node = node.next;
                size++;
            }
            int max = 1, min = 1;
            if (size > k) {
                min = size / k;
                max = min;
                if (size % k != 0) {
                    max = min + 1;
                }
            }

            int i = 0;
            while (i < k) {
                res[i] = root;
                int len = min * (k - i) == size ? min : max;
                while (len > 0 && root != null) {
                    len--;
                    size--;
                    if (len == 0) {
                        node = root.next;
                        root.next = null;
                        root = node;
                    } else {
                        root = root.next;
                    }
                }
                i++;
            }
            return res;
        }
    }
}
