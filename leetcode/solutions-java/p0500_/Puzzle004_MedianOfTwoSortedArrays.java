package p0500_;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class Puzzle004_MedianOfTwoSortedArrays {
    public static void main(String[] args) throws InterruptedException {
        Puzzle004_MedianOfTwoSortedArrays p = new Puzzle004_MedianOfTwoSortedArrays();
        MergeSolution mergeSolution = p.new MergeSolution();
        double medianSortedArrays = mergeSolution.findMedianSortedArrays(new int[]{1, 2, 3, 5, 7, 9}, new int[]{0, 1, 2, 8});
        System.out.println(medianSortedArrays);
    }

    public class Solution {
        public double findMedianSortedArrays(int a[], int b[]) {
            // O(logm+n) time, O(1) space
            return 0.0D;
        }
    }

    public class MergeSolution {
        public double findMedianSortedArrays(int a[], int b[]) {
            int[] m;
            if (a.length == 0) {
                m = b;
            } else if (b.length == 0) {
                m = a;
            } else {
                m = new int[a.length + b.length];
            }
            if (m.length == 0) {
                return 0.0D;
            }
            if (a.length != 0 && b.length != 0) {
                int i = 0, j = 0, n = 0;
                while (i < a.length || j < b.length) {
                    if (j >= b.length || (i < a.length && a[i] <= b[j])) {
                        m[n++] = a[i++];
                    } else {
                        m[n++] = b[j++];
                    }
                }
            }
            if (m.length % 2 != 0) {
                return m[m.length / 2];
            } else {
                return (m[m.length / 2] + m[m.length / 2 - 1]) / 2.0d;
            }
        }
    }
}
