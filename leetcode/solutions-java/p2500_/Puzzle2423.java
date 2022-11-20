package p2500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-letter-to-equalize-frequency/
 */
public class Puzzle2423 {

    class Solution {
        public boolean equalFrequency(String word) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            List<Integer> list = new ArrayList<>();
            for (int f : freq) {
                if (f > 0) list.add(f);
            }

            int[] fuck = new int[list.size()];
            for (int i = 0; i < fuck.length; i++) {
                fuck[i] = list.get(i);
            }

            for (int i = 0; i < fuck.length; i++) {
                int[] copy = new int[fuck.length];
                System.arraycopy(fuck, 0, copy, 0, fuck.length);
                copy[i]--;
                Arrays.sort(copy);
                if (copy[0] == copy[fuck.length - 1]) {
                    return true;
                }
                if (copy[0] == 0 && copy[1] == copy[fuck.length - 1]) {
                    return true;
                }
            }
            return false;
        }
    }
}
