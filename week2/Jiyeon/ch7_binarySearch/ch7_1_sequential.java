// chapter 7 ����Ž�� - ����Ž�� �ҽ��ڵ�

public class ch7_1_sequential {

	static public String arr[] = {"Hanul", "Jonggu", "Dongbin", "Taeil", "Sangwook"};
	static public String search = "Dongbin";
	static public int index = -1;
	
	public static void sequential(String name) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(name)) {
				index = i;
			}
		}
	}
	
	public static void main(String[] args) {
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		sequential(search);
		
		if(index>=0)
			System.out.println(index+1);
		else
			System.out.println("���Ұ� �������� �ʽ��ϴ�.");
		
		
		/* �ڵ� ����ð� ��� */
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000;
        System.out.println("����ð�(second) : " + secDiffTime);
	}

}
