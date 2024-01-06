package BOJ;

import java.util.*;
import java.io.*;


public class BOJ_1978_소수찾기 {

    private static int T;
    public static void main(String[] args) throws Exception {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //System.out.println(br.readLine());

        T = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            int target = Integer.parseInt(tokens.nextToken());

            // decimal discrimination
//            if(decimalDiscrimination(target))
            if(isPrime(target))
                cnt++;
        }

        System.out.println(cnt);


    }
    private static boolean decimalDiscrimination(int target){

        ArrayList<Integer> list = new ArrayList<>();
        for(int idx=1; idx<=target; idx++){
            if(target % idx == 0){
                list.add(idx);
            }
        }

        if(list.size() == 2){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isPrime(int target){
        if(target == 1){
            return false;
        }

        for(int idx =2; idx <= (int)Math.sqrt(target); idx++){
            if(target % idx == 0 ){
                return false;
            }
        }
        return true;
    }

    private static String src = "4\n" +
            "1 3 5 7";

}
