package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuffixArray_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sc = br.readLine();
        String[] strArr = new String[sc.length()];
        for (int i = 0; i < sc.length(); i++) {
            strArr[i] = sc.substring(i);
        }
        Arrays.sort(strArr);
        for (String str : strArr) {
            System.out.println(str);
        }
    }
}
