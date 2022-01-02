package p1000_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/online-stock-span/
 *
 * @author half-dead
 */
public class Puzzle901_OnlineStockSpane {

    public static void main(String[] args) {
        Puzzle901_OnlineStockSpane p = new Puzzle901_OnlineStockSpane();
        StockSpanner sp = p.new StockSpanner();
        System.out.println(sp.next(100));
        System.out.println(sp.next(80));
        System.out.println(sp.next(60));
        System.out.println(sp.next(70));
        System.out.println(sp.next(60));
        System.out.println(sp.next(75));
        System.out.println(sp.next(85));
    }

    class StockSpanner {
        List<int[]> list;

        public StockSpanner() {
            this.list = new ArrayList<>();
        }

        public int next(int price) {
            int res = 1;
            for (int idx = list.size() - 1; idx >= 0; ) {
                int[] prev = list.get(idx);
                if (prev[0] > price) {
                    break;
                } else {
                    res += prev[1];
                    idx -= prev[1];
                }
            }
            list.add(new int[]{price, res});
            return res;
        }


    }

    class StockSpanner2 {
        LinkedList<int[]> stack = new LinkedList<>();

        public int next(int price) {
            int res = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price)
                res += stack.pop()[1];
            stack.push(new int[]{price, res});
            return res;
        }
    }
}
