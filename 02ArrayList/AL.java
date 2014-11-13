import java.util.*;

public class AL{
    public static void collapseDuplicates(ArrayList<Integer> L){
	    for (int i=0;i<L.size();i++){
	      while (i<L.size()-1 && L.get(i)==L.get(i+1)){
		      L.remove(i+1);
	      }
	    }
    }
    public static void main(String[]args){
	    ArrayList<Integer> x = new ArrayList<Integer>(){{
		    add(1);
	    	add(2);
		    add(2);
		    add(3);
		    add(4);
		    add(4);
		    add(4);
		    add(4);
		    add(3);
	    	add(3);
	    }};
	    System.out.println(x);
	    collapseDuplicates(x);
	    System.out.println(x);
    }
}
