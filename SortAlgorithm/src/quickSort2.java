
public class quickSort2 {
	
	public static int getMiddle(int[] num, int left, int right){
		
		/*int temp;
		int mid = num[left];
		while(left < right){
			while(left < right && num[right] >= mid)
				right--;
			temp = num[right];
			num[right] = num[left];
			num[left] = temp;
			while(left < right && num[left] <= mid)
				left++;
			temp = num[right];
			num[right] = num[left];
			num[left] = temp;
		}
		num[left] = mid;
		return left;*/
		
		int i,j,t,pivot;
		 if(left > right)
			 return 0;
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
		  return i;
	}
	
	public static int[] quickSort(int[] num, int left, int right){
		if(left < right){
			int mid = getMiddle(num, left, right);
			quickSort(num, left, mid - 1);
			quickSort(num, mid + 1, right);
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] num = {3,1,5,7,2,4,9,6,10,8};
		
		System.out.println("排序前的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		int[] b = quickSort(num, 0, num.length - 1);
		
		System.out.println("排序后的数据：");
		for(int i = 0; i < b.length; i++){
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}
}
