/*
 * �� 20��
 * �ٵ� �̰� ���� �� �˾Ƽ� Ǯ���ٱ� ���ٴ� ���� Ǯ����, Ǯ�鼭 �׳� ��ġ�� �ǰڰŴ� �ϰ� ǰ
 * ���� �ڵ��� ��, ����� �������� ���ϰ� ���� �ޱ��� �ణ ���������� ǰ
 *  
 */
import java.util.*;

public class Q35 {
	
	public static int[] arr = new int[1001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 1;//���ڼ���
		int result = 1;
		//for(int i=1; i<=n; i++) {//n��°
		while(result!=n+1) {
			if(cnt==1) {
				arr[cnt] = cnt;
				result++;
			}
			else if(cnt%2==0 || cnt%3==0 || cnt%5==0) {
				arr[cnt] = cnt;
				result++;
			}
			System.out.println(arr[cnt]);
			cnt++;
		}
		
		System.out.println(arr[cnt-1]);
		
	}

}
