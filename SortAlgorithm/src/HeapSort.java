
public class HeapSort {
	public static void main(String[] args) {
		int[] num = {3,1,5,7,2,4,9,6,10,8}; 
		System.out.println("����ǰ�����ݣ�");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		HeapSort.heapSort(num, num.length);
		
		System.out.println("���������ݣ�");
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
	
	private static void heapSort(int[] num, int len){
		/** ��ʼ����
		 * ��ʼ�ѽ��е��� 
		 * ��num[0..length-1]���ɶ� 
		 * ������֮���һ��Ԫ�������е���С��Ԫ�� 
		 */ 
		for(int i = (len - 1) / 2; i >= 0; i--){  //��Ҷ�ڵ�������ֵΪsize/2,sizeΪ����Ԫ�������±�
			headAdjust(num, i, len);
		}
		
		//�����һ��Ԫ�ؿ�ʼ�����н��е���  
	    for (int i = len - 1; i > 0; i--)  
	    {  
	        //�����Ѷ�Ԫ��H[0]�Ͷ������һ��Ԫ��  
	        int temp = num[i]; 
	        num[i] = num[0]; 
	        num[0] = temp;  
	        //ÿ�ν����Ѷ�Ԫ�غͶ������һ��Ԫ��֮�󣬶�Ҫ�Զѽ��е���  
	        headAdjust(num,0,i);  
	  }  
	}
	
	/** 
	 * ��֪H[s��m]����H[s] �������ѵĶ��� 
	 * ����H[s],ʹ���Ϊ�󶥶�.�����Ե�s�����Ϊ��������ɸѡ,  
	 * 
	 * @param H�Ǵ������Ķ����� 
	 * @param s�Ǵ�����������Ԫ�ص�λ�� 
	 * @param length������ĳ��� 
	 * 
	 */ 
	public static void headAdjust(int[] H, int s, int length){
	    int tmp  = H[s];  
	    int child = 2*s+1; //���ӽ���λ�á�(i+1 Ϊ��ǰ���������Һ��ӽ���λ��)  
	    while (child < length) {  
	        if(child+1 <length && H[child]>H[child+1]) { // ����Һ��Ӵ�������(�ҵ��ȵ�ǰ����������ĺ��ӽ��)  
	            ++child ;  
	        }  
	        if(H[s]>H[child]) {  // ����ϴ���ӽ����ڸ����  
	            H[s] = H[child]; // ��ô�ѽϴ���ӽ�������ƶ����滻���ĸ����  
	            s = child;       // ��������s ,������������һ������λ��  
	            child = 2*s+1;  
	        }  else {            // �����ǰ�������������������Һ��ӣ�����Ҫ������ֱ���˳�  
	             break;  
	        }  
	        H[s] = tmp;         // ��ǰ�������Ľ��ŵ������ĺ��ӽ��λ����  
	    }  
	}
}
