package d3;

import java.util.Scanner;
import java.io.FileInputStream;

public class d3_1206_view {
	
		public static void main(String args[]) throws Exception
		{
			System.setIn(new FileInputStream("input_1206.txt"));

			Scanner sc = new Scanner(System.in);

			for(int test_case = 1; test_case <= 10; test_case++)
			{
				int n = sc.nextInt(); // 빌딩의 개수 ( 테스트 케이스의 길이 )
	            int[] building = new int[n]; // 각 빌딩의 높이
	            for(int i=0; i<n; i++){
	                building[i] = sc.nextInt();
	            }
				
	            int result = 0;
	            
	            for(int i=2; i<= n-3; i++){
	                for(int j=building[i]; j>=0; j--){
	                	int[] side = new int[4];
	                
	                	side[0] = j - building[i-2];
	                	side[1] = j - building[i-1];
	                	side[2] = j - building[i+1];
	                	side[3] = j - building[i+2];
	              	
	                	if(side[0]<=0 || side[1]<=0 || side[2]<=0 || side[3]<=0)
	                    	break;
	                	else
	                    	result++;
	                }
	            }
	            
	            System.out.println("#"+test_case+" "+result);
			}
		}

}
