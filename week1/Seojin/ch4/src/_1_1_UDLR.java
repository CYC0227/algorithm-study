import java.util.*;

public class _1_1_UDLR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//int[][] map = new int[5][5];
		
		String str = sc.nextLine();// nextLine은 엔터값을 기준으로 메소드를 종료시키기 때문에 남아있는 엔터값을 없애줘야 함!
		str = sc.nextLine();
		String[] arr = str.split(" ");
		
		//
		int x=1, y=1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].charAt(0)=='L') {
				y--;
				if(y == 0) y++;//무시
			}
			if(arr[i].charAt(0)=='R') {
				y++;
				if(y == N) y--;
			}
			if(arr[i].charAt(0)=='U') {
				x--;
				if(x == 0) x++;
			}
			if(arr[i].charAt(0)=='D') {
				x++;
				if(x == N) x--;
			}		
		}
		
		System.out.println(x + " " + y);
		
	}

}

//////////답지//////////
/*
import java.util.*;

public class _1_1_UDLR {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N을 입력받기
		 int n = sc.nextInt();
		 sc.nextLine(); // 버퍼 비우기
		 String[] plans = sc.nextLine().split(" ");
		 int x=1, y=1;
		 
		 // L, R, U, D에 따른 이동 방향
		 int[] dx = {0, 0, -1, 1};
		 int[] dy = {-1, 1, 0, 0};
		 char[] moveTypes = {'L', 'R', 'U', 'D'};
		 
		 // 이동 계획을 하나씩 획인
		 for(int i=0; i<plans.length; i++) {
			 char plan = plans[i].charAt[0];
			 //이동 후 좌표 구하기
			 int nx = -1, ny = -1;
			 for(int j=0; j<4; j++) {
				if(plan == moveTyes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			 }
			 // 공간을 벗어나는 경우 무시
			 if(nx<1 || ny<1 || nx>n || ny>n) continue;
			 //이동 수행;
			 x = nx;
			 y = ny;
		 }
		 
		 System.out.println(x + " " + y);
	}
}	
*/
	
	
	
	
	
	
	
	
	
	
	
	
