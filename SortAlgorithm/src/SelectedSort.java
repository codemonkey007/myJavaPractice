import java.util.Scanner;


public class SelectedSort {
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
		
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(num[i] > num[j]){
					num[i] = num[i] ^ num[j];
					num[j] = num[i] ^ num[j];
					num[i] = num[i] ^ num[j];
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
		SelectedSort ss = new SelectedSort();
		ss.sortArray();
	}
}
