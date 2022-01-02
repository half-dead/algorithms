package p1500_;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-duplicate-substring/
 *
 * @author half-dead
 */
public class Puzzle1044 {

    // binary search + rabin-karp + polynomial rolling hash
    // O(NlogN) time, O(N) space
    class Solution {
        public String longestDupSubstring(String s) {
            int n = s.length(), lo = 0, hi = n - 1;
            String res = "";
            char[] cs = s.toCharArray();

            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                String temp = find(cs, mid);
                if (temp != null) {
                    res = temp;
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            return res;
        }

        // since there are only lowercase english letters, we could use base=26
        final long base = 26;
        // Integer.MAX_VALUE is a prime and big enough
        final long mod = Integer.MAX_VALUE;

        final BigInteger baseBI = new BigInteger(base + ""), modBI = new BigInteger(mod + "");

        String find(char[] cs, int n) {
            long hash = 0L, pow = baseBI.modPow(new BigInteger(n + ""), modBI).longValue();

            Map<Long, List<Integer>> map = new HashMap<>();
            // compute initial hash for the first n chars
            for (int i = 0; i < n; i++) hash = (hash * base + (cs[i] - 'a')) % mod;
            // put initial hash to map
            map.computeIfAbsent(hash, x -> new ArrayList<>()).add(0);

            for (int i = n; i < cs.length; i++) {
                // rolling hash
                hash = (hash * base + (cs[i] - 'a') - (cs[i - n] - 'a') * pow) % mod;
                // hash could be negative here, we should make it positive
                hash = (hash + mod) % mod;

                List<Integer> slot = map.computeIfAbsent(hash, x -> new ArrayList<>());
                if (slot.size() > 0) {
                    String curr = new String(cs, i - n + 1, n);
                    // might be a hash collision, do a equals check for every element
                    for (int start : slot) {
                        if (curr.equals(new String(cs, start, n))) return curr;
                    }
                }
                slot.add(i - n + 1);
            }
            return null;
        }
    }
}
