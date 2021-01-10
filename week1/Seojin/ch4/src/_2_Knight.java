import java.util.*;

public class _2_Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char ccol = input.charAt(0);
		char crow = input.charAt(1);
		int result = 0;
		
		//input�� int������ ��ȯ
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
		
		
		// 1. �������� �� ĭ �̵� ��, �������� �� ĭ �̵�
		//�̵����� 
		int[] dx = {-1, 1, -1, 1};
		int[] dy = {2, 2, -2, -2};
		
		 for(int i=0; i<4; i++) {
			 //�̵� ���� ��ǥ
			 int nx = row, ny = col;
			 nx += dx[i];
			 ny += dy[i];
			 
			 //����
			 if(nx<=0 || nx>=9 || ny<=0 || ny>=9) continue;
			 
			 result++;
		 }
		 
		// 2. �������� �� ĭ �̵� ��, �������� �� ĭ �̵�
		 int[] dx2 = {2, 2, -2, -2};
			int[] dy2 = {-1, 1, -1, 1};
			
			 for(int i=0; i<4; i++) {
				 //�̵� ���� ��ǥ
				 int nx = row, ny = col;
				 nx += dx2[i];
				 ny += dy2[i];
				 
				 //����
				 if(nx<=0 || nx>=9 || ny<=0 || ny>=9) continue;
				 
				 result++;
			 }
		 
		 
		System.out.println(result);
	}

}

//////////����//////////
/*
import java.util.*;

public class _2_2Knight {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ���� ����Ʈ�� ��ġ �Է¹ޱ�
		String inputData = sc.nextLine();
		int row = inputData.charAt(1) - '0';
		int column = inputData.charAt(0) - 'a' + 1;
		
		//����Ʈ�� �̵��� �� �ִ� 8���� ���� ����
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		//8���� ���⿡ ���Ͽ� �� ��ġ�� �̵��� �������� Ȯ��
		int result = 0;
		for(int i=0; i<8; i++) {
			// �̵��ϰ��� �ϴ� ��ġ Ȯ��
			int nextRow = row + dx[i];
			int nextColumn = column + dy[i];
			//�ش� ��ġ�� �̵��� �����ϴٸ� ī��Ʈ ����
			if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
		}
	
		 System.out.println(result);
	}
}
*/












