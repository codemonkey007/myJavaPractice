import java.util.Scanner;

public class MagicSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[][] a = new int[x][x];
		
		if(x % 2 == 1)
			Merzirac(a, x);   //��׻÷�
		else{
			if(x % 4 == 0)    //˫ż�÷�
				Spring(a, x);
			else
				SingleEven(a, x);  //��ż�÷�
		}
		
		for(int i = 0; i < x; i++){
			for(int j = 0; j < x; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*Merzirac��������׻÷���
	 * (0)�������϶�Խ�磬����ͬ���Σ�4��
	 * ��1���ڵ�һ�о��еķ����ڷ�1�����������Ϸ�����2��3��4����
	 * ��2�������������Ϸ����Ѹ���������������е����¸���ȻҪ������һ�У�
	 * ��3�������������ҷ����Ѹ���������������е��������ȻҪ������һ�У�
	 * ��4�����Ϸ��Ѿ�����������Խ��ߣ�ʱ����������һ���ڸ�λ�����ƶ�һλ��������������������д��
	 * */
	private static void Merzirac(int[][]a, int len){
		/*
		 * row��ʾ�У�col��ʾ��
		 * len��ʾ����ĳ���
		 * */
		int row = 0;
		int col = len / 2;
		for(int i = 1; i <= len * len; i++){
			a[row][col] = i;
			
			//�����Ϸ���д
			row--;
			col++;
			
			if(row < 0 && col >= len){  //���Σ�0�����������Ͼ�Խ�紦��ͬ���Σ�4��
				row++;    //�ȷ���һ������
				col--;
				row++;    //������һ��
			}
			
			else if(row < 0){  //���Σ�2��
				row = len - 1;
			}
			
			else if(col >= len){  //���Σ�3��
				col = 0;
			}
			
			else if(a[row][col] > 0){  //���Σ�4��
				row++;    //�ȷ���һ������
				col--;
				row++;    //������һ��
			}
		}
	}

	/*�ܱ�4������n�׻÷���˫ż�÷�����8�ס�12�ס�16�׵ȣ�˫ż�÷���Spring����Strachey�����ɡ�
	 * Spring������˫ż�÷���
	 * �����������仰��˳�������������ĵ�Գƻ������֡�
	 * ˫ż�÷�������Ψһ��
	 * */
	private static void Spring(int[][] a, int len){
		for(int i = 0; i < len; i++){//��һ��������a(i,j)=(i-1)*n+j
			for(int j = 0; j < len; j++){
				a[i][j] = i * len + j + 1;
			}
		}
		
		/*�ڶ��������жԳƽ���
		 * ����������i+jΪż������÷��������ĵ�Ϊ�ԳƵ�����½ǶԽ����ֽ��н�����
		 * ����������i+jΪ��������÷��������ĵ�Ϊ�ԳƵ�����½ǶԽ����ֽ��н�����
		 * ����֤��ͬʱΪ���ż���ɡ���
		 * */
		for(int i = 0; i < len / 2; i++){
			for(int j = 0; j < len /2; j++){
				if((i + j) % 2 == 0){
					int temp = a[i][j];
					a[i][j] = a[len-1-i][len-1-j];
					a[len-1-i][len-1-j] = temp;
				}
			}
		}
		
		for(int i = 0; i < len / 2; i++){
			for(int j = len / 2; j < len; j++){
				if((i + j) % 2 == 1){
					int temp = a[i][j];
					a[i][j] = a[len-1-i][len-1-j];
					a[len-1-i][len-1-j] = temp;
				}
			}
		}
	}

	/*��n�׵�ż�÷���ʾΪ4m+2�׻÷�������ȷ�Ϊ�ķ֣���Ϊ����ͼ��ʾA��B��C��D�ĸ�2m+1�������÷���
	 *A C
	 *D B
	 *A��1��(2m+1)^2��д��(2m+1)�׻÷���
	 *B��(2m+1)^2+1��2*(2m+1)^2��д��(2m+1)�׻÷���
	 *C��2*(2m+1)^2+1��3*(2m+1)2��д��(2m+1)�׻÷���
	 *D��3*(2m+1)^2+1��4*(2m+1)^2��д��(2m+1)�׻÷���
	 *��1���ѷ����ΪA��B��C��D�ĸ����ޣ�����ÿһ�����޿϶��������ס����޲���(Merzirac)��
	 *	    ������A���ޣ�B���ޣ�C���ޣ�D���ް������׻÷����������
	 *(2)��A���޵��м��С��м��ʼ�����������ҵķ��򣬱��k��A���޵���������������ߵ�k��
	 *	   ����Щ�񣬺�D�������λ���ϵ���������λ�á�
	 *(3)��C������һ�е��м���������󣬱��k-1�С�(ע��6�׻÷�����k-1=0�����Բ�������B��D���޵����ݽ���)�� 
	 *   ��C���ޱ������Щ������B�������λ���ϵ������н��������γɻ÷���
	 * */
	private static void SingleEven(int[][] a, int len){
		//���A��B��C��D�ĸ�����
		int merLen = len / 2;  //merLen��ʾA��B��C��D�ĸ��������޲������ĳ���
		Merzirac(a, merLen);   //���޲������A����
		
//		for(int i = 0; i < merLen; i++){
//			for(int j = 0; j < merLen; j++){
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("-------------------");
		
		int temp = merLen * merLen;
//		System.out.println("temp=" + temp);
		for(int i = merLen; i < len; i++){  //�����õ�A����ȥ���B����B�����е�ÿ������A�����е�����merLen*merLen
			for(int j = merLen; j < len; j++){
//				System.out.println("a[" + (len-1-i) + "][" + (len-1-j) + "]=" + a[len-1-i][len-1-j]);
//				System.out.println("a["+i+"]["+j+"]=" + a[i][j]);
				a[i][j] = a[i-merLen][j-merLen] + temp;
//				System.out.print(a[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println("-------------------");
		
		temp *= 2;
		for(int i = 0; i < merLen; i++){  //�����õ�A����ȥ���C����C�����е�ÿ������A�����е�����2*merLen*merLen
			for(int j = merLen; j < len; j++){
				a[i][j] = a[i][j-merLen] + temp;
//				System.out.print(a[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println("-------------------");
		
		temp = 3 * merLen * merLen;
		for(int i = merLen; i < len; i++){  //�����õ�A����ȥ���D����D�����е�ÿ������A�����е�����3*merLen*merLen
			for(int j = 0; j < merLen; j++){
				a[i][j] = a[i - merLen][j] + temp;
			}
		}
		
//		for(int i = 0; i < len; i++){
//		for(int j = 0; j < len; j++){
//			System.out.print(a[i][j] + " ");
//		}
//		System.out.println();
//	}
//	System.out.println("-------------------");
		
		int k = (len - 2) / 4;
//		System.out.println("k=" + k);
		for(int i = 0; i < merLen; i++){
			if(i == k){
				for(int j = k; j < 2 * k; j++){//�м���ǰ�治ȡ�������м�񣨵�k�п�ʼ�����ȥk-1��
					temp = a[i][j];//����A��D�����ж�Ӧ��ֵ
					a[i][j] = a[i + merLen][j];
					a[i + merLen][j] = temp;
				}
			}
			else{
				for(int j = 0; j < k; j++){
					//����A��D�����ж�Ӧ��ֵ
					temp = a[i][j];
					a[i][j] = a[i + merLen][j];
					a[i + merLen][j] = temp;
				}
			}
		}
		
//		for(int i = 0; i < len; i++){
//		for(int j = 0; j < len; j++){
//			System.out.print(a[i][j] + " ");
//		}
//		System.out.println();
//	}
//	System.out.println("-------------------");
		
		for(int i = 0; i < merLen; i++){
			for(int j = merLen + merLen / 2; j >= merLen + k - 1; j--){ //��������
				temp = a[i][j];
				a[i][j] = a[i + merLen][j];
				a[i + merLen][j] = temp;
			}
		}
	}
}
