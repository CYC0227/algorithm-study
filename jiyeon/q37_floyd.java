// chapter 17 최단경로문제 - 37번 ) 플로이드
package shortestPath;
import java.util.*;

public class q37_floyd {
	public static int n; // 도시 개수 n
	public static int m; // 버스 개수 m
	public static int[][]arr; 
	public static final int INF = 100000;
	
	public static void main(String[] args) {
		/* 실습시간 : 12 분 ( 1026 ~ 1038 ) 
		 * 플로이드 워셜 문제랑 똑.같.음
		 * k써서 ij로 바로 갈 때랑 k 거쳐서 ik+kj로 갈 때랑 비교해서 작은 값 사용
		 * 실습 예제에서는 별 문제 없었지만, '도달할 수 없는 경우는 0을 출력한다'라는 말을 생각 못함. INF인 경우에 0으로 바꿔주는 작업까지 해야 정답임!
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		arr = new int[n+1][n+1]; // 도시개수만큼 2차원 배열. 도시간의 거리를 나타내기 위함
		
		// 우선 모든 도시간의 거리는 INF
		for(int i=0;i<=n;i++) {
			Arrays.fill(arr[i], INF);
		}
		
		// 자기 자신으로 가는 것은 0 ( 없음 )
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					arr[i][j] = 0;
			}
		}
		
		// 버스 개수 m개만큼 도시간의 거리 정보를 update해준다
		for(int i=0;i<m;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			int c = keyboard.nextInt();
			
			// 기존에 있던 배열값과, 새로 들어온 거리 c값을 비교해서 작은 값으로 넣어줌
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		/* floyd-warshall 방법
		 * 앞에까지 적어놓은 것은, 각 도시별로 경유 없이 가는 방법이다.
		 * 아래의 for문을 통해 경유해서 갔을 때 최단거리가 생기는지 floyd-warshall로 판단 가능
		 * k를 경유해서 arr[i][j]값과 arr[i][k] + arr[k][j]비교
		 * */
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = Math.min(arr[i][j] , arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
