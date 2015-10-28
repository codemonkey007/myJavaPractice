package appeartimes;

import java.util.Scanner;

public class AppearTimes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input test String:");
		String str = sc.nextLine();
		Scanner subsc = new Scanner(System.in);
		System.out.print("Input the subString:");
		String subStr = subsc.nextLine();
		
		int count = 0;
		int start = 0;
		while(str.indexOf(subStr, start) >= 0 && start < str.length()){
			count++;
//			start = str.indexOf(subStr, start) + subStr.length();
			start = str.indexOf(subStr, start) + 1;
		}
		
		System.out.println(subStr + "在" + str + "中出现的次数为：" + count);
	}
}
