import java.util.*;
// 구현 - 상하좌우
public class ch4_1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt(); // 2차원 배열의 크기 
		keyboard.nextLine(); // 문자열 한 줄을 입력받기 위해 버퍼 비우기 **중요**
		String[] move = keyboard.nextLine().split(" ");	// 두 번째 줄에서 입력받은 String을 공백을 기준으로 split해서 move 배열에 저장		
		int x=1;	// 세로변화 : 1
		int y=1;	// 가로변화 : 1
		
		/* 계획대로 움직이기 */
		for(int i=0;i<move.length;i++) {

			switch (move[i]) {
			case "L" :
				if(y==1)
					break;
				y--;
				break;
			case "R" :
				if(y==n)
					break;
				y++;
				break;
			case "U" :
				if(x==1)
					break;
				x--;
				break;
			case "D" :
				if(x==n)
					break;
				x++;
				break;
			default :
				break;			
			}
			
		}
		
		System.out.println(x+" "+y);

	}

}
