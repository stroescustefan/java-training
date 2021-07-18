package code._4_student_effort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Challenge_8 {
    public static void main(String[] args) {
        MyArrayListImp<Integer> myList = new MyArrayListImp<>(Integer.class);

        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        myList.remove(1);
        System.out.println(myList);
        myList.remove(3);
        System.out.println(myList);
    }
}

interface MyArrayList<T> {
    void add(T e);
    void remove(T e);
    T get(int index);
    void set(int index, T e);
    int size();
}

class MyArrayListImp<T> implements MyArrayList<T> {
    public T[] array;
    public int maxSize;
    public int current;

    public MyArrayListImp(Class<T> clazz) {
        current = 0;
        maxSize = 2;
        array = (T[]) Array.newInstance(clazz, maxSize);
    }

    @Override
    public void add(T e) {
        if (current >= maxSize) {
            maxSize = maxSize * 2;
            array = Arrays.copyOf(array, maxSize);
        }

        array[current++] = e;
    }

    @Override
    public void remove(T e) {
        if (current > 0) {
            int saveIndex;

            saveIndex = -1;
            for (int i = 0; i < current; i++) {
                if (array[i].equals(e)) {
                    saveIndex = i;
                    break;
                }
            }

            if (saveIndex != -1) {
                int i = saveIndex;

                while (i < current - 1) {
                    array[i] = array[i + 1];
                    i++;
                }
                current--;
            }
        }
    }

    @Override
    public T get(int index) {
        if (index >=0 && index < current) {
            return array[index];
        }

        return null;
    }

    @Override
    public void set(int index, T e) {
        if (index >=0 && index < current) {
            array[index] = e;
        }
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Array: ");

        for (int i = 0; i < current; i++) {
            stringBuilder.append(array[i]).append(" ");
        }
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
}

