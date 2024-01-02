package BOJ;


import java.util.*;
import java.io.*;

public class BOJ_2309_일곱난쟁이 {

    static LinkedList<Integer> list = new LinkedList<>();
    static boolean isFind = false;
    public static void main(String[] args) throws Exception {
        InputStream is = new ByteArrayInputStream(src.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //System.out.println(br.readLine());

        /**
         * 모든 경우의 수를 구해서 100이 되는 케이스 1개를 출력하면 된다.
         * 9C7를 해서 모든 경우의 수를 찾자.
         */
        int[] dwarfList = new int[9];

        for(int i=0; i<9; i++){
            dwarfList[i] = Integer.parseInt(br.readLine());
        }

        //System.out.println(Arrays.toString(dwarfList));

        Per(dwarfList, new boolean[9], dwarfList.length, 7);


    }

    private static void Per(int[] arr, boolean[] check, int n, int r){
        if(list.size() == r){
            int totOfHeight = 100;
            int height = 0;
            for(int i=0; i<list.size(); i++ ){
                height += list.get(i);
            }
            if( height == totOfHeight) {
                Collections.sort(list);
                for(int i=0; i<list.size(); i++ ){
                    System.out.println(list.get(i));
                }

                isFind = true;
            }
            return ;
        }

        for(int i=0; i<n; i++){
            if(!check[i]){
                check[i] = true;
                list.add(arr[i]);
                Per(arr,check,n,r);
                if(isFind)
                    return;
                list.removeLast();
                check[i] = false;
            }
        }


    }

    private static String src="20\n" +
            "7\n" +
            "23\n" +
            "19\n" +
            "10\n" +
            "15\n" +
            "25\n" +
            "8\n" +
            "13";
}
