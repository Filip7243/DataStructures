package org.example.C;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 2, 8, 90, 420, 870, 900, 90, 87, -4, -9, 9, 0, 1};
        mergeSort(arr);
        print(arr);
    }

    private static void mergeSort(int[] arr) {
        int size = arr.length;

        if (arr.length < 2) {
            return; // stop the recursion, because arr contains only one elem
        }

        int mid = size / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[size - mid];

        // adding data from left side of array
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }
        // adding data from right side of array
        for (int i = mid; i < size; i++) {
            rightHalf[i - mid] = arr[i];
        }

        // recursion until we get only one elem in list
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // merging arrays
        merge(arr, leftHalf, rightHalf);
    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0; // iterator for leftHalf
        int j = 0; // iterator for rightHalf
        int k = 0; // iterator for arr

        // do until one of arrays (or both) out of index
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) { // checking which elem is lower, then adding lower
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++; // after adding to arr go to next index
        }

        // checking if some elements left in leftHalf or rightHalf arrays
        while (i < leftSize) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
