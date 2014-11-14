import java.util.*;

public class ArrayListMethods{
    public static void collapseDuplicates(ArrayList<Integer> L){
	    for (int i=0;i<L.size();i++){
	      while (i<L.size()-1 && L.get(i).equals(L.get(i+1))){
		      L.remove(i+1);
	      }
	    }
    }
    public static void randomize(ArrayList<Integer> L){
	Random rand = new Random();
	for (int i = L.size(); i>0; i--){
	    int x = rand.nextInt(i);
	    L.add(L.get(x));
	    L.remove(x);
	}
    }
    public static void main(String[]args){
	    ArrayList<Integer> x = new ArrayList<Integer>(){{
		    add(new Integer(1));
		    add(new Integer(2));
		    add(new Integer(2));
		    add(new Integer(3));
		    add(new Integer(4));
		    add(new Integer(4));
		    add(new Integer(4));
		    add(new Integer(4));
		    add(new Integer(3));
		    add(new Integer(3));
	    }};
	    System.out.println(x);
	    collapseDuplicates(x);
	    System.out.println(x);
	    ArrayList<Integer> y = new ArrayList<Integer>(){{
		add(new Integer(0));
		add(new Integer(1));
		add(new Integer(2));
		add(new Integer(3));
		add(new Integer(4));
		add(new Integer(5));
	    }};
	    System.out.println(y);
	    randomize(y);
	    System.out.println(y);
	    randomize(y);
	    System.out.println(y);
    }
}
