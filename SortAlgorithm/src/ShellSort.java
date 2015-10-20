
public class ShellSort {

	static void shellsort(int[] unsorted, int len)
    {
        int group, i, j, temp;
        for (group = len / 2; group > 0; group /= 2)
        {
           /* for (i = group; i < len; i++)
            {
                for (j = i - group; j >= 0; j -= group)
                {
                    if (unsorted[j] > unsorted[j + group])
                    {
                        temp = unsorted[j];
                        unsorted[j] = unsorted[j + group];
                        unsorted[j + group] = temp;
                    }
                }
            }*/
        	
    		for(i = group; i < len; i++){  
    	        temp = unsorted[i];  
    	        for(j = i - group; j >= 0 && unsorted[j] > temp; j -= group);
    	        j += group;
    	        for(int k = i; k > j; k -= group){
    	        	unsorted[k] = unsorted[k - group];
    	        }
    	        unsorted[j] = temp; 
    	    }
        }
    }
	
	public static void main(String[] args) {

		int[] num = {9,8,7,6,5,4,3,2,1,0};
		
		System.out.println("排序前的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		ShellSort.shellsort(num, num.length);
		
		System.out.println("排序后的数据：");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
}
