package org.example.A;

public class MyLinkedList {

    private ListElem first;
    private ListElem last;

    public MyLinkedList() {
        // empty structure
        this.first = null;
        this.last = null;
    }

    public void insertFirst(int value) {
        ListElem newElem = new ListElem(value);
        if (isEmpty()) {
            last = newElem;
        } else {
            first.previous = newElem;
        }

        newElem.next = first;
        first = newElem;
    }

    public void insertLast(int value) {
        ListElem newElem = new ListElem(value);
        if (isEmpty()) {
            first = newElem;
        } else {
            last.next = newElem;
            newElem.previous = last;
        }

        last = newElem;
    }

    public ListElem deleteFirst() {
        if (isEmpty()) {
            return null;
        }

        ListElem temp = first;
        if (first.next == null) { // list contains only one elem
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;

        return temp;
    }

    public ListElem deleteLast() {
        if (isEmpty()) {
            return null;
        }

        ListElem temp = last;
        if (first.next == null) { // list contains only one elem
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;

        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        System.out.print("Lista: ");
        ListElem current = first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.insertFirst(22);
        l.insertFirst(44);
        l.insertFirst(66);

        l.insertLast(22);
        l.insertLast(38);
        l.insertLast(55);

        l.print();

        l.deleteFirst();

        l.print();

        l.deleteLast();
        l.print();

    }
}

class ListElem {

    protected ListElem previous;
    protected ListElem next;
    protected int value;

    public ListElem(int value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
