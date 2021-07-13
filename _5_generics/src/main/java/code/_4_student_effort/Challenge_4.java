package code._4_student_effort;

public class Challenge_4 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3};
        IArrayIterator<Integer> it = new ArrayIterator<>(arr);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}


interface IArrayIterator<T> {
    boolean hasNext();
    T next();
}

class ArrayIterator<T> implements IArrayIterator<T> {
    private T[] arr;
    private int cnt;

    public ArrayIterator(T[] arr) {
        this.arr = arr;
        cnt = 0;
    }

    @Override
    public boolean hasNext() {
        if (cnt < arr.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        return arr[cnt++];
    }
}