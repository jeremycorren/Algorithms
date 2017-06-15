import java.util.*;

public class Merge extends Sort {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid)                     a[k] = aux[j++];
            else if(j > hi)                 a[k] = aux[i++];
            else if(less(aux[j], aux[i]))   a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    private static void merge(Object[] a, Object[] aux, int lo, int mid, int hi, Comparator c) {
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid)                         a[k] = aux[j++];
            else if(j > hi)                     a[k] = aux[i++];
            else if(less(aux[j], aux[i], c))    a[k] = aux[j++];
            else                                a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for(int len = 1; len < n; len *= 2) {
            for(int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    public static void sort(Object[] a, Comparator c) {
        int n = a.length;
        Object[] aux = new Object[n];
        for(int len = 1; len < n; len *= 2) {
            for(int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(a, aux, lo, mid, hi, c);   
            }
        }
    }
}
