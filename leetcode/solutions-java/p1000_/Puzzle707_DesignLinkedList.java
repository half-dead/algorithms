package p1000_;

/**
 * https://leetcode.com/problems/design-linked-list/
 *
 * @author half-dead
 */
public class Puzzle707_DesignLinkedList {
    public static void main(String[] args) {
        Puzzle707_DesignLinkedList p = new Puzzle707_DesignLinkedList();
        MyLinkedList list = p.new MyLinkedList();
        list.addAtHead(0);
        list.addAtIndex(1, 9);
        list.addAtIndex(1, 5);
        list.addAtTail(7);
        list.addAtHead(1);
        list.addAtIndex(5, 8);
        list.addAtIndex(5, 2);
        list.addAtIndex(3, 0);
        list.addAtTail(1);
        list.addAtTail(0);
        list.deleteAtIndex(6);
    }

    class MyLinkedList {
        private int size = 0;
        private Node head, tail;

        public MyLinkedList() {
        }

        public int get(int index) {
            Node node = nodeAt(index);
            return node == null ? -1 : node.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (size == 0) tail = node;
            else link(node, head);
            head = node;
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (size == 0) head = node;
            else link(tail, node);
            tail = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;

            if (index == 0) addAtHead(val);
            else if (index == size) addAtTail(val);
            else {
                Node next = nodeAt(index), prev = next.prev;
                Node node = new Node(val);
                link(prev, node);
                link(node, next);
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            Node node = nodeAt(index);
            if (node != null) {
                if (index == 0) {
                    head.next.prev = null;
                    head = head.next;
                } else if (index == size - 1) {
                    tail.prev.next = null;
                    tail = tail.prev;
                } else link(node.prev, node.next);
                size--;
            }
        }

        private void link(Node prev, Node next) {
            prev.next = next;
            next.prev = prev;
        }

        private Node nodeAt(int index) {
            if (size == 0 || index < 0 || index >= size) return null;

            Node node = null;
            if (index < size >> 1) {
                node = head;
                for (int i = 0; i < index; i++) node = node.next;
            } else {
                node = tail;
                for (int i = size - 1; i > index; i--) node = node.prev;
            }
            return node;
        }

    }

    class Node {
        int val;
        Node prev, next;

        public Node(int val) {
            this.val = val;
        }
    }

}
