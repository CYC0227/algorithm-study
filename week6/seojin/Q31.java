/*
 * 약 55분
 * 처음에 n과 m을 반대로 그린 그림때문에 시간날림
 * 배열을 nxm 크기만큼 해놓아서 그 크기를 벗어나면(예:오른쪽 아래), 오류가 나버림 -> 그래서 arr배열 크기를 21x21로 넓혀서 문제 해결 
 * -> 이때에 이렇게 풀지 않고 할 수 있는 방법은? 답지에서도 20x20으로 줌
 * 
 * (답) 
 * 이러한 문제는 깊게 하나하나 생각하려고 들면 안되고, 간단하게 생각하자!
 * dp는 점화식 세우기이기 때문에 오른쪽에서부터가 아니라 왼쪽 기준으로 생각해야한다.
 * -> 왼쪽, 왼쪽위, 왼쪽아래에서 오는 경우 3가지 
 *  !!그냥 dp를 하나씩 갱신!!
 */
import java.util.*;

public class Q31 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {//테스트 케이스
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[21][21];
			int[][] d = new int[n][m];//다이나믹 프로그래밍
			
			for(int j=0; j<n; j++) {//arr에 금광 수 넣기
				for(int l=0; l<m; l++) {
					arr[j][l] = sc.nextInt();
				}
			}
			
			//다이나믹 프로그래밍
			//처음에 행 중에서 가장 큰 수 저장
			int max = 0;
			int cnt = 0;// j가 뭐인지 저장하는 변수
			for(int j=0; j<n; j++) {
				if(max < arr[j][0]) {
					max = arr[j][0]; 
					cnt = j;
				}
			}
			d[cnt][0] = max;
			
			//오른쪽 위, 오른쪽, 오른쪽 아래
			//int[] dx = {-1, 0, 1};
			//int[] dy = 1더하면 되기 때문에
			for(int j=1; j<m; j++) {//m-1번 반복
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
			
			//d배열 값 모두 더하기
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

//////////답지//////////
/*
import java.util.*;

public class Main {
	
    static int testCase, n, m;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스(Test Case) 입력
        testCase = sc.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            // 금광 정보 입력
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
             * 여기서는 앗싸리 arr배열을 dp배열에다가 똑같이 복사함!
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = arr[i][j];
                }
            }
            // 다이나믹 프로그래밍 진행
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, leftDown, left;
                    // 왼쪽 위에서 오는 경우
                    if (i == 0) leftUp = 0; //*인덱스를 벗어나는 경우
                    else leftUp = dp[i - 1][j - 1];
                    // 왼쪽 아래에서 오는 경우
                    if (i == n - 1) leftDown = 0; //*인덱스를 벗어나는 경우
                    else leftDown = dp[i + 1][j - 1];
                    // 왼쪽에서 오는 경우
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
