package org.example.A;

public class MyDynamicArray {

    private Student[] arr;
    private int numberOfElements;

    public MyDynamicArray(int size) {
        this.arr = new Student[size];
        numberOfElements = 0; // initial number of elems in array (array is empty)
    }

    public void add(Student value) {
        if (numberOfElements >= arr.length) {
            Student[] temp = new Student[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[numberOfElements] = value;
        numberOfElements++;
    }

    public Student get(int index) {
        return arr[index];
    }

    public int size() {
        return numberOfElements;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean remove(int index) {
        // check if array empty or index is out of bound or bad index
        if (isEmpty() || index >= numberOfElements || index < 0) {
            return false;
        }
        // every element after removing element goes to left
        for (int i = index; i < numberOfElements - 1; i++) {
            arr[i] = arr[i + 1];
        }
        numberOfElements--;
        return true;
    }

    // returns index of searching object, checking if objects points on the same place in memory
    public int find(Student value) {
        for (int i = 0; i < numberOfElements; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // returns index of searching object, checking if objects fields are the same
    public int find2(Student value) {
        for (int i = 0; i < numberOfElements; i++) {
            if (arr[i].getFirstName().equals(value.getFirstName())
                    && arr[i].getLastName().equals(value.getLastName())
                    && arr[i].getAlbumId() == value.getAlbumId()) {
                return i;
            }
        }

        return -1;
    }

    public void print() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MyDynamicArray students = new MyDynamicArray(10);
        students.add(new Student("Adam", "Nawałka", 400200));
        students.add(new Student("Kasia", "Mroczek", 642001));
        students.add(new Student("Mike", "Doe", 320918));
        students.add(new Student("John", "Iniesta", 320919));
        Student value = new Student("Leo", "Messi", 120210);
        students.add(value);

        students.print();
        students.remove(0);
        System.out.println(students.remove(16));
        System.out.println(students.remove(-10));
        System.out.println(students.size());
        students.print();
        System.out.println("******");
        System.out.println(students.get(3));
        System.out.println(students.find(new Student("Adam", "Nawałka", 400200))); // should be -1
        System.out.println(students.find2(new Student("Kasia", "Mroczek", 642001))); // should return index
        System.out.println(students.find(value)); // should return index
        System.out.println(students.find2(value)); // should return index
    }

}

class Student {

    private String firstName;
    private String lastName;
    private int albumId;

    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.albumId = 0;
    }

    public Student(String firstName, String lastName, int albumId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.albumId = albumId;
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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", Album: " + albumId;
    }
}
