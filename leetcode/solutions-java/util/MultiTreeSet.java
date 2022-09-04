package util;

import java.util.*;

/**
 * @author half-dead
 */
class MultiTreeSet<E> {
    TreeMap<E, Integer> data;
    int sz;

    public MultiTreeSet() {
        data = new TreeMap<>();
        sz = 0;
    }

    public MultiTreeSet(Comparator<E> comparator) {
        data = new TreeMap<>(comparator);
        sz = 0;
    }

    public void add(E e) {
        data.put(e, data.getOrDefault(e, 0) + 1);
        sz++;
    }

    public boolean remove(Object o) {
        if (data.containsKey(o)) {
            data.put((E) o, data.getOrDefault(o, 0) - 1);
            sz--;

            if (data.get(o) == 0) {
                data.remove(o);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(E e) {
        return data.containsKey(e);
    }

    public E first() {
        return data.firstKey();
    }

    public E last() {
        return data.lastKey();
    }

    public int size() {
        return sz;
    }

    public List<E> getAll() {
        List<E> list = new ArrayList<>();
        for (Map.Entry<E, Integer> entry : data.entrySet()) {
            E e = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                list.add(e);
            }
        }
        return list;
    }
}
