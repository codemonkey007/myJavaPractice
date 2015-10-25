package euclid;

public class Euclid {
	
	public static void main(String[] args) {
		int a = 288, b = 158;
		System.out.println("gcd(" + a + ","+ b+")=" + Euclid(a, b));
	}
	
	private static int Euclid(int a, int b){
		int x = a, y = b, r;
		if(y == 0){
			return x;
		}
		while(y != 0){
			r = x % y;
			x = y;
			y = r;
		}
		return Euclid(x, y);
	}
}
