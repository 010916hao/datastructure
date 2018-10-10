package dataStructure.ArrayStackQueue;

public interface Queue<E> {
    boolean isEmpty();
    int getSize();
    E remove();
    void add(E e);
    E getFront();
}
