package monkeyking;

import javax.swing.JOptionPane;

public class MonkeyKing {
	public static void main(String[] args) {
		String s;
		int n, k, m, sum, start;
		s = JOptionPane.showInputDialog("请输入猴子的总数：");
		n = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("请输入起始报数的猴子的编号：");
		k = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("请输入出局的数字：");
		m = Integer.parseInt(s);
		int[] a = new int[n + 1];
		System.out.println("出局猴子的编号：");
		for(int i = 1; i < a.length; i++){
			a[i] = 1;
		}
		sum = n;
		start = k;
		for(int i = 0; i <= m; i++){
			if(sum == 1)
				break;
			else if(i == m){
				sum--;
				i = 0;
				a[k] = 0;
				System.out.print(k + " ");
			}
			do{
				k = (k + 1) % n;
				if(k == 0)
					k = 120;
			}while(a[k] != 0);
		}
		System.out.println("猴王编号为:" + k);
	}
}
