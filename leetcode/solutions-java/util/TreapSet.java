package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author half-dead
 */
class TreapSet<E> {
    private class Node {
        E key;
        int priority, count, total;
        Node left, right, pnt;

        public Node(E key, int priority, Node pnt) {
            this.key = key;
            this.priority = priority;
            this.pnt = pnt;
            this.count = 1;
            this.total = 1;
        }
    }

    private static final Random RANDOM = new Random();
    private final Comparator<? super E> comparator;
    private Node root;

    public TreapSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return root == null ? 0 : root.total;
    }

    private int leftRank(Node p) {
        return p.left != null ? p.left.total : 0;
    }

    private int rightRank(Node p) {
        return p.right != null ? p.right.total : 0;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        if ((x.right = y.left) != null) y.left.pnt = x;
        y.pnt = x.pnt;
        if (x == root) root = y;
        else if (x == x.pnt.left) x.pnt.left = y;
        else x.pnt.right = y;
        y.left = x;
        x.pnt = y;
        x.total = leftRank(x) + rightRank(x) + x.count;
        y.total = leftRank(y) + rightRank(y) + y.count;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        if ((x.left = y.right) != null) y.right.pnt = x;
        y.pnt = x.pnt;
        if (x == root) root = y;
        else if (x == x.pnt.right) x.pnt.right = y;
        else x.pnt.left = y;
        y.right = x;
        x.pnt = y;
        x.total = leftRank(x) + rightRank(x) + x.count;
        y.total = leftRank(y) + rightRank(y) + y.count;
    }

    public void add(E key) {
        if (root == null) {
            root = new Node(key, RANDOM.nextInt(), null);
            return;
        }
        Node x = root, p = null;
        while (x != null) {
            ++((p = x).total);
            int cmp = comparator.compare(key, x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                ++(x.count);
                return;
            }
        }

        x = new Node(key, RANDOM.nextInt(), p);
        if (comparator.compare(key, p.key) < 0) p.left = x;
        else p.right = x;
        while ((p = x.pnt) != null && p.priority < x.priority) {
            if (p.left == x) rotateRight(p);
            else rotateLeft(p);
        }
    }

    public void remove(E key) {
        Node x = root, p = null;
        while (x != null) {
            --(x.total);
            int cmp = comparator.compare(key, x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                if (--(x.count) > 0) return;
                break;
            }
        }
        if (x == null) return;
        while (x.left != null || x.right != null) {
            if (x.left == null || (x.right != null && x.right.priority > x.left.priority)) {
                rotateLeft(x);
            } else {
                rotateRight(x);
            }
        }
        if ((p = x.pnt) != null) {
            if (p.left == x) p.left = null;
            else p.right = null;
        } else {
            root = null;
        }
        // delete x;
    }

    // number of elements smaller than key
    public int lowerCount(E key) {
        int sum = 0;
        Node x = root;
        while (x != null) {
            int cmp = comparator.compare(key, x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) {
                sum += leftRank(x) + x.count;
                x = x.right;
            } else {
                sum += leftRank(x);
                break;
            }
        }
        return sum;
    }

    // number of elements larger than key
    public int higherCount(E key) {
        //return size() - lowerCount(key) - count(key);
        int sum = 0;
        Node x = root;
        while (x != null) {
            int cmp = comparator.compare(key, x.key);
            if (cmp > 0) x = x.right;
            else if (cmp < 0) {
                sum += rightRank(x) + x.count;
                x = x.left;
            } else {
                sum += rightRank(x);
                break;
            }
        }
        return sum;
    }

    public int index(E key) {
        return lowerCount(key);
    }

    public E get(int index) // index = 0 ... size - 1
    {
        Node p = root;
        ++index;
        while (true) {
            int t = leftRank(p);
            if (index <= t) p = p.left;
            else {
                if ((index -= t + p.count) <= 0) break;
                p = p.right;
            }
        }
        return p.key;
    }

    public int count(E key) {
        Node x = root;
        while (x != null) {
            int cmp = comparator.compare(key, x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) {
                x = x.right;
            } else {
                return x.count;
            }
        }
        return 0;
    }

    public E first() {
        if (root == null) return null;
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    public E last() {
        if (root == null) return null;
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

    public boolean contains(E key) {
        return count(key) > 0;
    }

    public E ceiling(E key) {
        int id = lowerCount(key);
        return id >= size() ? null : get(id);
    }

    public E floor(E key) {
        int id = size() - higherCount(key) - 1;
        return id < 0 ? null : get(id);
    }

    public E lower(E key) {
        int id = lowerCount(key) - 1;
        return id < 0 ? null : get(id);
    }

    public E higher(E key) {
        int id = size() - higherCount(key);
        return id >= size() ? null : get(id);
    }

    // return the first index whose value >= target
    // if this value doesn't exist, return index = size()
    public int lowerBound(E target) {
        return lowerCount(target);
    }

    // return the first index whose value > target
    // if this value doesn't exist, return index = size()
    public int upperBound(E target) {
        return size() - higherCount(target);
    }

    public List<E> keys() {
        List<E> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node x, List<E> list) {
        if (x == null) return;
        inorder(x.left, list);
        list.add(x.key);
        inorder(x.right, list);
    }
}
