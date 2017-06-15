import java.util.*;

public class BinarySearch {
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> c) {
        if(a == null || key == null || c == null)
            throw new NullPointerException("Argument is null");
        if(a.length == 0)
            return -1;
        if(c.compare(a[0], key) == 0)
            return 0;

        int result = -1;
        int lo = 0;                             
        int hi = a.length - 1;                  
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(c.compare(key, a[mid]) == 0) {
                result = mid;
                hi = mid - 1;
            } else if(c.compare(key, a[mid]) < 0)
                hi = mid - 1;                   
            else
                lo = mid + 1;                   
        }                                       
        return result;                  
    }

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> c) {
        if(a == null || key == null || c == null)
            throw new NullPointerException("Argument is null");           
        if(a.length == 0)
            return -1;
        if(c.compare(a[a.length - 1], key) == 0)
            return a.length - 1;
        
        int result = -1;
        int lo = 0;                             
        int hi = a.length - 1;                  
        while(lo <= hi) {                       
            int mid = lo + (hi - lo) / 2;       
            if(c.compare(key, a[mid]) == 0) {
                result = mid;
                lo = mid + 1;
            } else if(c.compare(key, a[mid]) < 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }                                       
        return result;                              
    }
}
