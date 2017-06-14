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

        int num = numberOfMatches(prefix);
        Term[] matches = new Term[num];
        int first = first(a, prefix);
        int last = last(a, prefix);

        for(int i = first, k = 0; i <= last; i++, k++)
            matches[k] = a[i];
        Merge.sort(matches, Term.byReverseWeightOrder());            
        return matches;
    }

    public int numberOfMatches(String prefix) {
        if(prefix == null)
            throw new NullPointerException("Prefix is null");

        int first = first(a, prefix);
        int last = last(a, prefix);
        return last - first + 1;
    }

    private int first(Term[] a, String prefix) {
        return BinarySearch.firstIndexOf(a, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    }

    private int last(Term[] a, String prefix) {
        return BinarySearch.lastIndexOf(a, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    } 

    public void print() {
        Sort.show(a);   
    }                   

    public static void main(String[] args) {
        Term[] arr = {new Term("david", 3), new Term("daniel", 1), new Term("dana", 2), new Term("eric", 0), new Term("haley", 0)};
        Autocomplete c = new Autocomplete(arr);       
        c.print();
        Term[] m = c.allMatches("da");
        for(int i = 0; i < m.length; i++)
            System.out.println(m[i]);
    }
}
