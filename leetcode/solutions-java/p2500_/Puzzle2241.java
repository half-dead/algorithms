package p2500_;

/**
 * https://leetcode.com/problems/design-an-atm-machine/
 *
 * @author half-dead
 */
public class Puzzle2241 {

    class ATM {

        int n = 5;
        long[] repo;
        int[] values = new int[]{20, 50, 100, 200, 500};

        public ATM() {
            repo = new long[n];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < n; i++) {
                repo[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] take = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                if (repo[i] > 0 && amount >= values[i]) {
                    long cnt = Math.min(repo[i], (long) amount / values[i]);
                    amount -= values[i] * cnt;
                    take[i] = (int) cnt;
                }
            }
            if (amount != 0) return new int[]{-1};
            for (int i = 0; i < n; i++) repo[i] -= take[i];
            return take;
        }
    }

}
