import java.util.*;

public class Main {

    // ������ ����, ������ ����, �Ÿ� ����, ��� ���� ��ȣ
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // ��� ���ÿ� ���� �ִ� �Ÿ� �ʱ�ȭ
    public static int[] d = new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // �׷��� �� �ִ� �Ÿ� ���̺� �ʱ�ȭ
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        // ��� ���� ���� �Է� �ޱ�
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        // ��� ���ñ����� �Ÿ��� 0���� ����
        d[x] = 0;

        // �ʺ� �켱 Ž��(BFS) ����
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            // ���� ���ÿ��� �̵��� �� �ִ� ��� ���ø� Ȯ��
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                // ���� �湮���� ���� ���ö��
                if (d[nextNode] == -1) {
                    // �ִ� �Ÿ� ����
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        // �ִ� �Ÿ��� K�� ��� ������ ��ȣ�� ������������ ���
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        // ���� �ִ� �Ÿ��� K�� ���ð� ���ٸ�, -1 ���
        if (!check) System.out.println(-1);
    }
}