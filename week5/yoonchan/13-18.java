
import java.util.*;

/*
    걸린시간: 1시간 4분...
    문제점:   list.to string 생각없이 막 했다가 낭패...
                알아차렸지만 stringBuilder 사용법 햇갈려서 또 시간 들고...
                    그 전에 문제 정독 안하고 서두르다가 시간 들고... 그냥 천천히 정독이 젤 빠르다는것 잊지말기...
                        코드 뭐 쓰려고 하기 전에 더 나은것 없는지 생각해보기...

 */


class Solution {

    public static boolean right(List<String> list){

        int sum1 = 0;//(
        int sum2 = 0;//)
        for(int i = 0; i < list.size(); i++){
            String a = list.get(i);
            if(a.equals("("))
                sum1++;
            else
                sum2++;

            if(sum1 < sum2)
                return false;
        }

        return true;
    }

    public static String find(String p){
        if(p.equals(""))
            return "";
        String[] str = p.split("");

        int sum1 = 0;//(
        int sum2 = 0;//)
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();


        for(int i = 0; i < str.length;i++){

            if((sum1 == sum2) && (sum1 != 0 && sum2 != 0)){
                for(int j = i; j < str.length; j++){
                    list2.add(str[j]);
                }
                break;
            }
            else if(str[i].equals("(")){
                sum1++;
                list1.add("(");
            }
            else if(str[i].equals(")")) {
                sum2++;
                list1.add(")");
            }

        }
        if (list2.isEmpty())
            list2.add("");

        if(right(list1)){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < list2.size();i++){
                sb.append(list2.get(i));
            }
            String cur = sb.toString();

            //System.out.println(cur);

            String s = find(cur);//!!!!!!!!!!!!!!
            String[] s2 = s.split("");
            for(int i = 0; i < s.length();i++){
                list1.add(s2[i]);
            }

           sb = new StringBuilder();

            for(int i = 0; i < list1.size();i++){
                sb.append(list1.get(i));
            }
            String cur2 = sb.toString();


            return cur2;
        }
        else{
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < list2.size();i++){
                sb.append(list2.get(i));
            }
            String cur = sb.toString();

            String s = find(cur);//!!!!!!!!!!!!!!
            String[] s2 = s.split("");

            String ns = "(" + s + ")";

            StringBuilder sb2 = new StringBuilder();

            for(int i = 1; i < list1.size() - 1;i++){
                String change = list1.get(i);
                if(change.equals(")"))
                    sb2.append("(");
                else
                    sb2.append(")");

            }
            return ns + sb2.toString();
        }

    }
    public String solution(String p) {
        String answer = "";


        answer = find(p);

        return answer;
    }
}

public class Main {


    public static void main(String[] args) {

        Solution s =  new Solution();
        System.out.println(s.solution("()))((()"));


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}