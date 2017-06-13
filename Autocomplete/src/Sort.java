import java.util.*;

public class Sort {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        System.out.println();
    }
}
