package org.example.B;

import java.util.Iterator;
import java.util.TreeSet;

public class SetWithTreeSet<T> {

    private TreeSet<T> set;

    public SetWithTreeSet() {
        this.set = new TreeSet<>();
    }

    public void add(T elem) { // adding elem if not exists yet
        set.add(elem);
    }

    public boolean contains(T elem) { // check if set contains elem
        return set.contains(elem);
    }

    public boolean delete(T elem) { // removes elem if exists
        return set.remove(elem);
    }

    public SetWithTreeSet<T> union(SetWithTreeSet<T> secondSet) { // sum of two sets
        SetWithTreeSet<T> result = new SetWithTreeSet<>();
        // iterator for THIS set

        // iterate threw THIS set
        for (T value : set) {
            result.add(value);
        }

        // iterate threw second set
        for (T t : secondSet.getSet()) {
            result.add(t);
        }

        return result;
    }

    public SetWithTreeSet<T> intersection(SetWithTreeSet<T> secondSet) { // returns part of the common of those two sets
        SetWithTreeSet<T> result = new SetWithTreeSet<>();
        for (T elem : set) { // iterate threw THIS set
            if (secondSet.contains(elem)) {
                result.add(elem);
            }
        }

        return result;
    }

    public SetWithTreeSet<T> difference(SetWithTreeSet<T> secondSet) {
        SetWithTreeSet<T> result = new SetWithTreeSet<>();
        for (T elem : set) {
            if(!secondSet.contains(elem)) {
                result.add(elem);
            }
        }

        return result;
    }

    public int size() {
        return set.size();
    }

    public TreeSet<T> getSet() {
        return set;
    }

    public void print() {
        for (T elem : set) {
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {
        Student a = new Student("Jan", "Kowalski", 21);
        Student b = new Student("Maciej", "Kawulski", 69);
        Student c = new Student("Krzysztof", "Ibisz", 128);
        Student d = new Student("Robert", "Kubica", 100000);
        Student e = new Student("Zbigniew", "Stonoga", 11);

        SetWithTreeSet<Student> setA = new SetWithTreeSet<>();
        SetWithTreeSet<Student> setB = new SetWithTreeSet<>();

        setA.add(a);
        setA.add(b);
        setA.add(c);
        setA.add(d);

        setB.add(c);
        setB.add(d);
        setB.add(e);

        SetWithTreeSet<Student> intersection = setA.intersection(setB);
        intersection.print(); // Krzysiek Robert
        System.out.println("*************************");
        SetWithTreeSet<Student> union = setA.union(setB);
        union.print(); // wszystko (bez duplikatów)
        System.out.println("*************************");
        SetWithTreeSet<Student> difference = setA.difference(setB);
        difference.print(); // a, d
        System.out.println("*************************");

        setA.delete(c);
        setB.delete(e);

        SetWithTreeSet<Student> intersection1 = setA.intersection(setB);
        intersection1.print(); // d
        System.out.println("*************************");
        SetWithTreeSet<Student> union1 = setA.union(setB);
        union1.print(); // a,b,c,d
        System.out.println("*************************");
        SetWithTreeSet<Student> difference1 = setA.difference(setB);
        difference1.print(); // a, b
    }


}
