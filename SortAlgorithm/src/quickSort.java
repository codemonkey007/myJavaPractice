import java.util.Scanner;


public class quickSort {
	
	void sort(int[] num, int left, int right){
		int i,j,t,pivot;
		 if(left > right)
			 return;
		 pivot = num[left]; //temp中存的就是基准数
		 i = left;
		 j = right;
		 while(i != j)
		 {
			// 顺序很重要，要先从右往左找
			while(num[j] >= pivot && i < j)
			    j--;
		 	// 再从左往右找  
			while(num[i] <= pivot && i < j)
				i++;
		 	// 交换两个数在数组中的位置
		 	if(i < j)// 当哨兵i和哨兵j 没有相遇时
		 	{
			 	num[i] = num[i] ^ num[j];
				num[j] = num[i] ^ num[j];
				num[i] = num[i] ^ num[j];
		 	}
		 }
		 
		// 最终将基准数归位
		 num[left] = num[i];
		 num[i] = pivot;
		  
		  sort(num, left,i-1);// 继续处理左边的，这里是一个递归的过程
		  sort(num, i+1,right);// 继续处理右边的，这里是一个递归的过程
	}
	
	public static void main(String[] args) {
		int[] num = {4,7,8,6};
		
		System.out.println("排序前的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		quickSort qs = new quickSort();
		qs.sort(num, 0, num.length - 1);
		
		System.out.println("排序后的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
}
