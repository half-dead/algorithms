package p2500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encrypt-and-decrypt-strings/
 */
public class Puzzle2227 {

    class Encrypter {

        Map<String, Integer> codes = new HashMap<>();
        Map<Character, String> map;

        public Encrypter(char[] keys, String[] values, String[] dict) {
            map = new HashMap<>(keys.length);
            for (int i = 0; i < keys.length; i++) {
                map.put(keys[i], values[i]);
            }

            for (String w : dict) {
                String code = encrypt(w);
                if (code.length() > 0)
                    codes.put(code, codes.getOrDefault(code, 0) + 1);
            }
        }

        public String encrypt(String w) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                if (!map.containsKey(w.charAt(i))) return "";
                res.append(map.get(w.charAt(i)));
            }
            return res.toString();
        }

        public int decrypt(String w) {
            return codes.getOrDefault(w, 0);
        }
    }

}
