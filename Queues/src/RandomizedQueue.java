import java.util.*;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<T> implements Iterable<T> {
    private T[] a;
    private int n;
    private int front;
    private int back;

    public RandomizedQueue() {
        a = (T[]) new Object[2];
        n = front = back = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(T item) {
        if(item == null)
            throw new NullPointerException("Null item");
        if(n == a.length)
            resize(2 * a.length);
        a[back++] = item;                       // add item and increment back
        if(back == a.length)                    // if back points to end
            back = 0;                           // wrap around
        n++;
    }

    public T dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow");
        int rand = StdRandom.uniform(n);
        T item = a[rand];                       // get random element
        a[rand] = a[n-1];                       // replace rand with back
        a[n-1] = null;                          // erase back
        back--;
        n--;
        if(front == a.length)                   // if front points to end, wrap
            front = 0;
        if(back == -1)                          // if back points to beg, wrap
            back = a.length-1;
        if(n > 0 && n == a.length/4)
            resize(a.length/2);
        return item;
    }

    public T sample() {
        if(isEmpty())
            throw new NoSuchElementException("empty queue");
        int rand = StdRandom.uniform(n);
        T item = a[rand];
        return item;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for(int i = 0; i < n; i++)
            temp[i] = a[(front + i) % a.length];
        a = temp;
        front = 0;
        back = n;
    }

    public Iterator<T> iterator() {
        resize(n);
        StdRandom.shuffle(a);
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }

        public T next() {
            if(current == null)
                throw new NoSuchElementException("No more items");
            T data = a[(i + front) % a.length];
            i++;
            return data;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        for(Integer i : q)
            System.out.print(i + " ");
        System.out.println();

        for(Integer i : q)
            System.out.print(i + " ");
        System.out.println();
    }
}
