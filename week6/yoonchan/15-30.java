
import java.util.*;

/*
    걸린시간:   1시간 41분
    문제점:    효율성 2개 시간초과뜸
              그리고 되게 빨리 풀었었는데... mid = (left + right) / 2; 이거를  mid = (start + end) / 2; 이렇게 하는바람에 거의1시간 삽질했음...
              디버깅할때 sysout을 남발해보자
                  

 */

class Solution {

    public static int binarySearch_left_wild(String query, int start, int end){
        int left = start;
        int right = end;
        int mid = (start + end) / 2;



        while(start < end){//마지막 q 인덱스
            if(query.charAt(mid) == '?' && query.charAt(mid + 1) != '?'){
                return mid;
            }
            if(query.charAt(mid) != '?'){
                right = mid - 1;
                mid = (left + right) / 2;

            }
            else if(query.charAt(mid) == '?'){
                left = mid + 1;
                mid = (left + right) / 2;

            }
        }

        return -100;
    }
    public static int binarySearch_right_wild(String query, int start, int end){
        int left = start;
        int right = end;
        int mid = (start + end) / 2;

        while(start < end){//마지막 q 인덱스
            if(query.charAt(mid + 1) == '?' && query.charAt(mid) != '?'){
                return mid + 1;
            }
            if(query.charAt(mid) == '?'){//!!!!
                right = mid - 1;
                mid = (left + right) / 2;
            }
            else if(query.charAt(mid) != '?'){
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return -100;
    }
    public static int find(String[] words, String query){
        int len = query.length();
        int result = 0;
        int q_index = -1;


        if(query.charAt(0) == '?' && query.charAt(len - 1) == '?'){
            for(int i = 0; i< words.length; i++){
                if(words[i].length() == query.length()){
                    result++;
                }
            }
        }
        else if(query.charAt(0) == '?'){


            q_index = binarySearch_left_wild(query, 0,len - 1);

            String cmpStr = query.substring(q_index + 1);




            for(int i = 0; i< words.length; i++){
                if(words[i].length() == query.length()){
                    if(words[i].substring(q_index + 1).equals(cmpStr))
                        result++;
                }
            }
        }else{
            q_index = binarySearch_right_wild(query, 0,len - 1);

            String cmpStr = query.substring(0, q_index);
            for(int i = 0; i< words.length; i++){
                if(words[i].length() == query.length()){
                    if(words[i].substring(0,q_index).equals(cmpStr))
                        result++;
                }
            }
        }

        return result;
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = {};

        answer = new int[queries.length];

        List<String> list = new ArrayList<>();

        for(int i = 0; i < queries.length; i++){
            if(list.contains(queries[i])){
                int idx = list.indexOf(queries[i]);
                answer[i] = answer[idx];
            }
            list.add(queries[i]);

            answer[i] = find(words, queries[i]);

        }

        //System.out.println(answer[1]);

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        String[] str1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] str2 = {"fro??", "????o", "fr???", "fro???", "pro?"};
       // String[] str2 = {"fro??", "?????"};
       // String[] str2 = {"????o", "?????"};

        Solution s = new Solution();
        int[] a = s.solution(str1, str2);

        for (int d:
             a) {
            System.out.println(d);
        }
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}