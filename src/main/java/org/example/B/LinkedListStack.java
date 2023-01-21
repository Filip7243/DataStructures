package org.example.B;

import java.util.LinkedList;

public class LinkedListStack<T> {

    private LinkedList<T> stack;

    public LinkedListStack() {
        this.stack = new LinkedList<>();
    }

    public void push(T value) {
        stack.push(value);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Student a = new Student("Jan", "Kowalski", 21);
        Student b = new Student("Maciej", "Kawulski", 69);
        Student c = new Student("Krzysztof", "Ibisz", 128);
        Student d = new Student("Robert", "Kubica", 100000);
        Student e = new Student("Zbigniew", "Stonoga", 11);

        LinkedListStack<Student> stack = new LinkedListStack<>();
        stack.push(a);
        stack.push(b);
        stack.push(c);

        stack.pop();
        stack.pop();

        stack.push(d);
        stack.push(e);

        // printing
        while (!stack.isEmpty()) {
            Student pop = stack.pop();
            System.out.println(pop);
        }
    }
}
