// DFS - 음료수 얼려 먹기

import java.util.*;
public class ch5_3 {

	public static int n;
	public static int m;
	public static int[][] graph = new int[1000][1000]; // 그래프 저장하는 배열
	
	// dfs함수
	public static boolean dfs(int x,int y) {
		
		/* 배열 범위 밖의 값일 때는 제외시켜야 함*/
		if(x < 0 || x >= n || y < 0 || y >= m)
			return false;
		
		/* 현재 노드가 방문 안 된 상태라면 ( 0이라면 )*/
		if(graph[x][y] == 0) {
			// 방문처리 해줌
			graph[x][y]=1;
			
			/* 그 후 상하좌우의 노드를 재귀적으로 방문하면서 0인 곳이 있다면 방문처리를 해줌 -> 한 덩어리로 묶는 작업 */
			dfs(x-1,y); // 상
			dfs(x+1,y); // 하
			dfs(x,y-1); // 좌
			dfs(x,y+1); // 우
			
			/* main에서 호출된 dfs함수를 기준으로, 애초에 0이었으면 얼음 조각이 생긴 것으로 간주된다.
			     만약 위의 4개의 dfs가 false로 반환된다면, 그것은 얼음 한조각짜리 덩어리 인 것 이다. 
			     그러므로 이 if문에 들어왔다면 true를 반환하면 된다!
			     그렇지 않은 경우는 false를 반환해서 카운트 하지 못하게 한다.
			 */
			return true;
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		keyboard.nextLine(); // 다음 줄부터 한 줄씩 받아오기 위해 버퍼 비우기
		
		int result = 0; // 얼음 덩어리의 개수
		
		/* 그래프 정보 읽기 */
		for(int i=0;i<n;i++) {
			String str = keyboard.nextLine();
			for(int j=0;j<m;j++) {
				graph[i][j] = Character.getNumericValue(str.charAt(j));  // char to int
			}
		}
		
		/* 얼음 덩어리 몇 개인지 확인 : 배열 왼쪽 상단부터 오른쪽 하단까지 돌면서, dfs함수 실행 -> true값이면 얼음 한 덩어리 생긴 것. */
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				/* graph[i][j]가 현재 0이라면 dfs는 하나의 얼음덩어리를 만들고 그 얼음들을 1로 바꾼 후 true를 반환한다. 
				 * 만약  graph[i][j]가 1이라면 이미 얼음 덩어리로 간주되었거나, 칸막이인 경우기 때문에 dfs는 바로 false를 반환하기 때문에 카운트하지 않는다.*/
				if(dfs(i,j))
					result++;					
			}
		}
		
		System.out.println(result);
		
	}

}
