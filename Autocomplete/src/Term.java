import java.util.*;

public class Term implements Comparable<Term> {
    final private String query;
    final private long weight;    

    public Term(String query, long weight) {
        if(query == null)
            throw new NullPointerException("Query argument is null");
        if(weight < 0)
            throw new IllegalArgumentException("Weight argument is negative");
        this.query = query;
        this.weight = weight;
    }
    
    public static Comparator<Term> byReverseWeightOrder() {
        return new ByReverseWeightOrder();
    }

    private static class ByReverseWeightOrder implements Comparator<Term> {
        public int compare(Term v, Term w) { 
            Long a = v.weight;
            Long b = w.weight;
            return -a.compareTo(b);
        }
    }

    public static Comparator<Term> byPrefixOrder(int r) {
        if(r < 0)
            throw new IllegalArgumentException("Prefix argument is negative");
        return new ByPrefixOrder(r);
    }

    private static class ByPrefixOrder implements Comparator<Term> {
        private int r;     
   
        public ByPrefixOrder(int r) {
            this.r = r;   
        }
    
        public int compare(Term v, Term w) {
            String a = v.query.substring(0,r);
            String b = w.query.substring(0,r);
            return a.compareTo(b);    
        }
    }

    public int compareTo(Term that) {
        String v = this.query;
        String w = that.query;
        return v.compareTo(w);
    }

    public String toString() {
        return weight + "\t" + query;
    }

    public static void main(String[] args) {
        Term a = new Term("a", 1);
        Term b = new Term("b", 2);
        Term c = new Term("c", 3);
        Term d = new Term("d", 4);
        Term e = new Term("d", 4);
        Term f = new Term("d", 4);
        Term g = new Term("e", 5);        
 
        Term[] arr = {a, b, c, d, e, f, g};
    }
}
