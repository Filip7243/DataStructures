package org.example.B;

import java.util.LinkedList;

public class MyLinkedList<T> {

    private LinkedList<T> list;

    public MyLinkedList() {
        this.list = new LinkedList<>();
    }

    public void addFirst(T elem) {
        list.addFirst(elem);
    }

    public void addLast(T elem) {
        list.addLast(elem);
    }

    public T deleteFirst() {
        return list.removeFirst();
    }

    public T deleteLast() {
        return list.removeLast();
    }

    public T getFirst() {
        return list.getFirst();
    }

    public T getLast() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void print() {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        Student a = new Student("Jan", "Kowalski", 21);
        Student b = new Student("Maciej", "Kawulski", 69);
        Student c = new Student("Krzysztof", "Ibisz", 128);
        Student d = new Student("Robert", "Kubica", 100000);
        Student e = new Student("Zbigniew", "Stonoga", 11);

        MyLinkedList<Student> l = new MyLinkedList<>();
        l.addFirst(a);
        l.addFirst(b);
        l.addFirst(c);

        l.print();

        l.addLast(d);
        l.addLast(e);

        System.out.println("******");
        l.print();

        l.deleteFirst();
        l.deleteLast();

        System.out.println("*****");
        l.print();
        System.out.println("*****");

//        while (!l.isEmpty()) {
//            if(l.getFirst().equals(e)) {
//                System.out.println(e);
//                break;
//            }
//            l.deleteFirst();
//        }

        while (!l.isEmpty()) {
            if(l.getFirst().equals(b)) {
                System.out.println(b);
                break;
            }
            l.deleteFirst();
        }
    }
}
