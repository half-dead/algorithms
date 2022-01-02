package p1500_;

/**
 * @author half-dead
 */
public class Puzzle1357 {

    class Cashier {

        int c, n, d;
        int[] map;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            d = discount;
            map = new int[201];
            for (int i = 0; i < products.length; i++) {
                map[products[i]] = prices[i];
            }
        }

        public double getBill(int[] product, int[] amount) {
            double bill = 0.0d;
            for (int i = 0; i < product.length; i++) {
                bill += map[product[i]] * amount[i];
            }
            if (++c % n == 0) {
                bill = bill - (d * bill) / 100;
            }
            return bill;
        }
    }

}
