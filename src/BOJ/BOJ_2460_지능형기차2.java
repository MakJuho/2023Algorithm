package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2460_지능형기차2 {

    private static final int T = 10;
    private static int maxPsgNum;
    private static int curPsgNum;

    public static void main(String[] args) throws IOException{
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        for(int i=0; i<T; i++){
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            curPsgNum -= Integer.parseInt(tokens.nextToken());   // 하차
            curPsgNum += Integer.parseInt(tokens.nextToken());   // 승차

            if ( maxPsgNum < curPsgNum ) {
                maxPsgNum = curPsgNum;
            }
        }

        System.out.print(maxPsgNum);

    }

    private static String src = "0 32\n" +
            "3 13\n" +
            "28 25\n" +
            "17 5\n" +
            "21 20\n" +
            "11 0\n" +
            "12 12\n" +
            "4 2\n" +
            "0 8\n" +
            "21 0";
}
