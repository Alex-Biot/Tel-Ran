package telran.data;

public class CustomLinkedList<E>  implements CustomList<E>{
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private static class Node<E>{
        E value;   //Integer
        Node next;
        Node prev;

        public Node(Node prev, Node next, E value) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    //{}, first = null, last = null;
    //{e1 (next = null, prev = null)}, first = e1, last = e1;
    //{e1 (next = e2, prev = null), e2 (next = null, prev = e1)} first = e1, last = e2;
    //(e1 (next = e2, prev = null), e2 (next = e3, prev = e1), e3(next = null, prev = e2) first1, last = e3;

    @Override
    public void add(E o) {
        if (size>0){
            Node newNode = new Node(last,null,o);
            last.next = newNode;
            last = newNode;
        }else{
            Node newNode = new Node (null, null, o);
            first = newNode;
            last = newNode;

        }
        size ++;
    }



    @Override
    public E get(int index) {
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }
        Node ret = getNode(index);
        return (E)ret.value;
    }

    private Node getNode(int index){
        Node res = first;
        for (int i = 0; i <index ; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public E removedByIndex(int index) {
        return null;
    }

    @Override
    public boolean remove(E o) {
        return false;
    }
}
