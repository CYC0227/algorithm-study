import java.util.*;

public class _1_1_UDLR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//int[][] map = new int[5][5];
		
		String str = sc.nextLine();// nextLine�� ���Ͱ��� �������� �޼ҵ带 �����Ű�� ������ �����ִ� ���Ͱ��� ������� ��!
		str = sc.nextLine();
		String[] arr = str.split(" ");
		
		//
		int x=1, y=1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].charAt(0)=='L') {
				y--;
				if(y == 0) y++;//����
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

//////////����//////////
/*
import java.util.*;

public class _1_1_UDLR {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N�� �Է¹ޱ�
		 int n = sc.nextInt();
		 sc.nextLine(); // ���� ����
		 String[] plans = sc.nextLine().split(" ");
		 int x=1, y=1;
		 
		 // L, R, U, D�� ���� �̵� ����
		 int[] dx = {0, 0, -1, 1};
		 int[] dy = {-1, 1, 0, 0};
		 char[] moveTypes = {'L', 'R', 'U', 'D'};
		 
		 // �̵� ��ȹ�� �ϳ��� ȹ��
		 for(int i=0; i<plans.length; i++) {
			 char plan = plans[i].charAt[0];
			 //�̵� �� ��ǥ ���ϱ�
			 int nx = -1, ny = -1;
			 for(int j=0; j<4; j++) {
				if(plan == moveTyes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			 }
			 // ������ ����� ��� ����
			 if(nx<1 || ny<1 || nx>n || ny>n) continue;
			 //�̵� ����;
			 x = nx;
			 y = ny;
		 }
		 
		 System.out.println(x + " " + y);
	}
}	
*/
	
	
	
	
	
	
	
	
	
	
	
	
