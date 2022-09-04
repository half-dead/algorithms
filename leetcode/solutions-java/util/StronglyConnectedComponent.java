package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author half-dead
 */
class StronglyConnectedComponent {
    // Return sccId for each v
    // if v is not in scc, then sccId[v] == v
    public static int[] findScc(List<Integer>[] g) {
        int n = g.length;
        boolean[] vst = new boolean[n];
        List<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            if (!vst[i]) {
                dfs(g, i, vst, order);
            }

        // Build reverse graph
        List<Integer>[] gt = new List[n];
        for (int i = 0; i < n; i++) gt[i] = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
            if (g[i] != null) {
                for (int y : g[i]) {
                    gt[y].add(i);
                }
            }

        int[] sccId = new int[n];
        Arrays.fill(vst, false);
        for (int i = n - 1; i >= 0; i--)
            if (!vst[order.get(i)]) {
                dfsGT(gt, order.get(i), vst, order.get(i), sccId);
            }
        return sccId;
    }

    private static void dfs(List<Integer>[] g, int x, boolean[] vst, List<Integer> order) {
        if (vst[x]) return;
        vst[x] = true;
        if (g[x] != null) {
            for (int y : g[x]) {
                dfs(g, y, vst, order);
            }
        }
        order.add(x);
    }

    private static void dfsGT(List<Integer>[] gt, int x, boolean[] vst, int sccRoot, int[] sccId) {
        if (vst[x]) return;
        sccId[x] = sccRoot;
        vst[x] = true;
        if (gt[x] != null) {
            for (int y : gt[x]) {
                dfsGT(gt, y, vst, sccRoot, sccId);
            }
        }
    }
}
