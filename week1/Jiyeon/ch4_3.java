import java.util.*;

// 구현 - 왕실의 나이트
public class ch4_3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String[] input = keyboard.next().split("");
		
		int row = Integer.parseInt(input[1]);	// 문자열에서 뒤에 나오는 값이 가로
		int col = (int)(input[0].charAt(0)) - 96;	// 앞에 나오는 값이 세로
		int result = 0;
		
		// 움직일 수 있는 경우를 배열에 저장
		int[][] move = { {2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2} };
		
		// 움직이는 경우가 8가지
		for(int i=0;i<8;i++) {
			int temp_r=row;
			int temp_c=col;
			
			temp_r+=move[i][0];
			temp_c+=move[i][1];
			
			// 말이 체스판 밖으로 나갔을 경우 count하지 않고 다음 경우 계산하기
			if(temp_r<1 || temp_r>8 || temp_c<1 || temp_c>8)
				continue;
			result++;
		}
		
		System.out.println(result);

	}

}
