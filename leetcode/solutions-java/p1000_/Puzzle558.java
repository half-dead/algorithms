package p1000_;

import struct2.Node;

/**
 * https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 *
 * @author half-dead
 */
public class Puzzle558 {

    class Solution {
        public Node intersect(Node qt1, Node qt2) {
            if (qt1.isLeaf) return qt1.val ? qt1 : qt2;
            if (qt2.isLeaf) return qt2.val ? qt2 : qt1;

            Node res = new Node();
            Node tl = intersect(qt1.topLeft, qt2.topLeft);
            Node tr = intersect(qt1.topRight, qt2.topRight);
            Node bl = intersect(qt1.bottomLeft, qt2.bottomLeft);
            Node br = intersect(qt1.bottomRight, qt2.bottomRight);
            if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf
                    && tl.val == tr.val && tl.val == bl.val && tl.val == br.val) {
                res.val = tl.val;
                res.isLeaf = true;
            } else {
                res.topLeft = tl;
                res.topRight = tr;
                res.bottomLeft = bl;
                res.bottomRight = br;
            }
            return res;
        }
    }
}
