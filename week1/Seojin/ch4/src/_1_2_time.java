import java.util.*;

public class _1_2_time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		String sum;
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=59; j++) {
				for(int l=0; l<=59; l++) {
					//String���� �ٲ�
					//String str = i + "" + j + "" + l;
					String istr = Integer.toString(i);
					String jstr = Integer.toString(j);
					String lstr = Integer.toString(l);
					
					//System.out.println(istr);
					//System.out.println(jstr);
					//System.out.println(lstr);
					
					//sum = istr.concat(jstr);
					//sum = sum.concat(lstr);
					sum = istr + jstr + lstr;
					
					for(int p=0; p<sum.length(); p++) {
						if(sum.charAt(p) == '3') {
							result++;
							break;
						}
					}
					
				}
			}
		}
		
		System.out.println(result);
	}

}

//////////����//////////
/*
import java.util.*;

public class _1_2_time {
	
	//Ư���� �ð� �ȿ� '3'�� ���ԵǾ� �ִ����� ����
	public static boolean check(int h, int m, int s) {
		if(h%10 == 3 || m/10 == 3 || m%10 == 3 || s/10 == 3 || s%10 == 3) {
			return true;
		return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// H�� �Է¹ޱ�
		int h = sc.nextInt();
		int cnt = 0;
		
		for(int i=0; i<=h; i++) {
			for(int j=0; j<60; j++) {
				for(int k=0; k<60; k++) {
					// �� �ð� �ȿ� '3'�� ���ԵǾ� �ִٸ� ī��Ʈ ����
					if(check(i,j,k)) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
*/















