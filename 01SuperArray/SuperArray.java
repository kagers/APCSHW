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
	    if (len!=arr.length){
	      arr[len]=e;
	      len++;
	    }else{
	      resize(arr.length+1);
	      arr[len]=e;
	      len++;
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
	    if (index<len && index>=0){
	      return arr[index];
	    }else{
	      return null;
	  }
    }
    public void set(int index, Object e){
	    if (index<len && index>=0){
	      arr[index]=e;
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
	    L.set(0,new Integer(404));
	    System.out.println(L.get(0));
	    System.out.println();

	    L.clear();
	    System.out.println(L);
    }
}
