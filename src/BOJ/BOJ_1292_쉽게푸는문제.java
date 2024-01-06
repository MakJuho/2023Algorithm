package BOJ;

import java.util.*;
import java.io.*;


public class BOJ_1292_쉽게푸는문제 {


    private static int A;
    private static int B;

    private static int[] arr = new int[1000];
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        A = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());

        //System.out.println(A + ":"+ B);

        /**
         * 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
         *  1+2+3+4+5+..
         *         = n(n+1)/2 >= 1000;
         *         = n(n+1) >= 2000;
         *         45 ~ 46
         */


        for(int i=1; i<=100; i++){
            for(int j=1; j<=i; j++){
                if(list.size() > 1000){
                    break;
                }
                list.add(i);
            }
        }

        int sum =0;

        for(int i=A-1; i<B; i++){
            sum += list.get(i);
//            System.out.println(list.get(i));
        }
        System.out.println(sum);
    }

    private static String src = "3 7";
}
