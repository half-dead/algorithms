package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 *
 * @author half-dead
 */
public class Puzzle937 {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (a, b) -> {
                boolean ba = Character.isDigit(a.charAt(a.length() - 1));
                boolean bb = Character.isDigit(b.charAt(b.length() - 1));
                if (ba && bb) return 0;
                else if (ba) return 1;
                else if (bb) return -1;

                int ia = a.indexOf(' '), ib = b.indexOf(' ');
                String aid = a.substring(0, ia), bid = b.substring(0, ib);
                String alog = a.substring(ia + 1), blog = b.substring(ib + 1);
                int r = alog.compareTo(blog);
                if (r == 0) return aid.compareTo(bid);
                return r;
            });
            return logs;
        }
    }
}
