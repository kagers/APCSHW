public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(int x){
	super(x);
    }
    public void add(String e){
	if (size()==0){
	    super.add(e);
	}
	else {
	    int i=0;
	    while ((i<size())||(get(i).compareTo(e)<=0)){
		i++;
	    }
	    super.add(i,e);
	}
    }
    public static void main(String[]args){
	OrderedSuperArray s = new OrderedSuperArray(10);
	s.add("a");
	System.out.println(s);
	s.add("b");
	System.out.println(s);
    }
}