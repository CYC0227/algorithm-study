import java.util.*;

// 구현 - 게임 개발
public class ch4_4 {
	
	public static int n;
	public static int m;	
	public static int x;	// 시작 x좌표
	public static int y;	// 시작 y좌표
	public static int direct; // 바라보고 있는 방향 : 0북쪽, 1서쪽, 2남쪽, 3서쪽
	public static int[][] map = new int[50][50];	// 바다(1), 육지(0), 가본 곳(2) 저장하는 2차원 배열
	public static int[] dx = {-1,0,1,0};	// 북쪽으로 향할 때는 x좌표가 -1증가, 동쪽으로 향할 때는 x좌표가 0증가, 남쪽은 1증가, 서쪽은 0증가
	public static int[] dy = {0,1,0,-1};	// 북쪽으로 향할 때는 y좌표가 0증가, 동쪽으로 향할 때는 y좌표가 1증가, 남쪽은 0증가, 서쪽은 -1증가
	
	public static void turn_left() {
		
		direct--;
		
		// 북쪽에서 서쪽으로 돌 때는 0에서 3으로 돌아야하는데, -1이 되므로 임의로 바꿔준다.
		if(direct==-1)
			direct=3;
		
		return;
	}
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();	
		x = keyboard.nextInt();	// 시작 x좌표
		y = keyboard.nextInt();	// 시작 y좌표
		direct = keyboard.nextInt(); // 바라보고 있는 방향 : 0북쪽, 1서쪽, 2남쪽, 3서쪽
		
		// 지도 정보 읽기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = keyboard.nextInt();
			}
		}
		
		
		map[x][y] = 2;	// 현재 좌표 방문한 것으로 간주
		int turn = 1;	// 회전 횟수
		int result = 1;	// 방문한 칸 수 ( 시작점 포함 )
		
		while(true) {
			
			/* 왼족으로 4번 돌고 처음 방향을 바라볼 때 */
			if (turn==5) {
				
				/* 뒤로 갔을 때 바다가 아닌 경우 방향 유지하고 뒤로 한 칸 옮겨준다*/
				if(map[x-dx[direct]][y-dx[direct]] != 1) {
					x = x - dx[direct];
					y = y - dy[direct];
				}
				else	// 바다라면, 시뮬레이션 종료
					break;
			}
			
			turn_left();
			
			/* 방향대로 움직였을 때, 가보지 않은 땅이라면 앞으로 한 칸 간다. */
			if(map[x+dx[direct]][y+dy[direct]]==0) {
				x = x + dx[direct];
				y = y + dy[direct];
				map[x][y] = 2;
				result++;
				turn=0;
			}
			else
				turn++;
		}
		
		System.out.println(result);
	}

}
