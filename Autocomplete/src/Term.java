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
            String a = "", b = "";
            if(v.query.length() < r)
                a = v.query;
            else
                a = v.query.substring(0, r);
 
            if(w.query.length() < r)
                b = w.query;
            else
                b = w.query.substring(0, r);
            return a.compareTo(b);    
        }
    }

    public int compareTo(Term that) {
        String v = this.query;
        String w = that.query;
        return v.compareTo(w);
    }

    public String toString() {
        return this.weight + "\t" + this.query;
    }
}
