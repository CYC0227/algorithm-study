import java.util.*;

class Node{
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public void show() {
		System.out.println("(" + this.index + "," + this.distance + ") ");
	}
}


public class _2_7_list {
	
	// ��(Row)�� 3���� ���� ����Ʈ ǥ��
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �׷��� �ʱ�ȭ
		for(int i=0; i<3; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// ��� 0�� ����� ��� ���� ���� (���, �Ÿ�)
		graph.get(0).add(new Node(1,7));
		graph.get(0).add(new Node(2,5));
		
		// ��� 1�� ����� ��� ���� ���� (���, �Ÿ�)
		graph.get(1).add(new Node(0,7));
		
		// ��� 2�� ����� ��� ���� ���� (���, �Ÿ�)
		graph.get(2).add(new Node(0,5));
		
		//�׷��� ���
		for(int i=0; i<3; i++) {
			for(int j=0; j<graph.get(i).size();j++) {
				graph.get(i).get(j).show();
			}
			System.out.println();
		}
	}

}
