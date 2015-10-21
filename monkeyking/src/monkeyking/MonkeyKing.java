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
		m = m -1;
		int point;
		while(sum > 1){
			while(a[start] == 0){
				start = (start + 1) % (n + 1);
			}
			point = (start + m) % (n + 1);
			while(a[point] == 0){
				point = (point + 1) % (n + 1);
			}
			if(a[start] != 0 && a[point] != 0){
				start++;
				System.out.println(point + " ");
				sum--;
			}
		}
		if(sum == 1){
			int j = 1;
			while(a[j] == 0)
				j++;
			if(j < n + 1){
				System.out.println("猴王编号为:" + a[j]);
			}
		}
	}
}
