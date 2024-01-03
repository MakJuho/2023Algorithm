package BOJ;


import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2693_N번째큰수_2 {

    private static int T;

    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            Integer [] arr = new Integer[10];
            StringTokenizer tokens = new StringTokenizer(br.readLine());

            for(int j=0; j<10; j++){
                arr[j]=  Integer.parseInt(tokens.nextToken());
            }
            /* 정렬 전  */
            System.out.println("===정렬 전===");
            System.out.println(Arrays.toString(arr));

            Arrays.sort(arr);
            /* 정렬 후  */
            Arrays.sort(arr, Collections.reverseOrder());

            /*
            Arrays.sort(arr, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            */

            System.out.println("===정렬 후===");
            System.out.println(Arrays.toString(arr));

        }

    }

    private static String src = "4\n" +
            "1 2 3 4 5 6 7 8 9 1000\n" +
            "338 304 619 95 343 496 489 116 98 127\n" +
            "931 240 986 894 826 640 965 833 136 138\n" +
            "940 955 364 188 133 254 501 122 768 408";
}
