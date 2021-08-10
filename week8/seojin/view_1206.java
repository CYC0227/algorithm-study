import java.util.*;

public class view_1206 {
	
	public static int[] building;
	public static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {//테스트케이스 10개
			int length = sc.nextInt();
			building = new int[length];//테스트케이스마다 갱신
			result = new int[length];
			int count = 0;
			
			for(int j=0; j<length; j++) {//빌딩 층수 입력
			building[j] = sc.nextInt();
			}
			
			//양쪽 거리 2이상인지 확인
			for(int l=0; l<length; l++) {
				if(building[l]==0) {
					result[l]=0;
					continue;
				}
				else {
					int a = building[l] - building[l-2];
					int b = building[l] - building[l-1];
					int c = building[l] - building[l+1];
					int d = building[l] - building[l+2];
					
					if(a<0 || b<0 || c<0 || d<0) {
						result[l]=0;
						continue;
					}
					//작은 값 선택
					int min1 = Math.min(a, b);
					int min2 = Math.min(c, d);
					result[l] = Math.min(min1, min2);
					count += result[l];
				}
			}
			System.out.println("#" + (i+1) + " " + count);
		}
		
		
	}

}
