import java.util.*;

public class BinarySearch {
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> c) {
        if(a == null || key == null || c == null)
            throw new NullPointerException("Argument is null");
        int res = -1;
        int lo = 0;                             
        int hi = a.length - 1;                  
        while(lo <= hi) {                       
            int mid = lo + (hi - lo) / 2;       
            if(c.compare(key, a[mid]) < 0)       
                hi = mid - 1;                   
            else if(c.compare(key, a[mid]) > 0)   
                lo = mid + 1;                   
            else {
                res = mid;
                hi = mid - 1;       
            }                                
        }                                       
        return res;                  
    }

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> c) {
        if(a == null || key == null || c == null)
            throw new NullPointerException("Argument is null");           
        int res = -1;
        int lo = 0;                             
        int hi = a.length - 1;                  
        while(lo <= hi) {                       
            int mid = lo + (hi - lo) / 2;       
            if(c.compare(key, a[mid]) < 0)       
                hi = mid - 1;                   
            else if(c.compare(key, a[mid]) > 0)   
                lo = mid + 1;                   
            else {
                res = mid;
                lo = mid + 1;
            }                               
        }                                       
        return res;                              
    }

    public static void main(String[] args) {
         
    }
}
