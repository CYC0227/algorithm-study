import java.util.*;

// ���� - �ս��� ����Ʈ
public class ch4_3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String[] input = keyboard.next().split("");
		
		int row = Integer.parseInt(input[1]);	// ���ڿ����� �ڿ� ������ ���� ����
		int col = (int)(input[0].charAt(0)) - 96;	// �տ� ������ ���� ����
		int result = 0;
		
		// ������ �� �ִ� ��츦 �迭�� ����
		int[][] move = { {2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2} };
		
		// �����̴� ��찡 8����
		for(int i=0;i<8;i++) {
			int temp_r=row;
			int temp_c=col;
			
			temp_r+=move[i][0];
			temp_c+=move[i][1];
			
			// ���� ü���� ������ ������ ��� count���� �ʰ� ���� ��� ����ϱ�
			if(temp_r<1 || temp_r>8 || temp_c<1 || temp_c>8)
				continue;
			result++;
		}
		
		System.out.println(result);

	}

}
