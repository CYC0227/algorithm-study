
import java.util.*;

public class _1_4_recursion {

	public static void recursiveFunction(int i) {
        // 100��° ȣ���� ���� �� ����ǵ��� ���� ���� ���
        if (i == 100) return;
        System.out.println(i + "��° ��� �Լ����� " + (i + 1) + "��° ����Լ��� ȣ���մϴ�.");
        recursiveFunction(i + 1);
        System.out.println(i + "��° ��� �Լ��� �����մϴ�.");
    }

    public static void main(String[] args) {
        recursiveFunction(1);
    }

}
