/*
 * �÷��̵��� ���� �־ �����ϱ� ���� ����!
 * ������ ���� Ǯ���ϱ� ������ �ȵ��ư�..�̤� 
 * �ٽ� ���� ���� ����
 * (��)
 * �ٽ� �⺻�� ���! ���� �ߴ� �ڵ� �ٽ� ���� Ʋ���� ã�� ��
 */
import java.util.*;

public class Q37 {

    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    // ����� ����(N), ������ ����(M)
    public static int n, m;
    // 2���� �迭(�׷��� ǥ��)�� �����
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // �ڱ� �ڽſ��� �ڱ� �ڽ����� ���� ����� 0���� �ʱ�ȭ
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // �� ������ ���� ������ �Է� �޾�, �� ������ �ʱ�ȭ
        for (int i = 0; i < m; i++) {
            // A���� B�� ���� ����� C��� ����
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // ���� ª�� ���� ������ ����
            if (c < graph[a][b]) graph[a][b] = c;
        }

        // ��ȭ�Ŀ� ���� �÷��̵� ���� �˰����� ����
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // ����� ����� ���
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // ������ �� ���� ���, ����(INFINITY)�̶�� ���
                if (graph[a][b] == INF) {
                    System.out.print(0 + " ");
                }
                // ������ �� �ִ� ��� �Ÿ��� ���
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}