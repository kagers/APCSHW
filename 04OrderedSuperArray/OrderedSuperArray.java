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
	    while ((i<size())&&(get(i).compareTo(e)<=0)){
		i++;
	    }
	    if (i==size()){
		super.add(e);
	    }
	    else {
		super.add(i,e);
	    }
	}
    }
    public void add(int index, String o){
	this.add(o);
    }
    public static void main(String[]args){
	OrderedSuperArray s = new OrderedSuperArray(10);
	s.add("bourgeoisie");
	System.out.println(s);
	s.add("android");
	System.out.println(s);
	s.add("paranoid");
	System.out.println(s);
	s.add("duran");
	System.out.println(s);
	s.add("bohr");
	System.out.println(s);
	s.add("bond");
	System.out.println(s);
	s.add("duran");
	System.out.println(s);
	s.add(26000,"Radio");
	System.out.println(s);
    }
}
