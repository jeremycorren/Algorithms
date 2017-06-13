import java.lang.*;

public class Autocomplete {
    private Term[] a;

    public Autocomplete(Term[] terms) {
        if(terms == null || !checkNull(terms))  
            throw new NullPointerException("Input array null or array items are null");
        this.a = terms;
        Merge.sort(a);
    }
    
    private static boolean checkNull(Term[] a) {
        for(int i = 0; i < a.length; i++)
            if(a[i] == null)
                return false;
        return true;
    }

    public Term[] allMatches(String prefix) {
        if(prefix == null)
            throw new NullPointerException("Prefix is null");
//        Term[] matches =                             
    }

    public int numberOfMatches(String prefix) {
        if(prefix == null)
            throw new NullPointerException("Prefix is null");
        int last = BinarySearch.lastIndexOf(a, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int first = BinarySearch.firstIndexOf(a, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        return last - first + 1;
    }

    public void print() {
        Sort.show(a);   
    }                   

    public static void main(String[] args) {
        Term[] arr = {new Term("david", 0), new Term("daniel", 0), new Term("dana", 0), new Term("dietrich", 0)};
        Autocomplete c = new Autocomplete(arr);       
        System.out.println(c.numberOfMatches("da"));
    }
}
