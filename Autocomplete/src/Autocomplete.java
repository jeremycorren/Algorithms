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
         
    }

/*
    public int numberOfMatches(String prefix) {
        if(prefix == null)
            throw new NullPointerException("Prefix is null");
    }
*/
    public void print() {
        Sort.show(a);   
    }                   

    public static void main(String[] args) {
        Term[] arr = {new Term("d", 0), new Term("a", 0), new Term("c", 0), new Term("b", 0)};
        Autocomplete a = new Autocomplete(arr);       
        a.print(); 
    }

}
