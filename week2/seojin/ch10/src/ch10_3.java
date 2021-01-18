// �ּ� ���� Ʈ����� ���� �˰ڴµ�...
// �̸� 2���� ����(�׷���)�� ������ ����� �����ϴ� ���� �����
import java.util.*;

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class ch10_3 {

    // ����� ����(V)�� ����(Union ����)�� ����(E)
    public static int v, e;
    public static int[] parent = new int[100001]; // �θ� ���̺� �ʱ�ȭ
    // ��� ������ ���� ����Ʈ��, ���� ����� ���� ����
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // Ư�� ���Ұ� ���� ������ ã��
    public static int findParent(int x) {
        // ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // �� ���Ұ� ���� ������ ��ġ��
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // �θ� ���̺�󿡼�, �θ� �ڱ� �ڽ����� �ʱ�ȭ
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // ��� ������ ���� ������ �Է� �ޱ�
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            // �������� �����ϱ� ���ؼ� Ʃ���� ù ��° ���Ҹ� ������� ����
            edges.add(new Edge(cost, a, b));
        }

        // ������ �������� ����
        Collections.sort(edges);
        int last = 0; // �ּ� ���� Ʈ���� ���ԵǴ� ���� �߿��� ���� ����� ū ����

        // ������ �ϳ��� Ȯ���ϸ�
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            // ����Ŭ�� �߻����� �ʴ� ��쿡�� ���տ� ����
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }
}