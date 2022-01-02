package p1000_;

/**
 * https://leetcode.com/problems/long-pressed-name/
 *
 * @author half-dead
 */
public class Puzzle925_LongPressedName {
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int idx = 0;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                int pos = typed.indexOf(c, idx);
                if (pos == -1) {
                    return false;
                } else {
                    idx = pos + 1;
                }
            }
            return true;
        }
    }
}
