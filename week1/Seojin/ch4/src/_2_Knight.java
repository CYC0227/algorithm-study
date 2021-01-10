import java.util.*;

public class _2_Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char ccol = input.charAt(0);
		char crow = input.charAt(1);
		int result = 0;
		
		//input값 int형으로 변환
		int row = Character.getNumericValue(crow);
		int col = 0;
		if(ccol == 'a') col = 1; 
		if(ccol == 'b') col = 2; 
		if(ccol == 'c') col = 3; 
		if(ccol == 'd') col = 4; 
		if(ccol == 'e') col = 5; 
		if(ccol == 'f') col = 6; 
		if(ccol == 'g') col = 7; 
		if(ccol == 'h') col = 8; 
		
		
		// 1. 수평으로 두 칸 이동 후, 수작으로 한 칸 이동
		//이동방향 
		int[] dx = {-1, 1, -1, 1};
		int[] dy = {2, 2, -2, -2};
		
		 for(int i=0; i<4; i++) {
			 //이동 후의 좌표
			 int nx = row, ny = col;
			 nx += dx[i];
			 ny += dy[i];
			 
			 //예외
			 if(nx<=0 || nx>=9 || ny<=0 || ny>=9) continue;
			 
			 result++;
		 }
		 
		// 2. 수직으로 두 칸 이동 후, 수평으로 한 칸 이동
		 int[] dx2 = {2, 2, -2, -2};
			int[] dy2 = {-1, 1, -1, 1};
			
			 for(int i=0; i<4; i++) {
				 //이동 후의 좌표
				 int nx = row, ny = col;
				 nx += dx2[i];
				 ny += dy2[i];
				 
				 //예외
				 if(nx<=0 || nx>=9 || ny<=0 || ny>=9) continue;
				 
				 result++;
			 }
		 
		 
		System.out.println(result);
	}

}

//////////답지//////////
/*
import java.util.*;

public class _2_2Knight {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 현재 나이트의 위치 입력받기
		String inputData = sc.nextLine();
		int row = inputData.charAt(1) - '0';
		int column = inputData.charAt(0) - 'a' + 1;
		
		//나이트가 이동할 수 있는 8가지 방향 정의
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		//8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
		int result = 0;
		for(int i=0; i<8; i++) {
			// 이동하고자 하는 위치 확인
			int nextRow = row + dx[i];
			int nextColumn = column + dy[i];
			//해당 위치로 이동이 가능하다면 카운트 증가
			if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
		}
	
		 System.out.println(result);
	}
}
*/












