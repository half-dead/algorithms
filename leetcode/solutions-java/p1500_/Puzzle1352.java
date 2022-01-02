package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 *
 * @author half-dead
 */
public class Puzzle1352 {

    class ProductOfNumbers {

        List<Integer> list = new ArrayList<>();

        public ProductOfNumbers() {
        }

        public void add(int num) {
            if (num == 0) {
                list.clear();
            } else if (list.size() == 0) {
                list.add(num);
            } else {
                list.add(num * list.get(list.size() - 1));
            }
        }

        public int getProduct(int k) {
            if (k > list.size()) return 0;

            int res = list.get(list.size() - 1);
            if (k < list.size()) {
                res = res / list.get(list.size() - k - 1);
            }
            return res;
        }
    }
}
