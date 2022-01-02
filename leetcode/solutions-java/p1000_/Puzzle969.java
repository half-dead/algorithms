package p1000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 *
 * @author half-dead
 */
public class Puzzle969 {

    // Straight forward, every time, find the largest number that is not in the correct position
    // then make two flips to put it in the correct position
    // time complexity is O(N^2)
    class Solution {
        public List<Integer> pancakeSort(int[] a) {
            int n = a.length;
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                int i = 0;
                while (a[i] != n) i++;
                if (i != n - 1) {
                    reverse(a, 0, i);
                    list.add(i + 1);
                    reverse(a, 0, n - 1);
                    list.add(n);
                }
                n--;
            }
            return list;
        }

        void reverse(int[] a, int i, int j) {
            while (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
    }
}
