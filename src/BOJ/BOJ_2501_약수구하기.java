package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2501_약수구하기 {

    private static int N, K;
    public static void main(String[] args) throws Exception {

        // Bytes <-> String
//        byte[] encodedStr = src.getBytes();
//        System.out.println(encodedStr);
//        System.out.println(new String(encodedStr));

        InputStream is = new ByteArrayInputStream(src.getBytes());
        // InputStreamReader @params : InputStream
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        //System.out.println(N + ":" + K);

        /**
         * p의 약수를 구하기
         * 약수가 q의 개수보다 작으면 0 return.
         * q 번째 값 return
         */
        ArrayList<Integer> divList = new ArrayList<>();
        for(int i=1; i<= N; i++){
            if(N%i == 0 ){
                divList.add(i);
            }
        }

        if(K > divList.size()){
            System.out.println("0");
        }else{
            System.out.println(divList.get(K-1));
        }


    }

    private static String src = "2735 1";

}
