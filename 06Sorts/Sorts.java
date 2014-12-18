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
	int n=0;
	int m=0;
	do {
	    ArrayList<ArrayList> buckets = new ArrayList<ArrayList>(10);
	    for (int i=0; i<arr.length; i++){
		if (amtDigits>m){
		    m=amtDigits;
		}
	        buckets.set(arr[i]%10^n,arr[i]);
	    }
	    for (int i=0; i<10; i++){
		for (int j=0; j<buckets.get(i).size(); j++){
		    arr[j+1]=buckets.get(i).get(j);
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
	Random r = new Random(11);
	for (int i=0; i<100000; i++){
	    a[i]=r.nextInt(100000);
	}
	//System.out.println(Arrays.toString(a));
	if (args.length==1){
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
	    int[] b = {6,0,5,3,4,7,2,1};
	    System.out.println(Arrays.toString(b));
	    dubbleBubble(b);
	    System.out.println(Arrays.toString(b));	
	}
    }
}
