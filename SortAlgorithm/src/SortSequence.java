import java.util.Arrays;
import java.util.Random;


public class SortSequence {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] array = new int[15];
		System.out.println("排序前的数据：");
		for(int i = 0; i < array.length; i++){
			array[i] = rd.nextInt(20);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(array);
		System.out.println("排序后的数据：");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
