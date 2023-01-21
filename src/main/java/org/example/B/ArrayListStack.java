package org.example.B;

import java.util.ArrayList;

public class ArrayListStack {

    private ArrayList<Student> stack;

    public ArrayListStack() {
        this.stack = new ArrayList<>();
    }

    public void push(Student elem) {
        stack.add(elem);
    }

    public Student pop() {
        Student lastElem = stack.get(stack.size() - 1);
        stack.remove(lastElem);
        return lastElem;
    }

    public Student peek() {
        return stack.get(stack.size() - 1);
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

        ArrayListStack stack = new ArrayListStack();
        stack.push(a);
        stack.push(b);
        stack.push(c);

        stack.pop();
        stack.pop();

        stack.push(d);
        stack.push(e);

        while (!stack.isEmpty()) {
            Student pop = stack.pop();
            System.out.println(pop);
        }
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", age" + age;
    }
}
