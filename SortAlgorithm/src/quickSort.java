import java.util.Scanner;


public class quickSort {
	
	void sort(int[] num, int left, int right){
		int i,j,t,pivot;
		 if(left > right)
			 return;
		 pivot = num[left]; //temp�д�ľ��ǻ�׼��
		 i = left;
		 j = right;
		 while(i != j)
		 {
			// ˳�����Ҫ��Ҫ�ȴ���������
			while(num[j] >= pivot && i < j)
			    j--;
		 	// �ٴ���������  
			while(num[i] <= pivot && i < j)
				i++;
		 	// �����������������е�λ��
		 	if(i < j)// ���ڱ�i���ڱ�j û������ʱ
		 	{
			 	num[i] = num[i] ^ num[j];
				num[j] = num[i] ^ num[j];
				num[i] = num[i] ^ num[j];
		 	}
		 }
		 
		// ���ս���׼����λ
		 num[left] = num[i];
		 num[i] = pivot;
		  
		  sort(num, left,i-1);// ����������ߵģ�������һ���ݹ�Ĺ���
		  sort(num, i+1,right);// ���������ұߵģ�������һ���ݹ�Ĺ���
	}
	
	public static void main(String[] args) {
		int[] num = {4,7,8,6};
		
		System.out.println("����ǰ�����ݣ�");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		quickSort qs = new quickSort();
		qs.sort(num, 0, num.length - 1);
		
		System.out.println("���������ݣ�");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
}
