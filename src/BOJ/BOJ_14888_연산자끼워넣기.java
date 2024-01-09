package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_14888_연산자끼워넣기 {

    private static int max = Integer.MIN_VALUE ;
    private static int min = Integer.MAX_VALUE;
    private static int[] numbers;
    private static int[] opers = new int[4];

    private static int N;

    public static void main(String[] args) throws Exception {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //System.out.println(br.readLine());


        N = Integer.parseInt(br.readLine());
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        numbers = new int[N];

        for(int cnt=0; cnt<N; cnt++){
            numbers[cnt] = Integer.parseInt(tokens.nextToken());
        }

        tokens = new StringTokenizer(br.readLine());
        for(int idx=0; idx<4; idx++){
            opers[idx] = Integer.parseInt(tokens.nextToken());
        }

        //System.out.println(Arrays.toString(numbers));
        //System.out.println(Arrays.toString(opers));
        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int num, int idx){
        if(idx == N ){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for(int i=0; i<opers.length; i++){
            if(opers[i] >0){
                opers[i] --;

                switch(i){
                    case 0: dfs(num+numbers[idx], idx+1); break;
                    case 1: dfs(num-numbers[idx], idx+1); break;
                    case 2: dfs(num*numbers[idx], idx+1); break;
                    case 3: dfs(num/numbers[idx], idx+1); break;
                }

                opers[i] ++;
            }
        }

    }

    private static String src = "6\n" +
            "1 2 3 4 5 6\n" +
            "2 1 1 1";
}
