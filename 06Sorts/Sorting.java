import java.util.*;

public class Sorts{
    public static void swap(int[] a, int k, int l){
	int t=a[l];
	a[l]=a[k];
	a[k]=t;
    }
    public static void bubble(int[] arr){
	boolean swapped;
	for (int i=arr.length-1; i>=0; i--){
	    if (swapped=true){
		swapped=false;
		for (int j=0; j<i; j++){
		    if (arr[j]>arr[j+1]){
			swap(arr,j,j+1);
			swapped=true;
		    }
		}
	    }
	    System.out.println(Arrays.toString(arr));
	}
    }
    public void selectionSort(int[] arr){
	for (int i=0;i<size();i++){
	    int min=arr[i];
	    int mindex=i;
	    for (int j=i+1;j<size();j++){
		if (int[i]<min){
		    min=int[j];
		    mindex=j;
		}
	    }
	    swap(arr,i,min);
	}
    }
    public void insertionSort(int[] arr){
	for (int sortedLimit=0;sortedLimit<size()-1;sortedLimit++){
	    String temp = get(sortedLimit+1);
	    if (int[sortedLimit]>=temp){
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
	int[] a = {6,0,5,3,4,7,2,1};
	System.out.println(Arrays.toString(a));
	bubble(a);
	System.out.println(Arrays.toString(a));	
    }
}
