package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */ // BlockList for Range Query Sum
// Tested by https://leetcode.com/problems/range-sum-query-mutable/
class BlockList {
    static final int MAX_BLOCK_SIZE = 320;

    class Block {
        int[] data;
        int sum = 0;

        public Block(int[] input) {
            this.data = input;
            for (int i = 0; i < input.length; i++) {
                sum += input[i];
            }
        }

        // [startIndex, endIndex]
        int query(int startIndex, int endIndex) {
            int ans = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                ans += data[i];
            }
            return ans;
        }

        // [0, data.size() - 1]
        // NOTE: must be O(1) for this operation
        int queryAll() {
            return sum;
        }

        void update(int index, int value) {
            sum = sum - data[index] + value;
            data[index] = value;
        }
    }

    List<Block> blocks;

    public BlockList(int[] data) {
        int n = data.length;
        blocks = new ArrayList<>();
        for (int i = 0; i < n; i += MAX_BLOCK_SIZE) {
            int end = Math.min(i + MAX_BLOCK_SIZE, n);
            int len = end - i;
            int[] t = new int[len];
            for (int j = 0; j < len; j++) t[j] = data[j + i];
            blocks.add(new Block(t));
        }
    }

    // [l, r]
    public int query(int l, int r) {
        int lIndex = l / MAX_BLOCK_SIZE;
        int lPos = l % MAX_BLOCK_SIZE;
        int rIndex = r / MAX_BLOCK_SIZE;
        int rPos = r % MAX_BLOCK_SIZE;
        if (lIndex == rIndex) {
            return blocks.get(lIndex).query(lPos, rPos);
        } else {
            Block lb = blocks.get(lIndex);
            Block rb = blocks.get(rIndex);
            int ans = 0;

            ans += lb.query(lPos, lb.data.length - 1);
            for (int i = lIndex + 1; i < rIndex; i++) {
                ans += blocks.get(i).queryAll();
            }
            ans += rb.query(0, rPos);
            return ans;
        }
    }

    public void update(int index, int value) {
        blocks.get(index / MAX_BLOCK_SIZE).update(index % MAX_BLOCK_SIZE, value);
    }
}
