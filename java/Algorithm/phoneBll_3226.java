package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class phoneBll_3226 {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] hh = new int[cnt]; // 시 배열
        int[] mm = new int[cnt]; // 분 배열
        int[] duration = new int[cnt]; // 통화시간
        int cost = 0;
        for (int i = 0; i < cnt; i++) {
            String[] str = br.readLine().trim().split(" ");
            String[] tm = str[0].split(":");
            int hour = Integer.parseInt(tm[0]); // 시
            int minute = Integer.parseInt(tm[1]); // 분
            int dur = Integer.parseInt(str[1]); // 통화기간
            hh[i] = hour;
            mm[i] = minute;
            duration[i] = dur;
        }

        for (int n = 0; n < cnt; n++) {
            // 계산
            for (int j = 0; j < duration[n]; j++) {

                // 시 계산
                if (7 <= hh[n] && hh[n] < 19) {
                    cost += 10;
                    
                } else {
                    cost += 5;
                    if (hh[n] == 24) {
                        hh[n] = 0;
                        
                    }
                }

                // 분 계산
                mm[n] += 1; // 11:30 11분 ---> 11:31

                if (mm[n] == 60) {
                    hh[n] += 1;
                    mm[n] = 0;

                }
            }//for j
        }// for n
        System.out.println(cost);
    } // main

}// class
