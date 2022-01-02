package p1000_;

import util.Print;

import java.util.*;

/**
 * https://leetcode.com/problems/advantage-shuffle/
 *
 * @author half-dead
 */
public class Puzzle870 {
    public static void main(String[] args) {
        Solution s = new Puzzle870().new Solution();
        Print.pt(s.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}));
    }

    // sort + binary search, greedy, 30ms, can't do faster....
    class Solution {
        public int[] advantageCount(int[] a, int[] b) {
            int n = a.length;
            Arrays.sort(a);
            int[][] qb = new int[n][2];
            for (int i = 0; i < n; i++) qb[i] = new int[]{b[i], i};
            Arrays.sort(qb, new Comparator<int[]>() {
                @Override
                public int compare(int[] e, int[] f) {
                    return e[0] - f[0];
                }
            });

            int[] res = new int[n], ibs = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = qb[i][0];
                ibs[i] = qb[i][1];
            }
            Arrays.fill(res, -1);

            int ia = n - 1, end = n, i = 0;
            while (ia >= 0) {
                int top = a[ia], pos = Arrays.binarySearch(b, 0, end, top - 1);
                if (pos == -1) break;
                if (pos >= 0) {
                    while (pos + 1 < end && b[pos] == b[pos + 1]) pos++;
                }

                res[ibs[end = pos < 0 ? -pos - 2 : pos]] = top;
                ia--;
            }
            while (ia >= 0) {
                while (res[i] != -1) i++;
                res[i++] = a[ia--];
            }
            return res;
        }
    }

    // PriorityQueue, Greedy, 62ms
    class Solution1 {
        public int[] advantageCount(int[] a, int[] b) {
            int n = a.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);

            PriorityQueue<Integer> qa = new PriorityQueue<>(n, Comparator.reverseOrder());
            PriorityQueue<int[]> qb = new PriorityQueue<>(n, (e, f) -> f[0] - e[0]);
            for (int num : a) qa.offer(num);
            for (int i = 0; i < n; i++) qb.offer(new int[]{b[i], i});

            while (qa.size() > 0) {
                int top = qa.peek();
                while (!qb.isEmpty() && qb.peek()[0] >= top) qb.poll();
                if (qb.isEmpty()) break;

                res[qb.poll()[1]] = qa.poll();
            }
            int i = 0;
            while (qa.size() > 0) {
                while (res[i] != -1) i++;
                res[i++] = qa.poll();
            }
            return res;
        }
    }

    // TreeMap, Greedy, 101ms
    class Solution2 {
        public int[] advantageCount(int[] a, int[] b) {
            int n = a.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            TreeMap<Integer, Integer> mapa = new TreeMap<>();
            TreeMap<Integer, LinkedList<Integer>> mapb = new TreeMap<>();
            for (int num : a) mapa.put(num, mapa.getOrDefault(num, 0) + 1);
            for (int i = 0; i < n; i++) mapb.computeIfAbsent(b[i], k -> new LinkedList<>()).offer(i);

            while (mapa.size() > 0) {
                int largest = mapa.lastKey(), cnt = mapa.get(largest);

                Integer match = mapb.floorKey(largest - 1);
                if (match == null) break;

                LinkedList<Integer> q = mapb.get(match);
                res[q.poll()] = largest;
                if (q.size() == 0) mapb.remove(match);

                if (cnt == 1) mapa.remove(largest);
                else mapa.replace(largest, cnt - 1);
            }

            int i = 0;
            while (mapa.size() > 0) {
                int first = mapa.firstKey(), cnt = mapa.get(first);
                while (cnt-- > 0) {
                    while (res[i] != -1) i++;
                    res[i++] = first;
                }
                mapa.remove(first);
            }
            return res;
        }
    }
}
