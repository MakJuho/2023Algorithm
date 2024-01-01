package BOJ;

import java.io.ByteArrayInputStream;
import java.io.*;
import java.util.*;

public class BOJ_10818_최소최대 {

    private static int T;

    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        T = Integer.parseInt(br.readLine());

        StringTokenizer tokens = new StringTokenizer(br.readLine());

        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i=0; i<T; i++){
            arrList.add(Integer.parseInt(tokens.nextToken()));
        }

        System.out.print(Collections.min(arrList)+" "+Collections.max(arrList));


//        arrList.add();
//        arrList.add(Integer.parseInt(tokens.nextToken()));

//        Collection

    }

    private static String src = "5\n" +
            "20 10 35 30 7";

}
