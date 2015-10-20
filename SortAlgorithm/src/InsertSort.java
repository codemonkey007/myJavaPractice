import java.util.Scanner;


public class InsertSort {
	public void sortArray(){
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要排序的数据的个数，并输入这些数据：");
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = sc.nextInt();
		}
		
		System.out.println("排序前的数据：");
		for(int i = 0; i < n; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		/*for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(num[i] < num[j]){
					num[i] = num[i] ^ num[j];
					num[j] = num[i] ^ num[j];
					num[i] = num[i] ^ num[j];
				}
			}
		}*/
		
		//3 1 5 7 2 4 9 6 10 8
		
		/*int j, k;
		for(int i = 1; i < n; i++){  
	        int temp = num[i];  
	        for(j = 0; j < i; j++){  
	            if(temp < num[j]){  
	                for(k = i; k > j; k--){  
	                    num[k] = num[k-1];  
	                }  
	                num[j] = temp;  
	                break;  
	            }  
	        }  
	    }*/
		
		
		int j, k, temp;
		for(int i = 1; i < n; i++){  
	        temp = num[i];  
	        for(j = i - 1; j >= 0 && num[j] > temp; j--);
	        j += 1;
	        for(k = i; k > j; k--){
	        	num[k] = num[k - 1];
	        }
	        num[j] = temp; 
	    }
		
		System.out.println("排序后的数据：");
		for(int i = 0; i < n; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		is.sortArray();
	}
}
