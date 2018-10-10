package dataStructure;

public class ArrayStack<E> implements Stack<E>{

    private Array<E> arr;

    public ArrayStack(){
        arr = new Array<>();
    }

    @Override
    public int getSize(){return arr.getSize();}

    @Override
    public boolean isEmpty(){return arr.getSize() == 0;}

    @Override
    public void push(E e){arr.addLast(e);}

    @Override
    public E pop(){return arr.removeLast();}

    @Override
    public E peek(){return arr.get(0);}


}
