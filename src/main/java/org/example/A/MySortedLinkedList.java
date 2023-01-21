package org.example.A;

public class MySortedLinkedList {

    private ListElem first;
    private ListElem last;

    public MySortedLinkedList() {
        this.first = null;
        this.last = null;
    }

    public void insert(int value) {
        ListElem newElem = new ListElem(value);

        if (isEmpty()) {
            first = newElem;
            first.next = last;
        } else {
            ListElem current = first;
            while (current != null && current.value < newElem.value) {
                current = current.next; // looking for place to insert new data
            }

            if (current == null) { // elem goes to last position
//                System.out.println("ELEMENT POWINIEN IŚĆ NA OSTATNIĄ POZYCJE " + value);
                if(last == null) { // it means that only one elem in list
                    last = newElem;
                    first.next = last;
                    last.previous = first;
                } else {
                    last.next = newElem;
                    newElem.previous = last;
                    newElem.next = null;
                    last = newElem;
                }
            } else if(current.previous == null) { // elem goes to first position
                if(first.next == null) { // it means it's only one elem in list
                    last = first;
                }
                current.previous = newElem;
                newElem.next = current;
                first = newElem;
            } else {
                current.previous.next = newElem;
                newElem.previous = current.previous;
                newElem.next = current;
                current.previous = newElem;
            }
        }
    }

    public ListElem delete(int value) {
        ListElem elemToRemove = find(value);
        if (elemToRemove != null) {
            if (isFirst(elemToRemove)) {
                if(elemToRemove.next == null) { // it's only element on list
                    first = null;
                    last = null;
                } else {
                    elemToRemove.next.previous = null;
                    first = elemToRemove.next;
                }
            } else if (isLast(elemToRemove)) {
                elemToRemove.previous.next = null;
                last = elemToRemove;
            } else { // element is surrounded by other elems
                elemToRemove.next.previous = elemToRemove.previous;
                elemToRemove.previous.next = elemToRemove.next;
            }
        }
        return elemToRemove;
    }

    private boolean isFirst(ListElem elem) {
        return elem.previous == null;
    }

    private boolean isLast(ListElem elem) {
        return elem.next == null;
    }

    public ListElem find(int value) {
        if (isEmpty()) {
            return null;
        }

        ListElem current = first;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("List is empty");
        }
        ListElem current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySortedLinkedList l = new MySortedLinkedList();
        l.insert(20);
        l.insert(18);
        l.insert(90);
        l.insert(42);
        l.insert(11);
        l.insert(28);

        l.print();
//
        System.out.println(l.delete(999));
        l.delete(11);
        l.delete(20);
//        l.delete(18);
//        l.delete(42);
//        l.delete(90);
//        l.delete(28);
////
        l.print();
//
        System.out.println(l.find(90));
//
        System.out.println(l.isEmpty());

        l.insert(18);
        l.print();
        l.insert(41);
        l.print();
        l.insert(942);
        l.insert(813);
        l.print();
    }
}

