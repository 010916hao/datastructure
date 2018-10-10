package dataStructure;

public class ArrayQueue<E> implements Queue<E>{

    private Array<E> arr;

    public ArrayQueue(){
        arr = new Array<>();
    }

    @Override
    public int getSize(){return arr.getSize();}

    @Override
    public boolean isEmpty(){return arr.getSize() == 0;}

    @Override
    public void add(E e){arr.addLast(e);}

    @Override
    public E remove(){return arr.removeFirst();}

    @Override
    public E getFront(){return arr.get(0);}
}
