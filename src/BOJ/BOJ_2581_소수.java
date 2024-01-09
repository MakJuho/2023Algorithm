package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2581_소수 {

    private static int A ;
    private static int B ;

    private static int max;
    private static int min;
    public static void main(String[] args) throws Exception {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        /**
         * 소수가 없다면 return -1
         */
        ArrayList<Integer> list = new ArrayList<>();
        for(int tgt=A; tgt<=B; tgt++){
            if(isPrime(tgt)){
                list.add(tgt);
            }

        }

        if(list.size() == 0){
            System.out.println("-1");
        }else{
            //최대값
            for(int idx=0; idx<list.size(); idx++){
                max+= list.get(idx);
            }
            //최소값
            min = list.get(0);
            System.out.println(max);
            System.out.println(min);
        }

    }

    private static boolean isPrime(int num){
        if(num == 1){
            return false;
        }

        for(int i=2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    private static String src ="1\n" +
            "5";
    /**
     * 1 5
     * 2 3 5
     */
}
