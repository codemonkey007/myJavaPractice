package euclid;

public class ExtendEuclid {
	
	static int x, y;
	/***************************************
	函数：ExGcd (递归形式)
	功能：求两个数的最大公约数和模P的乘法逆元。
	输入：a,b 输入参数，求这两个数的最大公约数
	   和a模b的逆元 或 b模a的逆元。
	输出：x,y 分别表示a模b的逆元和b模a的逆元。
	返回：r 表示a b 的最大公约数。
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
	 * y2和y1分别是a和b的逆元
	 * （x1，y1，t1）用于求b的逆元，（x2，y2，t2）用于求a的逆元
	 * （x3，y3，t3）用于执行欧几里得算法
	 * （x1，y1）=（1，0），（x2，y2）=（0，1）执行一次变成（x1，y1）=（0，1）=（x2，y2）
	 * 即a的逆要先于b执行一步。
	 * */
	private static int ExtendEuclid(int a, int b){
		int x1 = 1, x2 = 0, x3 = b;
		int y1 = 0, y2 = 1, y3 = a;
		while(true){
			if(y3 == 0){
				System.out.println("a无逆元！");
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
