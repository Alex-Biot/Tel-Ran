package telran.data;

public class CustomArrayList<E> implements CustomList<E>{

    private Object[] source;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private boolean check;

    public CustomArrayList(){
        source = new  Object[DEFAULT_CAPACITY];
        size = 0;
        check = false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E o) {
        if(size==source.length) {
            Object[] newSource = new Object[size + DEFAULT_CAPACITY];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }

        source[size++] = o;

        //size++;


    }

    @Override
    public E get(int index) {       //index =-1, index = 125; size = 20
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        return (E)source[index];
    }

    @Override
    public E removedByIndex(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Object o = (E)source[index];
        System.arraycopy(source, index +1, source, index, size-index-1);
        size--;
        return (E)o;
    }

    // {1,2,3,4,5,6}  -> index = 3


    @Override
    public boolean removeByDate(E o) {

        for (int i = 0; i < source.length; i++) {
            if (o==source[i]) {
                System.arraycopy(source, i +1, source, i, size-i-1);
                size--;
                check=true;
            }
        }

        return check;
    }
}
