package jiugongge;

import java.util.Scanner;

public class Jiugongge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[][] a = new int[x][x];
		Merzirac(a, x);
		
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
}
