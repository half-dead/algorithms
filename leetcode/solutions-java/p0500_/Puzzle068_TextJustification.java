package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 *
 * @author half-dead
 */
public class Puzzle068_TextJustification {
    public static void main(String[] args) {
        Puzzle068_TextJustification p = new Puzzle068_TextJustification();
        Solution s = p.new Solution();
        List<String> list = s.fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20);
        pt(list);
    }

    public static void pt(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------");
    }

    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>(), line = new ArrayList<>();
            int len = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (len == 0) {
                    len = word.length();
                    line.add(word);
                    continue;
                }
                if (len + 1 + word.length() > maxWidth) {
                    StringBuilder builder = new StringBuilder();
                    if (line.size() == 1) {
                        builder.append(line.get(0));
                        while (builder.length() < maxWidth) builder.append(' ');
                    } else {
                        int spaces = maxWidth - len + line.size() - 1;
                        int avgPad = spaces / (line.size() - 1);
                        int extra = spaces % (line.size() - 1);
                        for (String w : line) {
                            if (builder.length() > 0) {
                                if (extra-- > 0) builder.append(' ');
                                int j = 0;
                                while (j++ < avgPad) builder.append(' ');
                            }
                            builder.append(w);
                        }
                    }
                    result.add(builder.toString());
                    line.clear();
                    len = 0;
                    i--;
                } else {
                    line.add(word);
                    len += word.length() + 1;
                }
            }
            if (line.size() > 0) {
                StringBuilder builder = new StringBuilder();
                for (String w : line) {
                    if (builder.length() > 0) builder.append(' ');
                    builder.append(w);
                }
                while (builder.length() < maxWidth) builder.append(' ');
                result.add(builder.toString());
            }
            return result;
        }
    }
}
