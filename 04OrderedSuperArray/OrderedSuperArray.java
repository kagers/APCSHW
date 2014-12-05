public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(int x){
	super(x);
    }
    public OrderedSuperArray(){
	super();
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
	    super.add(i,e);
	}
    }
    public void add(int index, String o){
	this.add(o);
    }
    public String set(int index, String e){
	add(e);
	return remove(index);
    }
    public int find(String target){
	int piv = (size()/2);
	int change = (size()/2);
	for (int i=0; i<=(Math.log(size())/Math.log(2))+1; i++){
	    if (get(piv).compareTo(target)>0){
		change/=2;
		piv-=change++;
	    }
	    else if (get(piv).compareTo(target)<0){
		change/=2;
		piv+=change++;
	    }
	    else {
		if (piv==0 || !((get(piv-1)).equals(target))){
		    return piv;
		}
		else {
		    for (int j=piv-1; j>0; j--){
			if (!get(j-1).equals(get(j))){
			    return j;
			}
		    }
		}
	    }
	}
	return -1;
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
	System.out.println(s.remove(1));
	System.out.println(s);
	System.out.println(s.set(1,"droid"));
	s.add("zman");
	s.add("mint");
	s.add("fillion");
	s.add("sleep");
	System.out.println(s);
	System.out.println(s.find("djdjd"));
	System.out.println(s.find("Radio"));
	System.out.println(s.find("bond"));
	System.out.println(s.find("bourgeoisie"));
	System.out.println(s.find("droid"));
	System.out.println(s.find("duran"));
	System.out.println(s.find("fillion"));
	System.out.println(s.find("mint"));
	System.out.println(s.find("paranoid"));
	System.out.println(s.find("sleep"));
	System.out.println(s.find("zman"));
    }
}
