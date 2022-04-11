package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/online-majority-element-in-subarray/
 *
 * @author half-dead
 */
public class Puzzle1157 {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1};
        MajorityChecker mc = new Puzzle1157().new MajorityChecker(arr);
        System.out.println(mc.query(3, 12, 6));
    }

    // binary search
    class MajorityChecker {

        int[] data;
        TreeMap<Integer, Set<Integer>> tm;
        Map<Integer, int[]> occur;

        public MajorityChecker(int[] arr) {
            this.data = arr;
            occur = new HashMap<>();

            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : arr) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            tm = new TreeMap<>();
            for (int k : freq.keySet()) {
                int v = freq.get(k);

                tm.computeIfAbsent(v, x -> new HashSet<>()).add(k);
            }

            Map<Integer, List<Integer>> temp = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                temp.computeIfAbsent(x, y -> new ArrayList<>()).add(i);
            }

            for (int k : temp.keySet()) {
                List<Integer> seq = temp.get(k);
                int[] a = new int[seq.size()];
                for (int i = 0; i < seq.size(); i++) {
                    a[i] = seq.get(i);
                }
                occur.put(k, a);
            }
        }

        public int query(int left, int right, int threshold) {
            if (left == right) return data[left];

            for (int repeat : tm.descendingKeySet()) {
                if (repeat < threshold) break;

                Set<Integer> set = tm.get(repeat);
                for (int cand : set) {
                    int[] seq = occur.get(cand);
                    int lo = Arrays.binarySearch(seq, left);
                    int hi = Arrays.binarySearch(seq, right);

                    if (lo < 0) lo = -lo - 1;
                    if (hi < 0) hi = -hi - 2;
                    if (hi - lo + 1 >= threshold) {
                        return cand;
                    }
                }
            }
            return -1;
        }
    }

}
