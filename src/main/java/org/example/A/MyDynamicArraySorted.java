package org.example.A;

public class MyDynamicArraySorted {

    public Student[] arr;
    public int numberOfElements;

    public MyDynamicArraySorted(int size) {
        this.arr = new Student[size];
        numberOfElements = 0;
    }

    public void add(Student value) {
        if (numberOfElements >= arr.length) {
            Student[] temp = new Student[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }

        int i; // index
        for (i = 0; i < numberOfElements; i++) {
            if (arr[i].compareTo(value) > 0) { // it means arr[i] is greater than value
                break;
            }
        }

        // move greater elements than this one we're adding to right
        for (int j = numberOfElements; j > i; j--) {
            arr[j] = arr[j - 1];
        }

        arr[i] = value; // adding value
        numberOfElements++;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public Student get(int index) {
        return arr[index];
    }

    public boolean remove(int index) {
        if (isEmpty() || index < 0 || index >= numberOfElements) {
            return false;
        }

        for (int i = index; i < numberOfElements - 1; i++) {
            arr[i] = arr[i + 1];
        }
        numberOfElements--;
        return true;
    }

    public int find(Student value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(value) == 0 && arr[i].getAlbumId() == value.getAlbumId()) {
                return i;
            }
        }
        return -1;
    }

    public int find2(Student value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getFirstName().equals(value.getFirstName()) &&
            arr[i].getLastName().equals(value.getLastName()) &&
            arr[i].getAge() == value.getAge() && arr[i].getAlbumId() == value.getAlbumId()) {
                return i;
            }
        }

        return -1;
    }

    public int size() {
        return numberOfElements;
    }

    public void print() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MyDynamicArraySorted arr = new MyDynamicArraySorted(5);
        arr.add(new Student("Zofia", "Nowak", 120, 1));
        arr.add(new Student("Krystyna", "Nowak", 120, 1));
        arr.add(new Student("Jagoda", "Nowak", 120, 1));
        arr.add(new Student("Eugenia", "Nowak", 120, 1));
        arr.add(new Student("Anna", "Nowak", 120, 1));

        arr.print();

        System.out.println("***********");
        arr.add(new Student("Anna", "Zntnowicz", 120, 1));
        arr.print();

        System.out.println(arr.get(3));
        System.out.println(arr.remove(3));
        arr.print();
        System.out.println("**************");
        System.out.println(arr.find(new Student("Anna", "Nowak", 120, 1)));
        System.out.println(arr.size());
    }
}
