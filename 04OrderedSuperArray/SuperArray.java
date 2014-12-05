import java.util.*;

public class SuperArray{
    private String[] arr;
    private int len;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int x){
	arr = new String[x];
	len = 0;
    }
    public String toString(){
	String ret="[ ";
	for (int i=0;i<len;i++){
	    ret+=arr[i]+" ";
	}
	return ret+"]";
    }
    public void add(String e){
	if (size()!=arr.length){
	    arr[size()]=e;
	    len++;
	}else{
	    resize(arr.length+1);
	    arr[size()]=e;
	    len++;
	}
    }
    public void add(int index, String o){
	if (size()==arr.length){
	    resize(2*arr.length);
	}
	if (size()!=arr.length){
	    String[] newArr = new String[arr.length];
	    for (int i=0;i<=size();i++){
		if (i<index){
		    newArr[i]=arr[i];
		}else if (i==index){
		    newArr[i]=o;
		}else{
		    newArr[i]=arr[i-1];
		}
	    }
	    len++;
	    arr=newArr;
	}
    }
    public int size(){
	return len;
    }
    public void resize(int newCapacity){
	String[] newArr = new String[newCapacity];
	if (newCapacity>arr.length){
	    for (int i=0; i<arr.length; i++){
		newArr[i]=arr[i];
	    }
	    arr = newArr;
	}else if (newCapacity<arr.length && newCapacity>=0){
	    for (int i=0; i<newArr.length; i++){
		newArr[i]=arr[i];
	    }
	    arr = newArr;
	    len = arr.length;
	}
    }
    public void clear(){
	len = 0;
    }
    public int actSize(){
	return arr.length;
    }
    public String get(int index){
	if (index<size() && index>=0){
	    return arr[index];
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public String set(int index, String e){
	if (index<size() && index>=0){
	    String r = arr[index];
	    arr[index]=e;
	    return r;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public String remove(int index){
	if (index>=0 && index<size()){
	    String r = arr[index];
	    for (int i=index; i<size()-1; i++){
		arr[i]=arr[i+1];
	    }
	    len--;
	    return r;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public void insertionSort(){
	int sortedLimit=0;
	while (sortedLimit<size()-1){
	    String temp = get(sortedLimit+1);
	    if (get(sortedLimit).compareTo(temp)<=0){
		sortedLimit++;
	    }
	    else {
		int newIndex=-1;
		int i=0;
		while (newIndex==-1){
		    if (get(i).compareTo(temp)>=0){
			newIndex=i+1;
		    }
		    i++;
		}
		for (int j=sortedLimit+1;j>=newIndex;j--){
		    set(j,get(j-1));
		}
		set(newIndex-1,temp);
		sortedLimit++;
	    }
	}
    }
    // from announcements page
    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
    public int find(String target){
	for (int i=0;i<size();i++){
	    if (get(i).equals(target)){
		return i;
	    }
	}
	return -1;
    }
    public static void main(String[]args){
	/*SuperArray L = new SuperArray();
	String x = new String("5");

	System.out.println(L.size());
	System.out.println(L);
	System.out.println();

	L.add(x);
	L.add("99");

	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println(L);
	System.out.println();

	L.resize(15);
	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println(L);
	System.out.println();

	L.resize(1);
	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println(L);
	System.out.println();

	System.out.println(L.get(0));
	System.out.println(L.set(0,"404"));
	System.out.println(L.get(0));
	System.out.println();

	System.out.println(L);
	String s = "Sting";
	L.add(s);
	L.add(s);
	System.out.println(L);
	L.add(2,"503");
	System.out.println(L);
	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println();

	System.out.println(L);
	try{
	    System.out.println(L.set(4,"seat"));
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("I don't believe in indices");
	}
	System.out.println(L.set(3,"seat"));
	System.out.println(L);
	System.out.println();

	System.out.println(L);
	try{
	    System.out.println(L.remove(555));
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("That absolutely definitely should have worked!!1!");
	}
	System.out.println(L.remove(1));
	System.out.println(L);
	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println();

	L.clear();
	System.out.println(L);
	System.out.println(L.size());
	System.out.println(L.actSize());*/

	//SEE DOCUMENT.TXT FOR MORE INFO
	/*SuperArray F = new SuperArray();
	String[] f = new String[100];
	Random r = new Random(24);
	if (args.length<=2){
	    for (int i=0; i<20000; i++){
		String s = "";
		int limit = r.nextInt(10-1)+1+1;
		for (int j=0; j<limit; j++){
		    s+=(char)(r.nextInt('z'-'A')+1+'A');
		}
		F.add(s);
	    }
	    if (args.length==1){
		F.badInsertionSort();
	    }
	    if (args.length==2){
		F.insertionSort();
	    }
	}
	else {
	    if (args.length==3){
		for (int i=0; i<100; i++){
		    String s = "";
		    int limit = r.nextInt(10-1)+1+1;
		    for (int j=0; j<limit; j++){
			s+=(char)(r.nextInt('z'-'A')+1+'A');
		    }
		    F.add(s);
		    f[i]=s;
		}
		boolean eq = true;
		int index = 0;
		F.insertionSort();
		Arrays.sort(f);
		while (index>=F.size() && eq){
		    if (!(F.get(index).equals(f[index]))){
			eq=false;
		    }
		}
		System.out.println(eq);
	    }
	    }*/
	
    }
}
