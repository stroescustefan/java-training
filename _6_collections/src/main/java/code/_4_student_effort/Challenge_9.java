package code._4_student_effort;

import code._2_challenge._9_my_set.MySetImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Challenge_9 {
    public static void main(String[] args) {
        List<Integer> test = List.of(1, 1, 2, 1, 3, 2, 3, 4, 4);

        MySet<Integer> mySet = new MySetImp<>();
        for (Integer i : test) {
            mySet.add(i);
        }

        System.out.println(mySet);
    }
}

interface MySet<T> {
    void add(T e);

    void remove(T e);

    T get(int index);

    void set(int index, T e);

    int size();

    boolean contains(T e);
}

class MySetImp<T> implements MySet<T> {
    public ArrayList<T> mySet;

    public MySetImp() {
        mySet = new ArrayList<>();
    }

    @Override
    public void add(T e) {
        if (!mySet.contains(e)) {
            mySet.add(e);
        }
    }

    @Override
    public void remove(T e) {
        mySet.remove(e);
    }

    @Override
    public T get(int index) {
        return mySet.get(index);
    }

    @Override
    public void set(int index, T e) {
        if (!this.contains(e)) {
            mySet.set(index, e);
        }
    }

    @Override
    public int size() {
        return mySet.size();
    }

    @Override
    public boolean contains(T e) {
        return mySet.contains(e);
    }

    @Override
    public String toString() {
        return "Set: " + mySet ;
    }
}

