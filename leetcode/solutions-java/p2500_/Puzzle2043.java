package p2500_;

/**
 * @author half-dead
 */
public class Puzzle2043 {

    class Bank {

        long[] bank;
        int n;

        public Bank(long[] balance) {
            bank = balance;
            n = bank.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 > n || account2 > n || bank[account1 - 1] < money) return false;

            bank[account1 - 1] -= money;
            bank[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account > n) return false;

            bank[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account > n || bank[account - 1] < money) return false;
            bank[account - 1] -= money;
            return true;
        }
    }
}
