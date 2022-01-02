package p0500_;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author half-dead
 */
public class Puzzle146_LRUCache {

    public static void main(String[] args) {
        Puzzle146_LRUCache p = new Puzzle146_LRUCache();
        LRUCache cache = p.new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }

    class LRUCache {
        Map<Integer, Node> map;
        int capacity;
        Node head = new Node(0, 0), tail = new Node(0, 0);

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
            link(head, tail);
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            else return relink(node).v;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.v = value;
                relink(node);
            } else {
                node = new Node(key, value);
                link(tail.prev, node);
                link(node, tail);
                map.put(key, node);
            }
            if (map.size() > capacity) {
                map.remove(head.next.k);
                link(head, head.next.next);
            }
        }

        private void link(Node prev, Node next) {
            prev.next = next;
            next.prev = prev;
        }

        private Node relink(Node node) {
            if (tail.prev != node) {
                link(node.prev, node.next);
                link(tail.prev, node);
                link(node, tail);
            }
            return node;
        }

        class Node {
            int k, v;
            Node prev, next;

            Node(int key, int val) {
                k = key;
                v = val;
            }
        }
    }

    // TreeMap solution
    class LRUCache2 {
        Map<Integer, E> map;
        TreeMap<Integer, Integer> priorityMap;
        int capacity;
        int counter;

        public LRUCache2(int capacity) {
            map = new HashMap<>(capacity);
            priorityMap = new TreeMap<>();
            this.capacity = capacity;
            this.counter = 0;
        }

        public int get(int key) {
            E e = map.get(key);
            if (e == null) {
                return -1;
            } else {
                priorityMap.remove(e.cnt);
                e.cnt = ++counter;
                priorityMap.put(e.cnt, key);
                return e.val;
            }
        }

        public void put(int key, int value) {
            E old = map.get(key);
            if (old != null) {
                priorityMap.remove(old.cnt);
            } else {
                old = new E(value);
                map.put(key, old);
            }
            old.val = value;
            old.cnt = ++counter;
            priorityMap.put(counter, key);

            if (map.size() > capacity)
                map.remove(priorityMap.pollFirstEntry().getValue());
        }
    }

    class E {
        int val, cnt;

        public E(int val) {
            this.val = val;
        }
    }
}
