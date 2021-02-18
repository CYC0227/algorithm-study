/*
 * �� 55��
 * ó���� n�� m�� �ݴ�� �׸� �׸������� �ð�����
 * �迭�� nxm ũ�⸸ŭ �س��Ƽ� �� ũ�⸦ �����(��:������ �Ʒ�), ������ ������ -> �׷��� arr�迭 ũ�⸦ 21x21�� ������ ���� �ذ� 
 * -> �̶��� �̷��� Ǯ�� �ʰ� �� �� �ִ� �����? ���������� 20x20���� ��
 * 
 * (��) 
 * �̷��� ������ ��� �ϳ��ϳ� �����Ϸ��� ��� �ȵǰ�, �����ϰ� ��������!
 * dp�� ��ȭ�� ������̱� ������ �����ʿ������Ͱ� �ƴ϶� ���� �������� �����ؾ��Ѵ�.
 * -> ����, ������, ���ʾƷ����� ���� ��� 3���� 
 *  !!�׳� dp�� �ϳ��� ����!!
 */
import java.util.*;

public class Q31 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {//�׽�Ʈ ���̽�
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[21][21];
			int[][] d = new int[n][m];//���̳��� ���α׷���
			
			for(int j=0; j<n; j++) {//arr�� �ݱ� �� �ֱ�
				for(int l=0; l<m; l++) {
					arr[j][l] = sc.nextInt();
				}
			}
			
			//���̳��� ���α׷���
			//ó���� �� �߿��� ���� ū �� ����
			int max = 0;
			int cnt = 0;// j�� ������ �����ϴ� ����
			for(int j=0; j<n; j++) {
				if(max < arr[j][0]) {
					max = arr[j][0]; 
					cnt = j;
				}
			}
			d[cnt][0] = max;
			
			//������ ��, ������, ������ �Ʒ�
			//int[] dx = {-1, 0, 1};
			//int[] dy = 1���ϸ� �Ǳ� ������
			for(int j=1; j<m; j++) {//m-1�� �ݺ�
				if(arr[cnt-1][j] >= arr[cnt][j] && arr[cnt-1][j] >= arr[cnt+1][j]) {
					d[cnt-1][j] = arr[cnt-1][j];
					cnt = cnt-1;
				}
				else if(arr[cnt][j] >= arr[cnt-1][j] && arr[cnt][j] >= arr[cnt+1][j]) {
					d[cnt][j] = arr[cnt-1][j];
				}
				else {
					d[cnt+1][j] = arr[cnt+1][j];
					cnt = cnt+1;
				}
			}
			
			//d�迭 �� ��� ���ϱ�
			int sum = 0;
			for(int j=0; j<n; j++) {
				for(int l=0; l<m; l++) {
					sum += d[j][l];
				}
			}
			System.out.println(sum);
		}
	}

}

//////////����//////////
/*
import java.util.*;

public class Main {
	
    static int testCase, n, m;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // �׽�Ʈ ���̽�(Test Case) �Է�
        testCase = sc.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            // �ݱ� ���� �Է�
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // ���̳��� ���α׷����� ���� 2���� DP ���̺� �ʱ�ȭ
             * ���⼭�� �ѽθ� arr�迭�� dp�迭���ٰ� �Ȱ��� ������!
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = arr[i][j];
                }
            }
            // ���̳��� ���α׷��� ����
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, leftDown, left;
                    // ���� ������ ���� ���
                    if (i == 0) leftUp = 0; //*�ε����� ����� ���
                    else leftUp = dp[i - 1][j - 1];
                    // ���� �Ʒ����� ���� ���
                    if (i == n - 1) leftDown = 0; //*�ε����� ����� ���
                    else leftDown = dp[i + 1][j - 1];
                    // ���ʿ��� ���� ���
                    left = dp[i][j - 1];
                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
*/
