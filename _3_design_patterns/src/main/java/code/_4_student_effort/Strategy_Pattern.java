package code._4_student_effort;

import java.util.Arrays;

public class Strategy_Pattern {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copyArr1 = Arrays.copyOf(arr, arr.length);
        Integer[] copyArr2 = Arrays.copyOf(arr, arr.length);

        displaySorted(new BubleSort(), copyArr1);
        displaySorted(new MergeSort(), copyArr2);
    }

    public static void displaySorted(SortingStrategy strategy, Integer[] arr) {
        strategy.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

interface SortingStrategy {

    void sort(Integer[] list);
}

class MergeSort implements SortingStrategy {

    public void sort(Integer[] list) {
        if (list.length < 2) {
            return;
        }
        int mid = list.length / 2;
        Integer[] left = Arrays.copyOfRange(list, 0, mid);
        Integer[] right = Arrays.copyOfRange(list, mid, list.length);

        sort(left);
        sort(right);
        merge(left, right, list);
    }

    private void merge(Integer[] left, Integer[] right, Integer[] merged) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                merged[listIndex++] = left[leftIndex++];
            } else {
                merged[listIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            merged[listIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            merged[listIndex++] = right[rightIndex++];
        }
    }
}

class BubleSort implements SortingStrategy {

    public void sort(Integer[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

