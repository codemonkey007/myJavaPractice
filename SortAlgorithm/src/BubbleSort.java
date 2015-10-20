import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 *12 12 32 65 98
78 69 36 25 14
78 65 25 85 10
89 56 23 12 45
73 91 64 82 55 
 * */

public class BubbleSort {
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
		
		/*for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(num[i] > num[j]){
					num[i] = num[i] ^ num[j];
					num[j] = num[i] ^ num[j];
					num[i] = num[i] ^ num[j];
				}
			}
		}*/
		
		for(int i = 0; i < n - 1; i++){
			for(int j = 0; j < n - 1 - i; j++){
				if(num[j] > num[j + 1]){
					num[j] = num[j] ^ num[j + 1];
					num[j + 1] = num[j] ^ num[j + 1];
					num[j] = num[j] ^ num[j + 1];
				}
			}
		}
		
		System.out.println("排序后的数据：");
		for(int i = 0; i < n; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.sortArray();
	}
}
