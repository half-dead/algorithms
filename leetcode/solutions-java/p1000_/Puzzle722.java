package p1000_;

import util.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-comments/
 *
 * @author half-dead
 */
public class Puzzle722 {
    public static void main(String[] args) {
        Solution s = new Puzzle722().new Solution();
        Print.pts(s.removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        Print.pts(s.removeComments(new String[]{"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"}));
        Print.pts(s.removeComments(new String[]{"main() {", "   func(1);", "   /** / more comments here", "   float f = 2.0", "   f += f;", "   cout << f; */", "}"}));
        Print.pts(s.removeComments(new String[]{"/*/d//*//*d//*/*/cbcedae/*/b//*/*//*/*//eae/*/a*///*///*ca//*ab//*e/*/eebea/*/"}));


    }

    class Solution {
        public List<String> removeComments(String[] source) {
            List<String> result = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            boolean bc = false;
            int bcIndex = 0;
            for (String line : source) {
                for (char c : line.toCharArray()) {
                    builder.append(c);
                    if (!bc) {
                        if (builder.indexOf("//") >= 0) {
                            builder.delete(builder.length() - 2, builder.length());
                            break;
                        } else if (builder.indexOf("/*") >= 0) {
                            bc = true;
                            bcIndex = builder.length() - 2;
                            builder.delete(builder.length() - 2, builder.length());
                        }
                    } else {
                        if (builder.lastIndexOf("*/") >= bcIndex) {
                            builder.delete(bcIndex, builder.length());
                            bcIndex = 0;
                            bc = false;
                        }
                    }
                }

                if (!bc && builder.length() > 0) {
                    result.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            if (builder.length() > 0) result.add(builder.toString());
            return result;
        }
    }
}
