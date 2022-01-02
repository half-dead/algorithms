/*
https://leetcode.com/problems/construct-quad-tree/submissions/
 */

package p0500_;

import struct2.Node;

/**
 * @author half-dead
 */
public class Puzzle427_ConstructQuadTree {

    class Solution {
        public Node construct(int[][] grid) {
            int n = grid.length;
            return constructNode(grid, 0, n, 0, n);
        }

        public Node constructNode(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
            Node subNode = new Node();
            if (rowStart == rowEnd || isSameValue(grid, rowStart, rowEnd, colStart, colEnd)) {
                subNode.isLeaf = true;
                subNode.val = grid[rowStart][colStart] == 1;
            } else {
                int half = (rowEnd - rowStart) / 2;
                subNode.isLeaf = false;
                subNode.val = false;
                subNode.topLeft = constructNode(grid, rowStart, rowStart + half, colStart, colStart + half);
                subNode.topRight = constructNode(grid, rowStart, rowStart + half, colStart + half, colEnd);
                subNode.bottomLeft = constructNode(grid, rowStart + half, rowEnd, colStart, colStart + half);
                subNode.bottomRight = constructNode(grid, rowStart + half, rowEnd, colStart + half, colEnd);

            }
            return subNode;
        }

        public boolean isSameValue(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
            int val = grid[rowStart][colStart];
            for (int i = rowStart; i < rowEnd; i++) {
                for (int j = colStart; j < colEnd; j++) {
                    if (grid[i][j] != val) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
