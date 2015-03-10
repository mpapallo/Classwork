import java.util.*;
public class QuickSelect{
    
    private static Random rand = new Random();

    public static int select(int[] ary, int n){
	return select(ary, n, 0, ary.length - 1);
    }

    public static int select(int[] ary, int n, int si, int ei){
        int index = partitionInPlace(ary, n, si, ei);
	if (index < n){
	    return select(ary, n, index + 1, ei);
	}else if (index > n){
	    return select(ary, n, si, index - 1);
	}
	return ary[index];
    }

    public static int partitionInPlace(int[] ary, int n, int si, int ei){
	int pi = rand.nextInt(ei + 1 - si) + si;
	int pivot = ary[pi];
	int end = ei;
	int i = si;
	while(i<=end && si!=ei){
	    if(ary[i]<pivot){
		int x = ary[i];
		ary[i] = ary[si];
		ary[si] = x;
		si++;
		if(x==pivot){
		    pi = si;
		}else if(ary[i]==pivot){
		    pi = i;
		}
		i++;
	    }else if(ary[i]>pivot){
		int x = ary[i];
		ary[i] = ary[ei];
		ary[ei] = x;
		ei--;
		if(x==pivot){
		    pi = ei;
		}else if(ary[i]==pivot){
		    pi = i;
		}
	    }else{
		i++;
	    }
	}
	int x = ary[si];
	ary[si] = pivot;
	ary[pi] = x;
	//System.out.println(pivot);
	//System.out.println(Arrays.toString(ary));
	return pi;
    }

    public static int partition(int[] ary, int n, int si, int ei){
	//randomly pick a pivot point, save its value
	int ri = rand.nextInt(ei + 1 - si) + si;
	int pivot = ary[ri];
	//make new array
	int[] d = new int[ary.length];
	int start = si;
	int end = ei;
	//for elements between si and ei:
	for (int i = si; i <= ei; i ++){
	    if (ary[i] < pivot){
		d[start] = ary[i];
		start ++;
	    }else if (ary[i] > pivot){
	        d[end] = ary[i];
		end --;
	    }
	}
	d[start] = pivot;
	//copy over elements that aren't in range [si, ei]
	//before:
	for (int i = si - 1; i >= 0; i --){
	    d[i] = ary[i];
	}
	//after:
	for (int i = ei + 1; i < ary.length; i ++){
	    d[i] = ary[i];
	}

	//System.out.println(pivot);
	//System.out.println(Arrays.toString(d)); 
	if (start == n - 1){
	    return d[start];
	}
	else if(start < n - 1){
	    return partition(d, n, start, ei);
	}else{
	    return partition(d, n, si, start);
	}
	
    }

    public static void main(String[]args){

	int[] ary = new int[10];
	for (int i = 0; i < ary.length; i ++){
	    ary[i] = i;
	}
	for (int i = 0; i < ary.length; i ++){
	    int x = ary[i];
	    int index = rand.nextInt(ary.length - 1);
	    ary[i] = ary[index];
	    ary[index] = x;
	}
	System.out.println(Arrays.toString(ary));
	System.out.println();

        System.out.println("\nResult:" + select(ary, 5));
	
    }
    
}
