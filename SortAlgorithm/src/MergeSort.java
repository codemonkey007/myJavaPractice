/*
 * 归并排序*/

public class MergeSort {
	public static void main(String[] args) {
		int[] num = {3,1,5,7,2,4,9,6,10,8}; 
		int[] tmp = new int[num.length];
		System.out.println("排序前的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		MergeSort.mergeSort(num, tmp, 0, num.length - 1);
		
		System.out.println("排序后的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
	
	private static void merge(int[] r, int[] rf, int first, int mid, int last){
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;
		
		while(i <= m && j <= n){
			if(r[i] <= r[j]){
				rf[k++] = r[i++];
			}
			else
				rf[k++] = r[j++];
		}
		
		while(i <= m){
			rf[k++] = r[i++];
		}
		
		while(j <= n){
			rf[k++] = r[j++];
		}
		
		for(i = 0; i < k; i++){
			r[first + i] = rf[i];
		}
	}
	
	private static void mergeSort(int[] num, int[] tmp, int first, int last){
		if(first < last){
			int mid = (first + last) / 2;
			mergeSort(num, tmp, first, mid);
			mergeSort(num, tmp, mid + 1, last);
			merge(num, tmp, first, mid, last);
		}
		
	}
}
