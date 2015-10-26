import java.util.Scanner;

public class MagicSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[][] a = new int[x][x];
		
		if(x % 2 == 1)
			Merzirac(a, x);   //奇阶幻方
		else{
			if(x % 4 == 0)    //双偶幻方
				Spring(a, x);
			else
				SingleEven(a, x);  //单偶幻方
		}
		
		for(int i = 0; i < x; i++){
			for(int j = 0; j < x; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*Merzirac法生成奇阶幻方：
	 * (0)在行列上都越界，处理同情形（4）
	 * （1）在第一行居中的方格内放1，依次向右上方填入2、3、4…；
	 * （2）若出到方阵上方，把该数字填到本该所在列的最下格，仍然要放在右一列；
	 * （3）若出到方阵右方，把该数字填到本该所在行的最左格，仍然要放在上一行；
	 * （4）右上方已经有数（或出对角线）时，则向下移一格【在该位置下移动一位】，按上述方法继续填写；
	 * */
	private static void Merzirac(int[][]a, int len){
		/*
		 * row表示行，col表示列
		 * len表示数组的长度
		 * */
		int row = 0;
		int col = len / 2;
		for(int i = 1; i <= len * len; i++){
			a[row][col] = i;
			
			//向右上方填写
			row--;
			col++;
			
			if(row < 0 && col >= len){  //情形（0），在行列上均越界处理同情形（4）
				row++;    //先返回一个数字
				col--;
				row++;    //再下移一行
			}
			
			else if(row < 0){  //情形（2）
				row = len - 1;
			}
			
			else if(col >= len){  //情形（3）
				col = 0;
			}
			
			else if(a[row][col] > 0){  //情形（4）
				row++;    //先返回一个数字
				col--;
				row++;    //再下移一行
			}
		}
	}

	/*能被4整除的n阶幻方叫双偶幻方，如8阶、12阶、16阶等，双偶幻方用Spring法、Strachey法生成。
	 * Spring法生成双偶幻方：
	 * 方法就是两句话：顺序填数，以中心点对称互换数字。
	 * 双偶幻方并不是唯一的
	 * */
	private static void Spring(int[][] a, int len){
		for(int i = 0; i < len; i++){//第一步，先令a(i,j)=(i-1)*n+j
			for(int j = 0; j < len; j++){
				a[i][j] = i * len + j + 1;
			}
		}
		
		/*第二步，进行对称交换
		 * 将左上区域i+j为偶数的与幻方内以中心点为对称点的右下角对角数字进行交换；
		 * 将右上区域i+j为奇数的与幻方内以中心点为对称点的左下角对角数字进行交换。
		 * （保证不同时为奇或偶即可。）
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

	/*将n阶单偶幻方表示为4m+2阶幻方。将其等分为四分，成为如下图所示A、B、C、D四个2m+1阶奇数幻方。
	 *A C
	 *D B
	 *A用1至(2m+1)^2填写成(2m+1)阶幻方；
	 *B用(2m+1)^2+1至2*(2m+1)^2填写成(2m+1)阶幻方；
	 *C用2*(2m+1)^2+1至3*(2m+1)2填写成(2m+1)阶幻方；
	 *D用3*(2m+1)^2+1至4*(2m+1)^2填写成(2m+1)阶幻方；
	 *（1）把方阵分为A，B，C，D四个象限，这样每一个象限肯定是奇数阶。用罗伯法(Merzirac)，
	 *	    依次在A象限，B象限，C象限，D象限按奇数阶幻方的填法填数。
	 *(2)在A象限的中间行、中间格开始，按自左向右的方向，标出k格。A象限的其它行则标出最左边的k格。
	 *	   将这些格，和D象限相对位置上的数，互换位置。
	 *(3)在C象限任一行的中间格，自右向左，标出k-1列。(注：6阶幻方由于k-1=0，所以不用再作B、D象限的数据交换)， 
	 *   将C象限标出的这些数，和B象限相对位置上的数进行交换，就形成幻方。
	 * */
	private static void SingleEven(int[][] a, int len){
		//填充A、B、C、D四个象限
		int merLen = len / 2;  //merLen表示A、B、C、D四个象限用罗伯法填充的长度
		Merzirac(a, merLen);   //用罗伯法填充A象限
		
//		for(int i = 0; i < merLen; i++){
//			for(int j = 0; j < merLen; j++){
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("-------------------");
		
		int temp = merLen * merLen;
//		System.out.println("temp=" + temp);
		for(int i = merLen; i < len; i++){  //用填充好的A象限去填充B现象，B象限中的每个数比A象限中的数大merLen*merLen
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
		for(int i = 0; i < merLen; i++){  //用填充好的A象限去填充C现象，C象限中的每个数比A象限中的数大2*merLen*merLen
			for(int j = merLen; j < len; j++){
				a[i][j] = a[i][j-merLen] + temp;
//				System.out.print(a[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println("-------------------");
		
		temp = 3 * merLen * merLen;
		for(int i = merLen; i < len; i++){  //用填充好的A象限去填充D现象，D象限中的每个数比A象限中的数大3*merLen*merLen
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
				for(int j = k; j < 2 * k; j++){//中间行前面不取，而从中间格（第k列开始）向后去k-1个
					temp = a[i][j];//交换A、D象限中对应的值
					a[i][j] = a[i + merLen][j];
					a[i + merLen][j] = temp;
				}
			}
			else{
				for(int j = 0; j < k; j++){
					//交换A、D象限中对应的值
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
			for(int j = merLen + merLen / 2; j >= merLen + k - 1; j--){ //自右往左
				temp = a[i][j];
				a[i][j] = a[i + merLen][j];
				a[i + merLen][j] = temp;
			}
		}
	}
}
