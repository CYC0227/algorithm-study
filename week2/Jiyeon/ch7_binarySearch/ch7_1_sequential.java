// chapter 7 이진탐색 - 순차탐색 소스코드

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
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		sequential(search);
		
		if(index>=0)
			System.out.println(index+1);
		else
			System.out.println("원소가 존재하지 않습니다.");
		
		
		/* 코드 실행시간 계산 */
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000;
        System.out.println("실행시간(second) : " + secDiffTime);
	}

}
