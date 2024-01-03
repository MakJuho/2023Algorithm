package BOJ;


import java.util.*;
import java.io.*;

public class BOJ_2693_N번째큰수 {

    private static int T;

    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(br.readLine());

            for(int j=0; j<10; j++){
                list.add(Integer.parseInt(tokens.nextToken()));
            }

            Collections.sort(list);
            Collections.reverse(list);
            System.out.println(list.get(7));

        }

    }

    private static String src = "4\n" +
            "1 2 3 4 5 6 7 8 9 1000\n" +
            "338 304 619 95 343 496 489 116 98 127\n" +
            "931 240 986 894 826 640 965 833 136 138\n" +
            "940 955 364 188 133 254 501 122 768 408";
}
