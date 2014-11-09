public class SuperArray{
    private Object[] arr;
    private int len;
    public SuperArray(){
	this(10);
    }
    public SuperArray(int x){
	arr = new Object[x];
	len = 0;
    }
    public String toString(){
	String ret="[ ";
	for (int i=0;i<len;i++){
	    ret+=arr[i]+" ";
	}
	return ret+"]";
    }
    public void add(Object e){
	if (size()!=arr.length){
	    arr[size()]=e;
	    len++;
	}else{
	    resize(arr.length+1);
	    arr[size()]=e;
	    len++;
	}
    }
    public void add(int index, Object o){
	if (size()==arr.length){
	    resize(arr.length+1);
	}
	if (size()!=arr.length){
	    Object[] newArr = new Object[arr.length];
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
	Object[] newArr = new Object[newCapacity];
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
	arr = new Object[arr.length];
	len = 0;
    }
    public int actSize(){
	return arr.length;
    }
    public Object get(int index){
	if (index<size() && index>=0){
	    return arr[index];
	}else{
	    System.out.println("Error: index out of range");
	    return null;
	}
    }
    public Object set(int index, Object e){
	if (index<size() && index>=0){
	    Object r = arr[index];
	    arr[index]=e;
	    return r;
	}else{
	    System.out.println("Error: index out of range");
	    return null;
	}
    }
    public Object remove(int index){
	if (index>=0 && index<size()){
	    Object r = arr[index];
	    for (int i=index; i<size()-1; i++){
		arr[i]=arr[i+1];
	    }
	    len--;
	    resize(arr.length-1);
	    return r;
	}else{
	    System.out.println("Error: index out of range");
	    return null;
	}
    }
    public static void main(String[]args){
	SuperArray L = new SuperArray();
	Integer x = new Integer(5);

	System.out.println(L.size());
	System.out.println(L);
	System.out.println();

	L.add(x);
	L.add(new Integer(99));

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
	System.out.println(L.set(0,new Integer(404)));
	System.out.println(L.get(0));
	System.out.println();

	System.out.println(L);
	String s = "String";
	L.add(s);
	L.add(s);
	System.out.println(L);
	L.add(2,new Integer(503));
	System.out.println(L);
	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println();

	System.out.println(L);
	System.out.println(L.set(4,"seat"));
	System.out.println(L.set(3,"seat"));
	System.out.println(L);
	System.out.println();

	System.out.println(L);
	System.out.println(L.remove(55));
	System.out.println(L.remove(1));
	System.out.println(L);
	System.out.println(L.size());
	System.out.println(L.actSize());
	System.out.println();

	L.clear();
	System.out.println(L);
	System.out.println(L.size());
	System.out.println(L.actSize());
    }
}
