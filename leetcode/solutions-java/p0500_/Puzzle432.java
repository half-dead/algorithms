package p0500_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/all-oone-data-structure/
 *
 * @author half-dead
 */
public class Puzzle432 {

    class AllOne {
        Map<String, Node> map;
        Node head, tail;

        public AllOne() {
            map = new HashMap<>();

            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {
            Node node = map.get(key);
            if (node == null) {
                if (map.isEmpty() || head.next.count != 1) head.generateNext();
                map.put(key, node = head.next);
            } else {
                map.replace(key, node = node.generateNext());
                node.prev.removeKey(key);
            }
            node.addKey(key);
        }

        public void dec(String key) {
            Node node = map.get(key);
            if (node.count == 1) {
                node.removeKey(key);
                map.remove(key);
                return;
            }

            Node prev = node.generatePrev();
            prev.addKey(key);
            map.replace(key, prev);
            node.removeKey(key);
        }

        public String getMaxKey() {
            return map.isEmpty() ? "" : tail.prev.keys.iterator().next();
        }

        public String getMinKey() {
            return map.isEmpty() ? "" : head.next.keys.iterator().next();
        }

    }

    class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node() {
        }

        Node(Node p, Node n) {
            keys = new HashSet<>();
            prev = p;
            next = n;
        }

        Node generatePrev() {
            if (count - 1 == prev.count) return prev;

            Node x = new Node(prev, this);
            prev.next = x;
            prev = x;
            x.count = count - 1;
            return x;
        }

        Node generateNext() {
            if (count + 1 == next.count) return next;

            Node x = new Node(this, next);
            next.prev = x;
            next = x;
            x.count = count + 1;
            return x;
        }

        void addKey(String key) {
            keys.add(key);
        }

        void removeKey(String key) {
            keys.remove(key);
            if (keys.isEmpty()) {
                prev.next = next;
                next.prev = prev;
            }
        }
    }

}
