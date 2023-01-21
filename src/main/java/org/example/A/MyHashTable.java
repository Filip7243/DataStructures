package org.example.A;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashTable {

    private LinkedList<Integer>[] hashArray;
    private int size;

    public MyHashTable(int size) {
        this.size = size;
        this.hashArray = new LinkedList[size];

        for(int i = 0; i < hashArray.length; i++) {
            hashArray[i] = new LinkedList<>();
        }
    }

    private int hash(int value) {
        return Math.abs(value % size);
    }

    public void insert(int elem) {
        int index = hash(elem);
        if(!hashArray[index].contains(elem)) {
            hashArray[index].addFirst(elem);
        }
    }

    public void delete(int elem) {
        int index = hash(elem);
        if(hashArray[index].contains(elem)) {
            hashArray[index].remove((Object) elem);
        }
    }

    public boolean find(int elem) {
        int index = hash(elem);
        return hashArray[index].contains(elem);
    }

    public int size() {
        return size;
    }

    public LinkedList<Integer> get(int index) {
        return hashArray[index];
    }

    public MyHashTableIterator iterator() {
        return new MyHashTableIterator(this);
    }

    public void print() {
        MyHashTableIterator iterator = iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(10);
        hashTable.insert(10);
        hashTable.insert(50);
        hashTable.insert(90);
        hashTable.insert(41);
        hashTable.insert(288);
        hashTable.insert(11);
        hashTable.insert(0);
        hashTable.insert(-621);
        hashTable.insert(10000);

        hashTable.delete(50);
        hashTable.delete(900);
        hashTable.delete(11);
        hashTable.delete(50);

        System.out.println(hashTable.find(-621));
        System.out.println(hashTable.find(99));

        System.out.println(hashTable.size());

        hashTable.print();
    }

}

class MyHashTableIterator {

    private MyHashTable hashTable;
    private int size; // size of hashTable
    private int lastIndex; // index of list that iterator points right now
    private Iterator<Integer> iterator; // iterator of current list

    public MyHashTableIterator(MyHashTable hashTable) {
        this.hashTable = hashTable;
        lastIndex = 0;
        size = hashTable.size();
        iterator = hashTable.get(0).iterator();
    }

    public boolean hasNext() {
        if(iterator.hasNext()) {
            return true;
        }

        int currentIndex = lastIndex;
        Iterator<Integer> currentListIterator;
        while (true) {
            currentIndex++;
            if(currentIndex == size) {
                return false; // we went threw whole HashTable, so we can't go to next iteration
            }
            currentListIterator = hashTable.get(currentIndex).iterator();
            if(currentListIterator.hasNext()) {
                return true;
            }
        }
    }

    public Object next() {
        if (!iterator.hasNext()) {
            while (!iterator.hasNext()) {
                lastIndex++;
                if (lastIndex == size) {
                    return null;
                }
                iterator = hashTable.get(lastIndex).iterator();
            }
        }
        return iterator.next();
    }
}
