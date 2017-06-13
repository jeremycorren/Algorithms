import java.util.*;

public class Insertion extends Sort {
    public static void sort(Object[] a, Comparator comp) {
        int n = a.length;
        for(int i = 1; i < n; i++)
            for(int j = i; j > 0 && less(comp, a[j], a[j-1]); j--) 
                exch(a, j, j-1);
    }
}
