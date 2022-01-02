package p1000_;

/**
 * @author half-dead
 */
public class Puzzle641 {

    class MyCircularDeque {

        class DN {
            DN prev, next;
            int v;
        }

        int sz, cnt;

        DN head, tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            sz = k;
            head = new DN();
            tail = new DN();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (cnt == sz) return false;
            DN dn = new DN();
            dn.v = value;
            dn.prev = head;
            dn.next = head.next;
            head.next.prev = dn;
            head.next = dn;
            cnt++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (cnt == sz) return false;
            DN dn = new DN();
            dn.v = value;
            dn.prev = tail.prev;
            dn.next = tail;
            tail.prev.next = dn;
            tail.prev = dn;
            cnt++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (cnt == 0) return false;
            head.next.next.prev = head;
            head.next = head.next.next;
            cnt--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (cnt == 0) return false;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            cnt--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) return -1;
            return head.next.v;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) return -1;
            return tail.prev.v;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return cnt == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return cnt == sz;
        }
    }

}
