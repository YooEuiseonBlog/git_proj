package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class vote_1417 { // 국회의원선거.
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine()); // 후보 수
    int DASOM = Integer.parseInt(bf.readLine());
    int[] arr = new int[N - 1];
    for (int i = 0; i < arr.length; i++) { // 각 후보의 투표 수
      arr[i] = Integer.parseInt(bf.readLine());
    }
    int min = 0;
    if (N == 1) {
      System.out.println("0");
      return;
    }
    while (true) {
      Arrays.sort(arr); // 투표수가 가장 높은 후보자의 투표를 매수하기 위해 정렬
      boolean check = true; // 다솜이보다 높은 투표수가 있나 확인.
      int last = arr.length - 1; // 가장 투표가 많은 후보의 인덱스

      // 가장 높은 투표를 받은 후보가 다솜이의 투표 수 이상인 경우
      if (DASOM <= arr[last]) {
        DASOM++;
        arr[last]--;
        min++;
        check = false; // 다솜이가 당선이 되지 못했을 경우
      }
      if (check)
        break; // 다솜이보다 높은 투표수가 없는 경우
    }
    System.out.println(min);
    bf.close();
  }
}