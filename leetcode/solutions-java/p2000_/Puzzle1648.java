package p2000_;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
 *
 * @author half-dead
 */
public class Puzzle1648 {

    public static void main(String[] args) {
        Solution s = new Puzzle1648().new Solution();
        // 14
        System.out.println(s.maxProfit(new int[]{2, 5}, 4));
        // 19
        System.out.println(s.maxProfit(new int[]{3, 5}, 6));
        // 110
        System.out.println(s.maxProfit(new int[]{2, 8, 4, 10, 6}, 20));
        // 21
        System.out.println(s.maxProfit(new int[]{1000000000}, 1000000000));
    }

    class Solution1 {

        final int BASE = 1000000007;

        public int maxProfit(int[] inventory, int orders) {
            Arrays.sort(inventory);

            long pf = 0;
            int len = inventory.length, idx = inventory.length - 1;

            while (orders > 0) {
                if (idx > 0 && inventory[idx] - inventory[idx - 1] > 0 && orders - (len - idx) * (inventory[idx] - inventory[idx - 1]) >= 0) {
                    pf += (len - idx) * getPf(inventory[idx], inventory[idx - 1]);
                    orders -= (len - idx) * (inventory[idx] - inventory[idx - 1]);
                } else if (idx == 0 || orders - (len - idx) * (inventory[idx] - inventory[idx - 1]) < 0) {
                    long a = orders / (len - idx);
                    long b = orders % (len - idx);
                    pf += (len - idx) * getPf(inventory[idx], inventory[idx] - a);
                    pf += (inventory[idx] - a) * b;
                    orders = 0;
                }
                pf %= BASE;
                idx--;
            }
            return (int) pf;
        }

        public long getPf(long curr, long next) {
            return ((curr + (next + 1)) * (curr - next)) / 2;
            // return (curr * (curr+1))/2 - (next * (next+1))/2;
        }
    }

    class Solution {
        public int maxProfit(int[] inventory, int orders) {
            long mod = (long) 1e9 + 7, profit = 0L;

            Arrays.sort(inventory);

            int[][] map = new int[inventory.length][2];
            int idx = 0;
            for (int i = inventory.length - 1; i >= 0; i--) {
                if (map[idx][0] != inventory[i]) {
                    map[idx][0] = inventory[i];
                    map[idx][1]++;
                    idx++;
                } else {
                    map[idx][1]++;
                }
            }

            int pos = 0;
            while (orders > 0) {
                int cnt1 = map[pos][0], cnt2 = 0;
                int times = map[pos][1];

                if (pos + 1 < map.length) {
                    cnt2 = map[pos + 1][0];
                }

                int available = times * (cnt1 - cnt2);

                if (available >= orders) {
                    cnt2 = cnt1 - orders / times;

                    profit += times * ((long) cnt1 * (cnt1 + 1) / 2 - (long) cnt2 * (cnt2 + 1) / 2);
                    profit += (long) cnt2 * (orders % times);
                    break;
                } else {
                    profit += times * ((long) cnt1 * (cnt1 + 1) / 2 - (long) cnt2 * (cnt2 + 1) / 2);
                    orders -= available;

                    map[++pos][1] += map[pos - 1][1];
                }
            }

            return (int) (profit % mod);
        }
    }

    class TreeMapSolution {
        public int maxProfit(int[] inventory, int orders) {
            long mod = (long) 1e9 + 7, profit = 0L;

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int n : inventory) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            while (orders > 0) {
                Map.Entry<Integer, Integer> first = map.lastEntry();
                Map.Entry<Integer, Integer> second = map.lowerEntry(first.getKey());

                int count = first.getKey(), count2 = 0;
                int times = first.getValue();


                if (second != null) {
                    count2 = second.getKey();
                }

                int available = times * (count - count2);

                if (available >= orders) {
                    count2 = count - orders / times;

                    profit += times * ((long) count * (count + 1) / 2 - (long) count2 * (count2 + 1) / 2);
                    profit += (long) count2 * (orders % times);
                    break;
                } else {
                    profit += times * ((long) count * (count + 1) / 2 - (long) count2 * (count2 + 1) / 2);
                    orders -= available;

                    map.remove(count);
                    map.put(count2, map.getOrDefault(count2, 0) + times);
                }
            }

            return (int) (profit % mod);
        }
    }
}
