package Algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class roomNumber_1475 { // 방번호.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    String N = br.readLine(); //다솜이의 방번호 N

    int[] arr = new int[10]; 
    int temp = 0;
    int max = 0;

    for (int i = 0; i < N.length(); i++) {
        temp = N.charAt(i) - '0'; //char -> int로 변환
        arr[temp]++; 
    }
    //6,9는 뒤집어서 사용가능.
    int sum = arr[6] + arr[9];
    //합이 짝수 일 때,
    if (sum % 2 == 0) {
        arr[6] = sum / 2;
        arr[9] = sum / 2;
    }
    //6,9의 합이 홀수일 땐 +1. 1세트가 더 필요함.
    else {
        arr[6] = sum / 2 + 1;
        arr[9] = sum / 2 + 1;
    }
    //최대값 출력 최대값 = 세트값
    for (int i : arr) {
        max = Math.max(max, i);
    }
    System.out.println(max);
}

}