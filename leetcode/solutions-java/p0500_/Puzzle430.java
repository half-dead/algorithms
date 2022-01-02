package p0500_;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author half-dead
 */
public class Puzzle430 {

    class IterativeSolution {
        public Node flatten(Node head) {
            if (head == null) return null;
            // Pointer
            Node p = head;
            while (p != null) {
                /* CASE 1: if no child, proceed */
                if (p.child == null) {
                    p = p.next;
                    continue;
                }
                /* CASE 2: got child, find the tail of the child and link it to p.next */
                Node temp = p.child;
                // Find the tail of the child
                while (temp.next != null)
                    temp = temp.next;
                // Connect tail with p.next, if it is not null
                temp.next = p.next;
                if (p.next != null) p.next.prev = temp;
                // Connect p with p.child, and remove p.child
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
            return head;
        }
    }

    class Solution {
        public Node flatten(Node head) {
            dfs(head);
            return head;
        }

        Node dfs(Node head) {
            while (head != null) {
                Node child = head.child, next = head.next;
                if (child != null) {
                    head.next = child;
                    child.prev = head;
                    head.child = null;
                    Node end = dfs(child);
                    if (next != null) {
                        end.next = next;
                        next.prev = end;
                    } else {
                        return end;
                    }
                }
                if (next != null) {
                    head = next;
                } else break;
            }
            return head;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
