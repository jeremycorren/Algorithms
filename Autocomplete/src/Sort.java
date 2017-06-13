import java.util.*;

public class Sort {
    public static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Object[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        System.out.println();
    }
}
