package p0500_;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @author half-dead
 */
public class Puzzle023_MergeKSortedLists {
    public static void main(String[] args) {
        Puzzle023_MergeKSortedLists p = new Puzzle023_MergeKSortedLists();
        Solution s = p.new Solution();
        ListNode listNode = s.mergeKLists(new ListNode[]{
                new ListNode(new int[]{1, 4, 5}),
                new ListNode(new int[]{1, 3, 3, 4}),
                new ListNode(new int[]{2, 6}),
        });
        System.out.println(listNode);
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            TreeMap<Integer, List<ListNode>> map = new TreeMap<>();
            for (ListNode node : lists) {
                if (node != null) {
                    map.putIfAbsent(node.val, new ArrayList<>());
                    map.get(node.val).add(node);
                }
            }
            ListNode dummy = new ListNode(0), head = dummy;
            while (map.size() > 0) {
                int min = map.firstKey();
                List<ListNode> nodes = map.get(min);
                ListNode candidate = nodes.get(0);
                head.next = candidate;
                if (candidate.next != null) {
                    map.putIfAbsent(candidate.next.val, new ArrayList<>());
                    map.get(candidate.next.val).add(candidate.next);
                }
                nodes.remove(0);
                if (nodes.size() == 0) {
                    map.remove(min);
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
