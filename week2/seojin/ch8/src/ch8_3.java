import java.util.*;

public class ch8_3 {
	
	public static int[] d = new int[100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] k = new int[n];
		for(int i=0; i<n; i++) {
			k[i] = sc.nextInt();
		}
		
		// ���̳��� ���α׷���
		d[0] = k[0];
		d[1] = Math.max(d[0], k[1]);
		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i-1], d[i-2] + k[i]);// ���� �ķ� â�� �б� ����
		}
		
		System.out.println(d[n-1]);
	}

}
