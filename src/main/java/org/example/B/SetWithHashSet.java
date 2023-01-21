package org.example.B;

import java.util.HashSet;

public class SetWithHashSet<T> {

    private HashSet<T> hashSet;

    public SetWithHashSet() {
        this.hashSet = new HashSet<>();
    }

    public void add(T elem) {
        hashSet.add(elem);
    }

    public boolean contains(T elem) {
        return hashSet.contains(elem);
    }

    public boolean delete(T elem) {
        return hashSet.remove(elem);
    }

    public SetWithHashSet<T> union(SetWithHashSet<T> secondSet) {
        SetWithHashSet<T> result = new SetWithHashSet<>();
        for (T elem : hashSet) {
            result.add(elem);
        }

        for (T elem : secondSet.getSet()) {
            result.add(elem);
        }

        return result;
    }

    public SetWithHashSet<T> intersection(SetWithHashSet<T> secondSet) {
        SetWithHashSet<T> result = new SetWithHashSet<>();
        for (T elem : hashSet) {
            if (secondSet.contains(elem)) {
                result.add(elem);
            }
        }

        return result;
    }

    public SetWithHashSet<T> difference(SetWithHashSet<T> secondSet) {
        SetWithHashSet<T> result = new SetWithHashSet<>();
        for (T elem : hashSet) {
            if (!secondSet.contains(elem)) {
                result.add(elem);
            }
        }

        return result;
    }

    public int size() {
        return hashSet.size();
    }

    public HashSet<T> getSet() {
        return hashSet;
    }

    public void print() {
        for (T t : hashSet) {
            System.out.println(t);
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
        difference.print(); // a, b
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
