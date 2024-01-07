package BOJ;


import java.io.InputStreamReader;

import java.io.*;
import java.util.*;

public class BOJ_2609_최대공약수최소공배수 {
    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(tokens.nextToken());
        int B = Integer.parseInt(tokens.nextToken());

        int comNum = GCD(A,B);
        System.out.println(comNum);
        LCM(A,B,comNum);

    }
    private static int GCD(int A, int B){
        ArrayList<Integer>  divListA = new ArrayList<>();
        ArrayList<Integer>  divListB = new ArrayList<>();

        for(int i=1; i<=A; i++){
            if(A%i == 0){
                divListA.add(i);
            }
        }
//        System.out.println(divListA);
        for(int i=1; i<=B; i++){
            if(B%i == 0){
                divListB.add(i);
            }
        }
//        System.out.println(divListB);
//        System.out.println("divListA size() : "+ divListA.size());
        divListA.addAll(divListB);
//        System.out.println("divListA size() : "+ divListA.size());

        Collections.sort(divListA);
//        System.out.println(divListA);


        for(int idx=divListA.size()-1; idx>0; idx--){
            if( divListA.get(idx).equals(divListA.get(idx-1)) ){
                return divListA.get(idx);
            }
        }
        return -1;
    }

    private static void LCM(int A, int B, int comNum){
        System.out.println( A/comNum * B/comNum * comNum );
    }

    private static String src = "10000 10000";
}
