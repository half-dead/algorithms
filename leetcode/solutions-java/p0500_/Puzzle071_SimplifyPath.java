package p0500_;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"

Corner Cases:
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 */

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/simplify-path/description/
 *
 * @author half-dead
 */
public class Puzzle071_SimplifyPath {

    public static void main(String[] args) {
        Puzzle071_SimplifyPath p = new Puzzle071_SimplifyPath();
        Solution s = p.new Solution();
        String result = s.simplifyPath("/../");
        System.out.println(result);
    }

    class Solution {
        public String simplifyPath(String path) {
            int start = 0, end = 0;
            LinkedList<String> linkedList = new LinkedList<>();
            while ((end = path.indexOf("/", start)) != -1) {
                if (start < end) {
                    String part = path.substring(start, end);
                    trySimplify(linkedList, part);
                }
                start = end + 1;
            }
            if (start < path.length()) {
                String part = path.substring(start);
                trySimplify(linkedList, part);
            }
            StringBuilder builder = new StringBuilder();
            for (String s : linkedList) {
                builder.append("/").append(s);
            }
            return builder.length() > 0 ? builder.toString() : "/";
        }

        private void trySimplify(LinkedList<String> linkedList, String part) {
            if (".".equals(part)) {
                // ignore
            } else if ("..".equals(part)) {
                linkedList.pollLast();
            } else {
                linkedList.addLast(part);
            }
        }
    }
}
