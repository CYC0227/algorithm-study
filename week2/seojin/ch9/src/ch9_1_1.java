import java.util.*;

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class ch9_1_1 {

    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    // ����� ����(N), ������ ����(M), ���� ��� ��ȣ(Start)
    // ����� ������ �ִ� 100,000����� ����
    public static int n, m, start;
    // �� ��忡 ����Ǿ� �ִ� ��忡 ���� ������ ��� �迭
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // �湮�� ���� �ִ��� üũ�ϴ� ������ �迭 �����
    public static boolean[] visited = new boolean[100001];
    // �ִ� �Ÿ� ���̺� �����
    public static int[] d = new int[100001];

    // �湮���� ���� ��� �߿���, ���� �ִ� �Ÿ��� ª�� ����� ��ȣ�� ��ȯ
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // ���� �ִ� �Ÿ��� ª�� ���(�ε���)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // ���� ��忡 ���ؼ� �ʱ�ȭ
        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        // ���� ��带 ������ ��ü n - 1���� ��忡 ���� �ݺ�
        for (int i = 0; i < n - 1; i++) {
            // ���� �ִ� �Ÿ��� ���� ª�� ��带 ������, �湮 ó��
            int now = getSmallestNode();
            visited[now] = true;
            // ���� ���� ����� �ٸ� ��带 Ȯ��
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // ���� ��带 ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // ����� ����
        m = sc.nextInt(); // ������ ����
        start = sc.nextInt(); // ���� ��� ��ȣ

        // �׷��� �ʱ�ȭ
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // ��� ���� ������ �Է¹ޱ�
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a�� ��忡�� b�� ���� ���� ����� c��� �ǹ�
            graph.get(a).add(new Node(b, c));
        }

        // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
        Arrays.fill(d, INF);
        
        // ���ͽ�Ʈ�� �˰����� ����
        dijkstra(start);

        // ��� ���� ���� ���� �ִ� �Ÿ��� ���
        for (int i = 1; i <= n; i++) {
            // ������ �� ���� ���, ����(INFINITY)�̶�� ���
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // ������ �� �ִ� ��� �Ÿ��� ���
            else {
                System.out.println(d[i]);
            }
        }
    }
}