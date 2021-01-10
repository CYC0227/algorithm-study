import java.util.*;

// ���� - ���� ����
public class ch4_4 {
	
	public static int n;
	public static int m;	
	public static int x;	// ���� x��ǥ
	public static int y;	// ���� y��ǥ
	public static int direct; // �ٶ󺸰� �ִ� ���� : 0����, 1����, 2����, 3����
	public static int[][] map = new int[50][50];	// �ٴ�(1), ����(0), ���� ��(2) �����ϴ� 2���� �迭
	public static int[] dx = {-1,0,1,0};	// �������� ���� ���� x��ǥ�� -1����, �������� ���� ���� x��ǥ�� 0����, ������ 1����, ������ 0����
	public static int[] dy = {0,1,0,-1};	// �������� ���� ���� y��ǥ�� 0����, �������� ���� ���� y��ǥ�� 1����, ������ 0����, ������ -1����
	
	public static void turn_left() {
		
		direct--;
		
		// ���ʿ��� �������� �� ���� 0���� 3���� ���ƾ��ϴµ�, -1�� �ǹǷ� ���Ƿ� �ٲ��ش�.
		if(direct==-1)
			direct=3;
		
		return;
	}
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();	
		x = keyboard.nextInt();	// ���� x��ǥ
		y = keyboard.nextInt();	// ���� y��ǥ
		direct = keyboard.nextInt(); // �ٶ󺸰� �ִ� ���� : 0����, 1����, 2����, 3����
		
		// ���� ���� �б�
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = keyboard.nextInt();
			}
		}
		
		
		map[x][y] = 2;	// ���� ��ǥ �湮�� ������ ����
		int turn = 1;	// ȸ�� Ƚ��
		int result = 1;	// �湮�� ĭ �� ( ������ ���� )
		
		while(true) {
			
			/* �������� 4�� ���� ó�� ������ �ٶ� �� */
			if (turn==5) {
				
				/* �ڷ� ���� �� �ٴٰ� �ƴ� ��� ���� �����ϰ� �ڷ� �� ĭ �Ű��ش�*/
				if(map[x-dx[direct]][y-dx[direct]] != 1) {
					x = x - dx[direct];
					y = y - dy[direct];
				}
				else	// �ٴٶ��, �ùķ��̼� ����
					break;
			}
			
			turn_left();
			
			/* ������ �������� ��, ������ ���� ���̶�� ������ �� ĭ ����. */
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
