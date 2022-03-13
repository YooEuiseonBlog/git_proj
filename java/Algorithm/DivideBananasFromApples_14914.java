package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DivideBananasFromApples_14914 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int result = GCD(a, b);     // 최대공약수
        List<Integer> list = new ArrayList<Integer>();
        
        // 나눠지는 사람의 경우 수 구하기
        for(int i=1; i<=result; i++) {
            if(result%i==0){
                list.add(i);
            }
        }
        //출력
        for (Integer num : list) {
            System.out.println(num + " " +  a/num + " " + b/num);
        }
        

        
    }// main
    
    // 최대공약수 메서드
    static int GCD(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return GCD(b, r);
    }
}
