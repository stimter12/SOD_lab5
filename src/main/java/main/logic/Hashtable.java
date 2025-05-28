package main.logic;

import java.util.LinkedList;

public class Hashtable {
    private LinkedList<String>[] table;
    private int size;
    private int capacity;
    private static final double LOAD_FACTOR_THRESHOLD = 0.5;

    @SuppressWarnings("unchecked")
    public Hashtable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        size = 0;

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(String key) {
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<String>[] newTable = new LinkedList[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<String> bucket : table) {
            for (String key : bucket) {
                int newIndex = Math.abs(key.hashCode()) % newCapacity;
                newTable[newIndex].add(key);
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void delete(String key) {
        int index = hash(key);
        if (table[index].remove(key)) {
            size--;
        }
    }

    public boolean find(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String display() {
        String res="";
        for (int i = 0; i < capacity; i++) {
            res+=i + " -> " + table[i]+"\n";
        }
        return res;
    }
}
