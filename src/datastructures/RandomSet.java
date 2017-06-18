package datastructures;

import java.util.*;

public class RandomSet {

    private Map<Integer, Integer> valueToIndex = new HashMap<>();
    private Map<Integer, Integer> indexToValue = new HashMap<>();

    public void insert(int n) {
        if (valueToIndex.containsKey(n)) {
            return;
        }

        int index = valueToIndex.size();
        valueToIndex.put(n, index);
        indexToValue.put(index, n);
    }

    public void remove(int n) {
        if (!valueToIndex.containsKey(n)) {
            return;
        }

        int index = valueToIndex.get(n);
        valueToIndex.remove(n);
        indexToValue.remove(index);
    }

    public int getRandom() {
        int size = valueToIndex.size();
        int randIndex = (int) (Math.random() * size);
        return indexToValue.get(randIndex);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
    }
}
