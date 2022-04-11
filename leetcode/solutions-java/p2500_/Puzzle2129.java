package p2500_;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/capitalize-the-title/
 *
 * @author half-dead
 */
public class Puzzle2129 {

    class StreamSolution {
        public String capitalizeTitle(String title) {
            return Arrays.stream(title.split(" "))
                    .map(s -> s.length() > 2
                            ? (Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase())
                            : s.toLowerCase())
                    .collect(Collectors.joining(" "));
        }
    }

    class Solution {
        public String capitalizeTitle(String title) {
            String[] arr = title.split(" ");
            StringBuilder sb = new StringBuilder(title.length());
            for (String s : arr) {
                if (sb.length() > 0) sb.append(' ');
                if (s.length() <= 2) {
                    sb.append(s.toLowerCase());
                } else {
                    sb.append(Character.toUpperCase(s.charAt(0)))
                            .append(s.substring(1).toLowerCase());
                }
            }
            return sb.toString();
        }
    }
}
