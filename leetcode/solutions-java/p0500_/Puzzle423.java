package p0500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 *
 * @author half-dead
 */
public class Puzzle423 {

    class Solution {
        Map<Character, String> magicMap = new LinkedHashMap<>();
        String[] order = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        {
            magicMap.put('z', "zero");
            magicMap.put('w', "two");
            magicMap.put('u', "four");
            magicMap.put('x', "six");
            magicMap.put('g', "eight");
            magicMap.put('f', "five");
            magicMap.put('v', "seven");
            magicMap.put('t', "three");
            magicMap.put('o', "one");
            magicMap.put('e', "nine");
        }

        public String originalDigits(String s) {
            int[] cnt = new int[26], tmp = new int[26];
            for (char c : s.toCharArray()) cnt[c - 'a']++;

            Map<String, Integer> map = new HashMap<>();
            for (char mc : magicMap.keySet()) {
                String word = magicMap.get(mc);
                int times = cnt[mc - 'a'];
                map.put(word, times);
                if (times == 0) continue;

                for (char c : word.toCharArray()) tmp[c - 'a']++;
                for (int j = 0; j < 26; j++) cnt[j] -= times * tmp[j];
                Arrays.fill(tmp, 0);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                int times = map.get(order[i]);
                while (times-- > 0) sb.append(i);
            }
            return sb.toString();
        }
    }
}
