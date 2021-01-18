// ���� ���� -> ��������
// �ڵ� �ڼ��� ���� ���� -> �ٽ� �� �� ��.��
import java.util.*;

public class ch10_4 {

    // ����� ����(V)
    public static int v;
    // ��� ��忡 ���� ���������� 0���� �ʱ�ȭ
    public static int[] indegree = new int[501];
    // �� ��忡 ����� ���� ������ ��� ���� ���� ����Ʈ �ʱ�ȭ
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // �� ���� �ð��� 0���� �ʱ�ȭ
    public static int[] times = new int[501];

    // ���� ���� �Լ�
    public static void topologySort() {
        int[] result = new int[501]; // �˰��� ���� ����� ���� �迭
        for (int i = 1; i <= v; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>(); // ť ���̺귯�� ���

        // ó�� ������ ���� ���������� 0�� ��带 ť�� ����
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // ť�� �� ������ �ݺ�
        while (!q.isEmpty()) {
            // ť���� ���� ������
            int now = q.poll();
            // �ش� ���ҿ� ����� ������ ������������ 1 ����
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                // ���Ӱ� ���������� 0�� �Ǵ� ��带 ť�� ����
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        // ���� ������ ������ ��� ���
        for (int i = 1; i <= v; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();

        // �׷��� �ʱ�ȭ
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // ���� �׷����� ��� ���� ������ �Է¹ޱ�
        for (int i = 1; i <= v; i++) {
            // ù ��° ���� �ð� ������ ��� ���� 
            int x = sc.nextInt();
            times[i] = x;
            // �ش� ���Ǹ� ��� ���� ���� ���� �ϴ� ���ǵ��� ��ȣ �Է� 
            while (true) {
                x = sc.nextInt();
                if (x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologySort();
    }
}