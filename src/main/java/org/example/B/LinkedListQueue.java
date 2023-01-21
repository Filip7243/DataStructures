package org.example.B;

import java.util.LinkedList;

public class LinkedListQueue<T> {

    private LinkedList<T> queue;

    public LinkedListQueue() {
        this.queue = new LinkedList<>();
    }

    public void add(T elem) {
        queue.addLast(elem);
    }

    public T remove() {
        return queue.removeFirst();
    }

    public T peek() {
        return queue.peek();
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

        LinkedListQueue<Student> stack = new LinkedListQueue<>();
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
