package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 *
 * @author half-dead
 */
public class Puzzle1442 {

    public static void main(String[] args) {
        Solution s = new Puzzle1442().new Solution();
        System.out.println(s.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(s.countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(s.countTriplets(new int[]{2, 3}));
        System.out.println(s.countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(s.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    // O(N) time
    class Solution0 {
        public int countTriplets(int[] a) {
            int n = a.length, res = 0, prefix = 0, c, t;
            Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
            count.put(0, 1);
            for (int i = 0; i < n; ++i) {
                prefix ^= a[i];
                c = count.getOrDefault(prefix, 0);
                t = total.getOrDefault(prefix, 0);
                res += c * i - t;
                count.put(prefix, c + 1);
                total.put(prefix, t + i + 1);
            }
            return res;
        }
    }

    // O(N^2) time
    class Solution {
        public int countTriplets(int[] arr) {
            int n = arr.length, res = 0;
            int[] xors = new int[n + 1];
            for (int i = 0; i < n; i++) xors[i + 1] = xors[i] ^ arr[i];

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (xors[j] == xors[i - 1]) {
                        res += j - i;
                    }
                }
            }
            return res;
        }
    }

    // O(N^3) time
    class BruteForceSolution {
        public int countTriplets(int[] arr) {
            int n = arr.length, res = 0;
            int[] xors = new int[n + 1];
            for (int i = 0; i < n; i++) xors[i + 1] = xors[i] ^ arr[i];

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int k = j; k <= n; k++) {
                        if ((xors[j - 1] ^ xors[i - 1]) == (xors[k] ^ xors[j - 1])) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
