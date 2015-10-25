package euclid;

public class ExtendEuclid {
	
	static int x, y;
	/***************************************
	������ExGcd (�ݹ���ʽ)
	���ܣ��������������Լ����ģP�ĳ˷���Ԫ��
	���룺a,b ������������������������Լ��
	   ��aģb����Ԫ �� bģa����Ԫ��
	�����x,y �ֱ��ʾaģb����Ԫ��bģa����Ԫ��
	���أ�r ��ʾa b �����Լ����
	*************************************/
	public static int ExGcd(int a, int b)
	{
		if(b == 0)
		{
		   x = 1;
		   y = 0;
		   return a;
		}
		int r = ExGcd(b, a % b);
		int t = x;
		x = y;
		y = t - a / b * y;
		return r;
	}
	
	public static void main(String[] args) {
		int a = 550, b = 1769;
		System.out.println(ExtendEuclid(a, b));
		
		System.out.println("----------");
		int r = ExGcd(a, b);
		System.out.println("gcd(a,b)=" + r);
		System.out.println(x + " " + y);
	}
	
	
	/*
	 * y2��y1�ֱ���a��b����Ԫ
	 * ��x1��y1��t1��������b����Ԫ����x2��y2��t2��������a����Ԫ
	 * ��x3��y3��t3������ִ��ŷ������㷨
	 * ��x1��y1��=��1��0������x2��y2��=��0��1��ִ��һ�α�ɣ�x1��y1��=��0��1��=��x2��y2��
	 * ��a����Ҫ����bִ��һ����
	 * */
	private static int ExtendEuclid(int a, int b){
		int x1 = 1, x2 = 0, x3 = b;
		int y1 = 0, y2 = 1, y3 = a;
		while(true){
			if(y3 == 0){
				System.out.println("a����Ԫ��");
				return -1;
			}
			if(y3 == 1){
				return y2;
			}
			int Q = x3 / y3;
			int t1 = x1- Q * y1, t2 = x2- Q * y2, t3 = x3- Q * y3;
			x1 = y1;
			x2 = y2;
			x3 = y3;
			y1 = t1;
			y2 = t2;
			y3 = t3;
		}
	}
}
