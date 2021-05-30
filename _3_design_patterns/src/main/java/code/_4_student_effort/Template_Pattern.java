package code._4_student_effort;

import java.util.Arrays;

public class Template_Pattern {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy01OfArr = Arrays.copyOf(arr, arr.length);
        Integer[] copy02OfArr = Arrays.copyOf(arr, arr.length);

        AscBubleSort asc = new AscBubleSort();
        asc.sort(copy01OfArr);
        DescBubleSort desc = new DescBubleSort();
        desc.sort(copy02OfArr);

        displaySorted(copy01OfArr);
        displaySorted(copy02OfArr);
    }

    public static void displaySorted(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

abstract class TemplateMethodBubleSort {
    void sort(Integer[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbersInCorrectOrder(arr[j], arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    abstract boolean numbersInCorrectOrder(Integer i1, Integer i2);
}

class AscBubleSort extends TemplateMethodBubleSort {
    @Override
    boolean numbersInCorrectOrder(Integer i1, Integer i2) {
        return i1.compareTo(i2) >= 0;
    }
}

class DescBubleSort extends TemplateMethodBubleSort {
    @Override
    boolean numbersInCorrectOrder(Integer i1, Integer i2) {
        return i1.compareTo(i2) <= 0;
    }
}
