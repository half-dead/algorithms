package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 *
 * @author half-dead
 */
public class Puzzle1002_FindCommonCharacters {
    class Solution {
        public List<String> commonChars(String[] arr) {
            int[] base = new int[26];
            String first = arr[0];
            for (int i = 0; i < first.length(); i++) base[first.charAt(i) - 'a']++;

            for (int i = 1; i < arr.length; i++) {
                int[] o = new int[26];
                String s = arr[i];
                for (int j = 0; j < s.length(); j++) o[s.charAt(j) - 'a']++;
                min(base, o);
            }

            List<String> result = new ArrayList<>();
            for (int i = 0; i < base.length; i++)
                if (base[i] > 0) for (int k = 0; k < base[i]; k++) result.add(String.valueOf((char) ('a' + i)));
            return result;
        }

        void min(int[] a, int[] b) {
            for (int i = 0; i < a.length; i++)
                a[i] = Math.min(a[i], b[i]);
        }
    }
}
