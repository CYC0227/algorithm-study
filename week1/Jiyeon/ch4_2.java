import java.util.*;

// 구현 - 시각
public class ch4_2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int count=0;
		
		// 00시 00분 00초부터 N시 59분 59초까지 전부 확인
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					/* 시간,분,초 를 String으로 변환시켜서 한 문장으로 변환하고, contains를 사용해서 3이 있는지 확인  */
					String time = Integer.toString(i)+Integer.toString(j)+Integer.toString(k);
					if(time.contains("3"))
						count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
