package util;

/**
 * @author half-dead
 */ // Tested by Leetcode 1707 and Leetcode 1803
class TrieBinary {
    private static class TrieNode {
        TrieNode[] next = new TrieNode[2];
        long count;
    }

    private TrieNode root;
    private int numOfBits;

    public TrieBinary(int numOfBits) { // normally 31 for int and 63 for long
        this.numOfBits = numOfBits;
        this.root = new TrieNode();
    }

    public void add(long v) {
        add(v, 1L);
    }

    public void remove(long v) { // Tested by Leetcode 1938
        add(v, -1L);
    }

    public void add(long v, long count) {
        TrieNode cur = root;
        root.count += count;
        for (int i = numOfBits - 1; i >= 0; i--) {
            int b = ((v >>> i) & 1) == 0 ? 0 : 1;
            if (cur.next[b] == null) cur.next[b] = new TrieNode();
            cur = cur.next[b];
            cur.count += count;
        }
    }

    // Tested by Leetcode 1707
    public long xorMax(long v) {
        TrieNode cur = root;
        long key = 0;
        for (int i = numOfBits - 1; i >= 0; i--) {
            int b = ((v >>> i) & 1) == 0 ? 0 : 1;
            if (cur.next[1 - b] != null && cur.next[1 - b].count > 0) {
                cur = cur.next[1 - b];
                key |= (1L - b) << i;
            } else {
                cur = cur.next[b];
                key |= (long) b << i;
            }
        }
        return key ^ v;
    }

    public boolean contains(long v) {
        TrieNode cur = root;
        for (int i = numOfBits - 1; i >= 0; i--) {
            int b = ((v >>> i) & 1) == 0 ? 0 : 1;
            if (cur.next[b] == null || cur.next[b].count <= 0) return false;
            cur = cur.next[b];
        }
        return true;
    }

    // Tested by Leetcode 1803
    // count(x ^ v <= limit)
    public long xorLessOrEqualCount(long v, long limit) {
        if (limit < 0) return 0;
        TrieNode cur = root;
        long ans = 0;
        for (int i = numOfBits - 1; i >= 0; i--) {
            int bitLimit = ((limit >>> i) & 1) == 0 ? 0 : 1;
            int bitV = ((v >>> i) & 1) == 0 ? 0 : 1;
            if (bitLimit == 1) {
                ans += (cur.next[bitV] != null ? cur.next[bitV].count : 0);
            }
            cur = cur.next[bitV ^ bitLimit];
            if (cur == null) break;
            if (i == 0) ans += cur.count;
        }
        return ans;
    }
}
