package util;

/**
 * @author half-dead
 */
public class UnionFind {
    int[] parent;
    int[] sz;

    public UnionFind(int n) {
        parent = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public void clear() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int x) {
        //return parent[x] == x ? x : (parent[x] = find(parent[x]));
        if (parent[x] == x) return x;
        int px = x;
        while (px != parent[px]) px = parent[px];
        while (x != px) {
            int next = parent[x];
            parent[x] = px;
            x = next;
        }
        return px;
    }

    // px is the final parent
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        parent[py] = px;
        sz[px] += sz[py];
        return true;
    }

    public int size(int x) {
        return sz[find(x)];
    }

    public UnionFind clone() {
        UnionFind cloned = new UnionFind(parent.length);
        for (int i = 0; i < parent.length; i++) {
            cloned.parent[i] = parent[i];
            cloned.sz[i] = sz[i];
        }
        return cloned;
    }
}
