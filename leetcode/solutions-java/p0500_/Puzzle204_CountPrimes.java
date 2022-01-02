package p0500_;

// Count the number of prime numbers less than a non-negative number, n

import java.util.BitSet;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class Puzzle204_CountPrimes {

    public static void main(String[] args) {
        Puzzle204_CountPrimes p = new Puzzle204_CountPrimes();
        int n = 499979;

        BitSetSolution s = p.new BitSetSolution();
        FastBitSetSolution fs = p.new FastBitSetSolution();

        long t1 = System.currentTimeMillis();
        int bs = s.countPrimes(n);
        System.out.println();

        long t2 = System.currentTimeMillis();
        int fbs = fs.countPrimes(n);
        System.out.println();
        long t3 = System.currentTimeMillis();

        System.out.println(" bs.result = " + bs + ", time = " + (t2 - t1));
        System.out.println("fbs.result = " + fbs + ", time = " + (t3 - t2));
    }

    public class Solution {
        public int countPrimes(int n) {
            if (n <= 2) return 0;
            boolean[] arr = new boolean[n];
            arr[0] = arr[1] = true;
            int half = (int) Math.sqrt(n);
            for (int i = 2; i <= half; i++) {
                int jj = n / i;
                for (int j = i; j <= jj; j++) {
                    int mul = i * j;
                    if (mul < n)
                        arr[mul] = true;
                }
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i])
                    count++;
            }
            return count;
        }
    }

    public class BitSetSolution {
        public int countPrimes(int n) {
            BitSet bs = new BitSet(n);
            bs.set(0);
            bs.set(1);
            int ind = 0, count = 0;
            while (ind < n) {
                ind = bs.nextClearBit(ind + 1);
                if (ind >= n) {
                    break;
                }
                count++;
                for (int i = 2 * ind; i < n; i += ind) {
                    bs.set(i);
                }
            }
            return count;
        }
    }

    public class FastBitSetSolution {
        public int countPrimes(int n) {
            if (n <= 2) return 0;
            BitSet bs = new BitSet(n);
            bs.set(0);
            bs.set(1);
            // skip 2, and all even numbers afterwards
            int ind = 3, count = 1, sqrt = (int) Math.sqrt(Integer.MAX_VALUE);
            while (ind < n) {
                ind = bs.nextClearBit(ind);
                // skip even numbers
                while ((ind & 1) == 0) {
                    ind = bs.nextClearBit(++ind);
                }
                if (ind >= n) {
                    break;
                }
                count++;
                // avoid overflow problem
                if (ind >= sqrt) {
                    ind += 2;
                    continue;
                }
                // ind must be odd, so we make step an even number, so that every time, i is an odd number
                for (int i = ind * ind, step = ind * 2; i < n; i += step) {
                    bs.set(i);
                }
                ind += 2;
            }
            return count;
        }
    }
}
