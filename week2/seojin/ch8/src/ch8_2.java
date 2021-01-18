import java.util.*;

public class ch8_2 {

    // �ռ� ���� ����� �����ϱ� ���� DP ���̺� �ʱ�ȭ 
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // ���̳��� ���α׷���(Dynamic Programming) ����(���Ҿ�)
        for (int i = 2; i <= x; i++) {// 1�� ������ �ϱ� ������ i�� 2���� ����
            // ������ ������ 1�� ���� ���
            d[i] = d[i - 1] + 1;// 1 ���ϴ� ���� Ƚ���� ���ϱ� ���� -> Ƚ�� ���� ���� �� DP���̺� ����!
            //1�� ���� ���� ���� �ٸ� �Ͱ� ���ʴ�� ��!
            
            // ������ ���� 2�� ������ �������� ���
            if (i % 2 == 0) {
            	System.out.print(d[i] + " , " + (d[i/2]+1) + " -> ");
                d[i] = Math.min(d[i], d[i / 2] + 1);
                System.out.println(d[i]);
            }
            // ������ ���� 3���� ������ �������� ���
            if (i % 3 == 0) {
            	System.out.print(d[i] + " , " + (d[i/3]+1) + " -> ");
            	d[i] = Math.min(d[i], d[i / 3] + 1);
            	System.out.println(d[i]);
            }
            // ������ ���� 5�� ������ �������� ���
            if (i % 5 == 0) {
            	System.out.print(d[i] + " , " + (d[i/5]+1) + " -> ");
            	d[i] = Math.min(d[i], d[i / 5] + 1);
            	System.out.println(d[i]);
            }
        }

        System.out.println(d[x]);
    }
}
