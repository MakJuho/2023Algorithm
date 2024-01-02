package BOJ;

import java.util.*;
import java.io.*;


public class BOJ_10870_피보나치수5 {

    private static int N = 0;
    public static void main(String[] args) throws Exception {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //System.out.println(br.readLine());
        N = Integer.parseInt(br.readLine());
        int ans = Fibonacci(N);
        System.out.println(ans);

    }
    private static int Fibonacci(int N){

        /**
         * N = 5
         * 0 1 1 2 3 5 8
         */
        if(N==0){
            return 0;
        }else if(N==1){
            return 1;
        }else{
            return  Fibonacci(N-1)+Fibonacci(N-2);
        }



    }

    private static String src ="5";
}
