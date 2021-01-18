// �÷��̵� ���� ���� -> ��� �� -> ��� �� �̱� ������ ���� �÷��̵� �������� �� �� �־���
import java.util.*;

public class ch9_2 {

    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    // ����� ����(N), ������ ����(M), ���� �� ���(X), ���� ������ ���(K)
    public static int n, m, x, k;
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
            // A�� B�� ���ο��� ���� ����� 1�̶�� ����
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // ��ȭ�Ŀ� ���� �÷��̵� ���� �˰����� ����
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // ����� ����� ���
        int distance = graph[1][k] + graph[k][x];

        // ������ �� ���� ���, -1�� ���
        if (distance >= INF) {
            System.out.println(-1);
        }
        // ������ �� �ִٸ�, �ִ� �Ÿ��� ���
        else {
            System.out.println(distance);
        }
    }
}