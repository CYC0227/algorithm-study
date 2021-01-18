// ��ȭ�� ������ ����
// �� �ε����� ���� �� �Ұ����� ���� �δ��� �������� ����
import java.util.*;

public class ch8_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ���� N, M�� �Է¹ޱ�
        int n = sc.nextInt();
        int m = sc.nextInt();

        // N���� ȭ�� ���� ������ �Է� �ޱ�
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // �ռ� ���� ����� �����ϱ� ���� DP ���̺� �ʱ�ȭ 
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        // ���̳��� ���α׷���(Dynamic Programming) ����(���Ҿ�)
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                // (i - k)���� ����� ����� �����ϴ� ���
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        // ���� ��� ���
        if (d[m] == 10001) { // ���������� M���� ����� ����� ���� ���
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
    }
}