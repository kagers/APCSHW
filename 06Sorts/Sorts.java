import java.util.*;

public class Sorts{
    public static String name(){
	return "Gershfeld,Katherine";
    }
    public static int period(){
	return 6;
    }
    public static void swap(int[] a, int k, int l){
	int t=a[l];
	a[l]=a[k];
	a[k]=t;
    }
    public static void radix(int[] arr){
	int n=0, m=0;
	ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
	do {
	    buckets.clear();
	    for (int i=0; i<10; i++){
		buckets.add(new ArrayList<Integer>());
	    }
	    for (int i=0; i<arr.length; i++){
		if (n==0){
		    int amtDigits=(int)Math.log10(Math.abs(arr[i]))+1;
		    if (amtDigits>m){
			m=amtDigits;
		    }
		}
		buckets.get((int)(arr[i]/Math.pow(10.0,n))%10).add(arr[i]);
	    }
	    int k=0;
	    for (int i=0; i<10; i++){
		for (int j=0; j<buckets.get(i).size(); j++){
		    arr[k++]=buckets.get(i).get(j);
		}
	    }
	    n++;
	}while (n<m);
    }
    public static void bubble(int[] arr){
	boolean swapped=true;
	for (int i=arr.length-1; i>=0; i--){
	    if (swapped){
		swapped=false;
		for (int j=0; j<i; j++){
		    if (arr[j]>arr[j+1]){
			swap(arr,j,j+1);
			swapped=true;
		    }
		}
	    }
	}
    }
    public static void dubbleBubble(int[] arr){
	boolean swapped=true;
	for (int i=arr.length-1; i>=0; i--){
	    if (swapped){
		swapped=false;
		for (int j=0; j<i; j++){
		    if (arr[j]>arr[j+1]){
			swap(arr,j,j+1);
			swapped=true;
		    }
		}
		if (!swapped){
		    break;
		}
		for (int k=i; k>arr.length-i; k--){
		    if (arr[k]<arr[k-1]){
			swap(arr,k,k-1);
		    }
		} 
	    }
	}
    }
    public static void selection(int[] arr){
	for (int i=0;i<arr.length;i++){
	    int min=arr[i];
	    int mindex=i;
	    for (int j=i+1;j<arr.length;j++){
		if (arr[j]<min){
		    min=arr[j];
		    mindex=j;
		}
	    }
	    swap(arr,i,mindex);
	}
    }
    public static void insertion(int[] arr){
	for (int sortedLimit=0;sortedLimit<arr.length-1;sortedLimit++){
	    int temp = arr[sortedLimit+1];
	    if (arr[sortedLimit]>=temp){
		int newIndex=-1;
		int i=0;
		while (newIndex==-1){
		    if (arr[i]>=temp){
			newIndex=i+1;
		    }
		    i++;
		}
		for (int j=sortedLimit+1;j>=newIndex;j--){
		    arr[j]=arr[j-1];
		}
		arr[newIndex-1]=temp;
	    }
	}
    }
    public static void main(String[]args){
	int[] a = new int[100000];
	int[] rx = new int[100000];
	int[] bu = new int[100000];
	int[] db = new int[100000];
	int[] in = new int[100000];
	int[] se = new int[100000];
	int[] as = new int[100000];
	Random r = new Random(11);
	long start, end;
	for (int i=0; i<100000; i++){
	    a[i]=r.nextInt(Integer.MAX_VALUE);
	}
	System.arraycopy(a, 0, rx, 0, a.length);
	start = System.currentTimeMillis();
	radix(rx);
	end = System.currentTimeMillis();
	System.out.println("radix");
	System.out.println(end-start);

	System.arraycopy(a, 0, bu, 0, a.length);
	start = System.currentTimeMillis();
	Sorts.bubble(bu);
	end = System.currentTimeMillis();
	System.out.println("bubble");
	System.out.println(end-start);

	System.arraycopy(a, 0, db, 0, a.length);
	start = System.currentTimeMillis();
	Sorts.dubbleBubble(db);
	end = System.currentTimeMillis();
	System.out.println("dubble bubble");
	System.out.println(end-start);

	System.arraycopy(a, 0, in, 0, a.length);
	start = System.currentTimeMillis();
	Sorts.insertion(in);
	end = System.currentTimeMillis();
	System.out.println("insertion");
	System.out.println(end-start);
	
	System.arraycopy(a, 0, se, 0, a.length);
	start = System.currentTimeMillis();
	Sorts.selection(se);
	end = System.currentTimeMillis();
	System.out.println("selection");
	System.out.println(end-start);
	
	System.arraycopy(a, 0, as, 0, a.length);
	start = System.currentTimeMillis();
	Arrays.sort(as);
	end = System.currentTimeMillis();
	System.out.println("Arrays.sort");
	System.out.println(end-start);

	System.out.println(Arrays.equals(rx,as));
	System.out.println(Arrays.equals(bu,as));
	System.out.println(Arrays.equals(db,as));
	System.out.println(Arrays.equals(in,as));
	System.out.println(Arrays.equals(se,as));
	/*if (args.length==1){
	    bubble(a);
	}
	if (args.length==2){
	    dubbleBubble(a);
	}
	if (args.length==3){
	    selection(a);
	}
	if (args.length==4){
	    insertion(a);
	}
	if (args.length==5){
	    Arrays.sort(a);
	}
	//System.out.println(Arrays.toString(a));
	if (args.length==6){
	    int[] b = {601,10,57,13,4,76,2,1,2005};
	    System.out.println(Arrays.toString(b));
	    radix(b);
	    System.out.println(Arrays.toString(b));	
	    }*/
    }
}
