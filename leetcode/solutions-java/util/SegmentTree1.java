package util;

/**
 * @author half-dead
 */
public class SegmentTree1 {
    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree1 tree = new SegmentTree1(arr);

        System.out.println("Sum of values in given range = " + tree.sum(1, 3));
        tree.add(1, 7);
        System.out.println("Updated sum of values in given range = " + tree.sum(1, 3));
    }


    private int[] st;
    private int n;

    public SegmentTree1(int[] arr) {
        n = arr.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        st = new int[2 * (int) Math.pow(2, height) - 1];
        construct(arr, 0, n - 1, 0);
    }

    public int sum(int left, int right) {
        if (left < 0 || right >= n || left > right) return -1;

        return sum(0, n - 1, left, right, 0);
    }

    public void add(int index, int delta) {
        if (index < 0 || index >= n || delta == 0) return;

        add(0, n - 1, index, delta, 0);
    }

    private int construct(int[] arr, int left, int right, int index) {
        if (left == right) return st[index] = arr[left];

        int mid = getMid(left, right);
        return st[index] = construct(arr, left, mid, index * 2 + 1) + construct(arr, mid + 1, right, index * 2 + 2);
    }

    private int sum(int start, int end, int queryLeft, int queryRight, int index) {
        if (queryLeft <= start && queryRight >= end) return st[index];
        if (end < queryLeft || start > queryRight) return 0;

        int mid = getMid(start, end);
        return sum(start, mid, queryLeft, queryRight, 2 * index + 1) +
                sum(mid + 1, end, queryLeft, queryRight, 2 * index + 2);
    }

    private void add(int start, int end, int index, int delta, int segmentIndex) {
        if (index < start || index > end) return;

        st[segmentIndex] += delta;
        if (end != start) {
            int mid = getMid(start, end);
            add(start, mid, index, delta, 2 * segmentIndex + 1);
            add(mid + 1, end, index, delta, 2 * segmentIndex + 2);
        }
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

}

