import java.util.Scanner;

public class MagicSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[][] a = new int[x][x];
		//Merzirac(a, x);
		Spring(a, x);
		
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
	 * */
	private static void Spring(int[][]a, int len){
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
}
