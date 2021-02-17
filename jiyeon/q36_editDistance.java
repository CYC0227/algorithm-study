// chapter 16 ���̳��� ���α׷��� - 36�� ) ���� �Ÿ�
package dp;
import java.util.*;

public class q36_editDistance {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 28 �� ( 0956 ~ 1024) */
		Scanner keyboard = new Scanner(System.in);
		
		String str1; // ���� string
		String str2; // ���� string
		
		str1 = keyboard.nextLine();
		str2 = keyboard.nextLine();
		
		int[][] dp = new int[str2.length()+1][str1.length()+1]; // �����ٿ� ���� string, �����ٿ� ���� string ��ġ
		
		// �迭 �ʱ�ȭ
		dp[0][0] = 0;
		for(int i=1;i<str1.length()+1;i++) {
			dp[0][i] = i;
		}
		for(int i=1;i<str2.length()+1;i++) {
			dp[i][0] = i;
		}
		
		// ����, ����, ��ü�� 1�� �����Ѵ�. 
		// �̶� ������ ���ʿ��� ����, ������ ���ʿ���, ��ü�� ���� ������ �´�.
		// �迭�� �� ĭ���� �������� �����ٷ� �Ǳ� ���ؼ� �ʿ��� �ּҰ��� ã�� ��
		
		for(int i=1;i<str2.length()+1;i++) {
			for(int j=1;j<str1.length()+1;j++) {
				// �� ���ڰ� ��ġ�ϸ�, �ƹ� ���� �� �� ( ���� ������ �״�� �� ������ )
				if(str1.charAt(j-1) == str2.charAt(i-1))
					dp[i][j] = dp[i-1][j-1];
				// ��ġ���� ������ ��,��,���� �� �� �ּҿ��� 1 ���� ( �� : ����, �� : ����, ���� : ��ü )
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
				}
			}
		}
		
		System.out.println(dp[str2.length()][str1.length()]);
		
	}

}
