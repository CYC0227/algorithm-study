import java.util.*;

// ���� - �ð�
public class ch4_2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int count=0;
		
		// 00�� 00�� 00�ʺ��� N�� 59�� 59�ʱ��� ���� Ȯ��
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					/* �ð�,��,�� �� String���� ��ȯ���Ѽ� �� �������� ��ȯ�ϰ�, contains�� ����ؼ� 3�� �ִ��� Ȯ��  */
					String time = Integer.toString(i)+Integer.toString(j)+Integer.toString(k);
					if(time.contains("3"))
						count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
