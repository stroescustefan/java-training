package code._4_student_effort;

import java.util.Iterator;
import java.util.Objects;

public class Challenge_3 {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        System.out.println(myList.isEmpty());
        myList.insertEnd(5);
        myList.insertEnd(4);
        myList.insertEnd(5);
        myList.insertEnd(2);
        System.out.println(myList);
    }
}

interface IGenericList<T> {
    int size();
    boolean isEmpty();
    void insertStart(T value);
    void insertEnd(T value);
    void insert(T value, int index);
    boolean removeFirst();
    boolean removeLast();
    boolean remove(T elem);
    boolean remove(int index);
    void reverse();
    Iterator<T> iterator();
}

interface IGenericNode<T> {
    T getValue();
    void setValue(T value);
    IGenericNode<T> getNext();
    void setNext(IGenericNode<T> next);
}

class MyLinkedList<T> implements Iterable<T>, IGenericList<T> {
    private Node<T> head;
    private int count;

    public MyLinkedList() {
        head = null;
        count = 0;
    }


    public static class Node<T> implements IGenericNode<T> {
        private T value;
        private Node<T> next;

        public Node() {
            this(null);
        }

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node with value: " + value + ".\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(IGenericNode<T> next) {
            this.next = (Node<T>) next;
        }
    }


    static class MyListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public MyListIterator(MyLinkedList<T> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<>(this);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void insertStart(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public void insertEnd(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> i = head;
            while (i.next != null) {
                i = i.next;
            }

            i.next = newNode;
        }
        count++;
    }

    public void insert(T value, int index) {
        if (head == null) {
            insertStart(value);
        } else {
            if (index <= 0) {
                insertStart(value);
            } else if (index >= count) {
                insertEnd(value);
            } else {
                Node<T> newNode = new Node<>(value);
                Node<T> p = head;
                int cnt = 0;

                while (p != null) {
                    if (cnt == index - 1) {
                        break;
                    }
                    cnt++;
                    p = p.next;
                }

                newNode.next = p.next;
                p.next = newNode;
                count++;
            }
        }
    }

    public boolean removeFirst() {
        if (head == null) {
            return false;
        } else {
            head = head.next;
            count--;
            return true;
        }
    }

    public boolean removeLast() {
        if (head == null) {
            return false;
        } else {
            if (count == 1) {
                head = head.next;
            } else {
                Node<T> aux;

                aux = head;
                while (aux.next.next != null) {
                    aux = aux.next;
                }

                aux.next = null;
            }

            count--;
            return true;
        }
    }

    public boolean remove(T elem) {
        if (head != null) {
            if (head.value == elem) {
                removeFirst();
            } else {
                Node<T> aux;

                aux = head;
                while (aux.next != null && aux.next.value != elem) {
                    aux = aux.next;
                }

                if (aux.next != null) {
                    aux.next = aux.next.next;
                    count--;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean remove(int index) {
        if (index <= 0) {
            removeFirst();
        } else if (index >= count) {
            removeLast();
        } else {
            Node<T> p = head;
            int cnt = 0;

            while (p != null) {
                if (cnt == index - 1) {
                    break;
                }
                cnt++;
                p = p.next;
            }

            p.next = p.next.next;
            count--;
            return true;
        }

        return false;
    }


    public void reverse() {
        Node<T> current, prev, urm;

        if (head != null) {
            prev = null;
            current = head;
            urm = head.next;

            while (urm != null) {
                current.next = prev;
                prev = current;
                current = urm;
                urm = urm.next;
            }

            current.next = prev;
            head = current;
        }
    }

    @Override
    public String toString() {
        Node<T> i;
        StringBuilder str = new StringBuilder();

        if (!isEmpty()) {
            i = head;
            str.append("List: ");
            while (i != null) {
                str.append(i.value).append(" ");
                i = i.next;
            }
            str.append(".");
        } else {
            str.append("Emply List.");
        }

        return str.toString();
    }
}
