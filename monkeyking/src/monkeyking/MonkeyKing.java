package monkeyking;

import javax.swing.JOptionPane;

public class MonkeyKing {
	public static void main(String[] args) {
		String s;
		int n, k, m, sum, start;
		s = JOptionPane.showInputDialog("��������ӵ�������");
		n = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("��������ʼ�����ĺ��ӵı�ţ�");
		k = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("��������ֵ����֣�");
		m = Integer.parseInt(s);
		int[] a = new int[n + 1];
		System.out.println("���ֺ��ӵı�ţ�");
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
		System.out.println("�������Ϊ:" + k);
	}
}
