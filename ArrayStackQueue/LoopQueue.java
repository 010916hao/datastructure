package dataStructure.ArrayStackQueue;

public class LoopQueue<E> implements Queue<E> {

    private int head, tail;
    private E[] data;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize(){return size;}

    @Override
    public boolean isEmpty(){return size == 0;}

    private int getCapaity(){return data.length;}

    @Override
    public void add(E e){
        if((tail + 1) % data.length == head) resize(2*data.length);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;

    }

    @Override
    public E remove(){
        E ret = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if(data.length / size == 4 && data.length / 2 != 0) resize(data.length / 2);
        return ret;
    }

    @Override
    public E getFront(){return data[head];}

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++ ){
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue: [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + head) % data.length]);
            if(i != size - 1) res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    private void examine(){
        System.out.println(this);
        System.out.println("Capacity: " + this.getCapaity());
        System.out.println("Size: " + this.size);
        System.out.println("isEmpty: " + this.isEmpty());
        System.out.println("queueFront: " + this.getFront());
    }


    public static void main(String[] args){
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.add(i);
        }
        loopQueue.examine();
        for(int i = 0 ; i < 5; i ++){
            loopQueue.remove();
        }
        loopQueue.examine();
    }


}


