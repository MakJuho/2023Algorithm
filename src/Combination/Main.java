package Combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static int[] arr1 = new int[8];
    static int[] arr2 = new int[8];
    static int[] check = new int[8];
    static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    
        for(int i = 0; i < n; i++){
            arr1[i] = i + 1;
        }
        func(0);
        bw.flush();
        bw.close();
        
    }
    public static void func(int cnt)throws IOException{
        
        if(cnt == m){
            for(int i = 0; i < m; i++){
                String t = String.valueOf(arr1[arr2[i]]);
                bw.write(t + ' ');
            }
            bw.write('\n');
        }          
        else{  
            for(int i = 0; i < n; i++){
                arr2[cnt] = i;
                func(cnt+1);
            }
        }
    }
    
}