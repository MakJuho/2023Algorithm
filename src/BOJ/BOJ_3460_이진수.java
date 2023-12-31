package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_3460_이진수 {

    private static int T;
    private static int num;
    public static void main(String[] args) throws Exception {

        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            num = Integer.parseInt(br.readLine());

            // 2진수로 변경.
            /**
             * 13 /2 1
             * 6  /2 0
             * 3  /2 1
             * 1
             *
             * 배열에 1 0 1 1
             * 0 2 3
             *
             * 30 /2 0
             * 15 /2 1
             * 7  /2 1
             * 3  /2 1
             * 1
             */
            ArrayList<Integer> arrList = new ArrayList<>();

            while(num > 0){
                arrList.add(num%2);
                num /= 2;
            }

            for(int idx=0; idx<arrList.size(); idx++){
//                System.out.print(arrList.get(idx)+" ");
                if(arrList.get(idx) == 1){
                    System.out.print(idx+" ");
                }
            }
            System.out.println();
        }

    }

    private static final String src = "2\n" +
            "13\n" +
            "30";
}
