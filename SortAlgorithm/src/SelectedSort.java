import java.util.Scanner;


public class SelectedSort {
	public void sortArray(){
		Scanner sc = new Scanner(System.in);
		System.out.print("������Ҫ��������ݵĸ�������������Щ���ݣ�");
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = sc.nextInt();
		}
		
		System.out.println("����ǰ�����ݣ�");
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
		
		System.out.println("���������ݣ�");
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
