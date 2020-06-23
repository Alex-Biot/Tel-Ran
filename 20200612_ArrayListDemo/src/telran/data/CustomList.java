package telran.data;

public interface CustomList<E> {
    //add element;
    //delete element;
    //update, search;

    int size();
    void add(E o);
    E get (int index);
    E removeByIndex(int index);
    boolean removeByDate(E o);
    boolean remove(E o);
}
