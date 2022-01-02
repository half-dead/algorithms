package p1000_;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * @author half-dead
 */
public class Puzzle841_KeysAndRooms {

    class Solution {
        private List<List<Integer>> rooms;
        private boolean[] marker;
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            this.rooms = rooms;
            this.marker = new boolean[rooms.size()];
            dfs(0);
            for (boolean b : marker) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }

        private void dfs(int idx) {
            if (!marker[idx]) {
                marker[idx] = true;
                for (int i : rooms.get(idx)) {
                    dfs(i);
                }
            }
        }
    }

    class SetSolution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Set<Integer> keySet = new HashSet<>();
            Set<Integer> roomSet = new HashSet<>();
            keySet.add(0);
            roomSet.add(0);

            int i = 0, target = rooms.size();
            while (i < target) {
                i++;
                for (Integer key : keySet) {
                    List<Integer> list = rooms.get(key);
                    roomSet.addAll(list);
                }
                keySet = roomSet;
                roomSet = new HashSet<>();
                roomSet.addAll(keySet);
            }
            return roomSet.size() == target;
        }
    }
}
