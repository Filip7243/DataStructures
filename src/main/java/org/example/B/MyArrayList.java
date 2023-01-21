package org.example.B;

import java.util.ArrayList;

public class MyArrayList<T> {

    private ArrayList<T> list;

    public MyArrayList() {
        this.list = new ArrayList<>();
    }

    public void add(T elem) {
        list.add(elem);
    }

    public T removeLast() {
        return list.remove(list.size() - 1);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int find(T elem) {
        return list.indexOf(elem);
    }

    public int size() {
        return list.size();
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
        Student f = new Student("Grzegorz", "Braun", 70);

        MyArrayList<Student> list = new MyArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        list.print();

        list.removeLast();
        list.removeLast();
        System.out.println("*******");
        list.print();

        list.add(e);
        list.add(f);
        System.out.println("*******");
        list.print();

        System.out.println(list.get(3));
    }
}
