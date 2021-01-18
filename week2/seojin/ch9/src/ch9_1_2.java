import java.util.*;

class Node implements Comparable<Node> {

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

    // �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class ch9_1_2 {

    public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    // ����� ����(N), ������ ����(M), ���� ��� ��ȣ(Start)
    // ����� ������ �ִ� 100,000����� ����
    public static int n, m, start;
    // �� ��忡 ����Ǿ� �ִ� ��忡 ���� ������ ��� �迭
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // �ִ� �Ÿ� ���̺� �����
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // �켱���� ť
        // ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // ť�� ������� �ʴٸ�
            // ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
            Node node = pq.poll();
            int dist = node.getDistance(); // ���� �������� ��� 
            int now = node.getIndex(); // ���� ���
            // ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
            if (d[now] < dist) continue;
            // ���� ���� ����� �ٸ� ������ ������ Ȯ��
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

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