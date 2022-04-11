package p2500_;

/**
 * https://leetcode.com/problems/design-bitset/submissions/
 *
 * @author half-dead
 */
public class Puzzle2166 {
    class Bitset {

        private int n, ones = 0;
        private boolean flipped = false;
        private boolean[] bits;

        public Bitset(int size) {
            n = size;
            bits = new boolean[n];
        }

        public void fix(int idx) {
            if (flipped) {
                if (bits[idx]) ones++;
                bits[idx] = false;
            } else {
                if (!bits[idx]) ones++;
                bits[idx] = true;
            }
        }

        public void unfix(int idx) {
            if (flipped) {
                if (!bits[idx]) ones--;
                bits[idx] = true;
            } else {
                if (bits[idx]) ones--;
                bits[idx] = false;
            }
        }

        public void flip() {
            flipped = !flipped;
            ones = n - ones;
        }

        public boolean all() {
            return ones == n;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder res = new StringBuilder(n);
            for (boolean b : bits) {
                if (flipped) res.append(!b ? 1 : 0);
                else res.append(b ? 1 : 0);
            }
            return res.toString();
        }
    }
}
