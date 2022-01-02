package p1500_;

/**
 * https://leetcode.com/problems/subrectangle-queries/
 *
 * @author half-dead
 */
public class Puzzle1476 {

    class SubrectangleQueries {

        int[][] rect;
        int[][] updates = new int[500][];
        int pos = 0;

        public SubrectangleQueries(int[][] rectangle) {
            this.rect = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            updates[pos++] = new int[]{row1, col1, row2, col2, newValue};
        }

        public int getValue(int row, int col) {
            for (int i = pos - 1; i >= 0; i--) {
                int[] upd = updates[i];
                if (upd[0] <= row && row <= upd[2] && upd[1] <= col && col <= upd[3]) return upd[4];
            }
            return rect[row][col];
        }
    }

}
