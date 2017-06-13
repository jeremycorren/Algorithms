import java.lang.*;
import java.util.*;

public class Deque<T> implements Iterable<T> {
    private Node front;
    private Node back;
    private int n;

    private class Node {
        T item;
        Node next;
        Node prev;
    }

    public Deque() {
        front = back = null;
        n = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return n;
    }

    public void addFirst(T item) {
        if(item == null)
            throw new NullPointerException("Null item");
        Node old = front;
        front = new Node();
        front.item = item;
        front.next = old;
        front.prev = null;
        if(old != null)
            old.prev = front;
        else
            back = front;
        n++;
    }

    public void addLast(T item) {
        if(item == null)
            throw new NullPointerException("Null item");
        Node old = back;
        back = new Node();
        back.item = item;
        back.next = null;
        back.prev = old;
        if(old != null)
            old.next = back;
        else
            front = back;
        n++;
    }

    public T removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException("Empty queue");
        T item = front.item;
        front = front.next;
        if(front != null)
            front.prev = null;
        else
            back = front;
        n--;
        return item;
    }

    public T removeLast() {
        if(isEmpty())
            throw new NoSuchElementException("Empty queue");
        T item = back.item;
        back = back.prev;
        if(back != null)
            back.next = null;
        else
            front = back;
        n--;
        return item;
    }

    public void delete(int k) {
        int i = 0;
        for(Node x = front; x != null; x = x.next) {
            if(i == k) {
                if(x == front) {
                    removeFirst();
                } else if(x == back) {
                    removeLast();
                } else {
                    x.next.prev = x.prev;
                    x.prev.next = x.next;
                }
                n--;
                break;
            }
            i++;
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if(current == null)
                throw new NoSuchElementException("No more items");
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFirst("and");
        d.addLast("seven");
        d.addFirst("score");
        d.addLast("years");
        d.addFirst("four");
        d.addLast("ago");
        for(String s : d)
            System.out.print(s + " ");
        System.out.println("\nsize: " + d.size());
        System.out.println("isEmpty: " + d.isEmpty());

        d.delete(5);
        for(String s : d)
            System.out.print(s + " ");
        System.out.println();
    }
}
