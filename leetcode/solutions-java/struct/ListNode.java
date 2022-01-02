package struct;

import java.util.HashSet;
import java.util.Set;

/**
 * @author halfdead
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public ListNode(int[] arr) {
        val = arr[0];
        if (arr.length == 1) {
            return;
        }
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextnode = new ListNode(arr[i]);
            cur.next = nextnode;
            cur = nextnode;
        }
    }

    @Override
    public String toString() {
        Set<ListNode> set = new HashSet<>();
        StringBuilder builder = new StringBuilder().append(val);
        set.add(this);
        ListNode nn = this;
        while ((nn = nn.next) != null) {
            if (set.contains(nn)) {
                builder.append("-.-.-.-.->").append(nn.val);
                break;
            } else {
                builder.append("->").append(nn.val);
                set.add(nn);
            }
        }
        return builder.toString();
    }
}
