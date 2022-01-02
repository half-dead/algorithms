package p1500_;

/**
 * https://leetcode.com/problems/iterator-for-combination/
 *
 * @author half-dead
 */
public class Puzzle1286 {

class CombinationIterator {
    char[] dict;
    char[] state;

    public CombinationIterator(String characters, int combinationLength) {
        dict = characters.toCharArray();
        state = new char[combinationLength];
        System.arraycopy(dict, 0, state, 0, combinationLength);
        // just a trick to make the first call of next() return correct value
        state[state.length - 1]--;
    }

    public String next() {
        for (int i = state.length - 1, j = dict.length - 1; i >= 0; i--, j--) {
            if (state[i] == dict[j]) continue;

            for (int k = 0; k < dict.length; k++) {
                if (dict[k] > state[i]) {
                    state[i] = dict[k];
                    if (i + 1 < state.length)
                        System.arraycopy(dict, k + 1, state, i + 1, state.length - i - 1);
                    return new String(state);
                }
            }
        }
        return null;
    }

    public boolean hasNext() {
        for (int i = state.length - 1, j = dict.length - 1; i >= 0; i--, j--)
            if (state[i] != dict[j]) return true;
        return false;
    }
}
}
