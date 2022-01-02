package p1000_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 *
 * @author half-dead
 */
public class Puzzle950_RevealCardsInIncreasingOrder {
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            int[] positions = new int[deck.length];
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < deck.length; i++) {
                q.addLast(i);
            }
            int i = 0;
            while (q.size() > 0) {
                positions[i++] = q.removeFirst();
                if (q.size() > 1) {
                    q.addLast(q.removeFirst());
                }
            }
            Arrays.sort(deck);
            int[] result = new int[deck.length];
            for (i = 0; i < result.length; i++) {
                result[positions[i]] = deck[i];
            }
            return result;
        }
    }

    class Solution3 {
        public int[] deckRevealedIncreasing(int[] deck) {
            int n = deck.length;
            int[] result = new int[n];
            Arrays.sort(deck);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.offer(i);
            }
            int p = q.poll();
            for (int i = 0; i < n; i++) {
                result[p] = deck[i];
                if (i < n - 1) {
                    q.offer(q.poll());
                    p = q.poll();
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            return mergeSort(deck, true);
        }

        public int[] mergeSort(int[] deck, boolean swap) {
            if (deck.length <= 1) return deck;
            int pivot = (deck.length + 1) / 2;
            int[] left, right;
            if (!swap) {
                pivot = (deck.length) / 2;
                right = Arrays.copyOfRange(deck, 0, pivot);
                left = Arrays.copyOfRange(deck, pivot, deck.length);
                left = mergeSort(left, right.length != left.length);
            } else {
                left = Arrays.copyOfRange(deck, 0, pivot);
                right = Arrays.copyOfRange(deck, pivot, deck.length);
                right = mergeSort(right, left.length == right.length);
            }
            return merge(left, right);
        }

        public int[] merge(int[] left, int[] right) {
            int i = 0, j = 0;

            int[] aux = new int[left.length + right.length];
            while (i < left.length && i < right.length) {
                aux[j++] = left[i];
                aux[j++] = right[i];
                i++;
            }
            while (i < left.length) {
                aux[j++] = left[i++];
            }
            while (i < right.length) {
                aux[j++] = right[i++];
            }

            return aux;
        }

    }
}
