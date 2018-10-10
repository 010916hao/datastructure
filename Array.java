package dataStructure;
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(E e, int index){
        if(index < 0 || index > size) throw new IllegalArgumentException("Error index.");
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
        if(size == getCapacity()) resize(2 * size);
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E remove(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index Error");
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size --;
        if(size < getCapacity() / 4) resize(getCapacity() / 2);
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void set(E e, int index) {
        data[index] = e;
    }

    public E get(int index){return data[index];}

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e) return true;
        }
        return false;
    }

    public Array<Integer> find(E e){
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < size; i++) {
            if(data[i] == e) arr.addLast(i);
        }
        return arr;
    }

    private void resize(int Capacity) {
        E[] newData = (E[])new Object[Capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Array: [");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    private void examine(){
        System.out.println(this);
        System.out.println(this.getSize());
        System.out.println(this.getCapacity());
        System.out.println(this.isEmpty());
    }

    public static void main(String[] args){
        Array<Integer> arr = new Array<>(10);
        arr.examine();
        for(int i = 0 ; i < 20 ; i ++){
            arr.addFirst(i);
        }
        arr.examine();
        System.out.println(arr.find(1));
        for(int i = 0 ; i < 20 ; i ++){
            arr.removeFirst();
        }
        arr.examine();
        System.out.println(arr.find(1));
    }



}
