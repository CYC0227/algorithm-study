import java.util.*;
// ���� - �����¿�
public class ch4_1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt(); // 2���� �迭�� ũ�� 
		keyboard.nextLine(); // ���ڿ� �� ���� �Է¹ޱ� ���� ���� ���� **�߿�**
		String[] move = keyboard.nextLine().split(" ");	// �� ��° �ٿ��� �Է¹��� String�� ������ �������� split�ؼ� move �迭�� ����		
		int x=1;	// ���κ�ȭ : 1
		int y=1;	// ���κ�ȭ : 1
		
		/* ��ȹ��� �����̱� */
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
