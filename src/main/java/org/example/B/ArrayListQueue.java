package org.example.B;

import java.util.ArrayList;

public class ArrayListQueue<T> {

    private ArrayList<T> queue;

    public ArrayListQueue() {
        this.queue = new ArrayList<>();
    }

    public void add(T elem) {
        queue.add(elem);
    }

    public T remove() { // removes and returns first elem from queue
        T first = queue.get(0);
        queue.remove(first);
        return first;
    }

    public T peek() { // only returns first elem from queue
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        Student a = new Student("Jan", "Kowalski", 21);
        Student b = new Student("Maciej", "Kawulski", 69);
        Student c = new Student("Krzysztof", "Ibisz", 128);
        Student d = new Student("Robert", "Kubica", 100000);
        Student e = new Student("Zbigniew", "Stonoga", 11);

        ArrayListQueue<Student> stack = new ArrayListQueue<>();
        stack.add(a);
        stack.add(b);
        stack.add(c);

        stack.remove();
        stack.remove();

        stack.add(d);
        stack.add(e);

        // printing
        while (!stack.isEmpty()) {
            Student pop = stack.remove();
            System.out.println(pop);
        }
    }
}
