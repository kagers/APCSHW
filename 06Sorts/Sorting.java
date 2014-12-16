import java.util.*;

public class Sorting{
    public static void bubble(int[] arr){
	boolean swapped;
	for (int i=arr.length-1; i>=0; i--){
	    if (swapped=true){
		swapped=false;
		for (int j=0; j<i; j++){
		    if (arr[j]>arr[j+1]){
			int t=arr[j+1];
			arr[j+1]=arr[j];
			arr[j]=t;
			swapped=true;
		    }
		}
	    }
	    System.out.println(Arrays.toString(arr));
	}
    }
    public static void main(String[]args){
	int[] a = {6,0,5,3,4,7,2,1};
	System.out.println(Arrays.toString(a));
	bubble(a);
	System.out.println(Arrays.toString(a));	
    }
}
