//16분
import java.util.*;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		//int input = Integer.parseInt(s);// 숫자로 변환	
		//int[] arr = new int [input];
		int[] arr = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
			//System.out.println(arr[i]);
		}
		
		// 계산
		int result = arr[0];
		for(int i=0; i<s.length()-1; i++) {
			if(result==0) {
				result = result + arr[i+1];
			}
			else {
				result = result * arr[i+1];
			}
		}
		
		System.out.println(result);
	}

}
