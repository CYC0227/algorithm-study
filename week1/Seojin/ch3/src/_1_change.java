import java.util.Scanner;

public class _1_change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		int count;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("손님에게 거슬러 줘야 할 돈 : ");
		N = sc.nextInt();
		
		count = N/500;
		N = N%500;
		count = count + N/100;
		N = N%100;
		count = count + N/50;
		N = N%50;
		count = count + N/10;
		N = N%10;
			
		System.out.println("거슬러줘야 할 동전의 최소 개수 : " + count);

	}

}

//////////답지//////////
/*
public class _1_change{
	public static void main(String[] args) {
		int n = 1260;
		int cnt = 0;
		int[] coinTypes = {500, 100, 50, 10};
		
		for(int i=0; i<4; i++) {
			int coin = coinTypes[i];
			cnt += n / coin;
			n %= coin;
		}
		
	    	System.out.prinln(cnt);
		
	}
}
*/