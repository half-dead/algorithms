package p0500_;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/submissions/
 *
 * @author half-dead
 */
public class Puzzle388 {

    public static void main(String[] args) {
        Solution s = new Puzzle388().new Solution();
        System.out.println(s.lengthLongestPath("dir\n        file.txt"));
    }

    class Solution {
        public int lengthLongestPath(String input) {
            int res = 0;

            String[] lines = input.split("\n");
            int[] dirs = new int[lines.length];
            for (String line : lines) {
                int depth = 0;
                while (line.charAt(depth) == '\t') depth++;

                if (line.indexOf('.') != -1) {
                    int dirLength = 0;
                    for (int i = 0; i < depth; i++)
                        dirLength += dirs[i];
                    res = Math.max(res, line.length() + dirLength);
                } else {
                    dirs[depth] = line.length() - depth;
                }
            }
            return res;
        }
    }
}
