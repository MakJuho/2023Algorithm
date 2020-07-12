package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1208_부분수열의합2_Div {
	static int N,S;

    static int arr[];

    static ArrayList<Integer> left = new ArrayList<>();

    static ArrayList<Integer> right = new ArrayList<>();

    static long cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
	
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        makeBinary(0, 0, N/2, left);
        makeBinary(0, N/2, N, right);

        Collections.sort(left);
        Collections.sort(right);

        System.out.println(left);
        System.out.println(right);
        
        int leftIndex = 0;
        int rightIndex = right.size()-1;

        while(leftIndex<left.size() && rightIndex>=0) {
            long left_val = left.get(leftIndex);
            long right_val = right.get(rightIndex);

            if(left_val + right_val == S) {
                long left_count = 0;
                while(leftIndex<left.size() && left.get(leftIndex)==left_val) {
                    left_count++;
                    leftIndex++;
                }
                long right_count = 0;
                while(rightIndex >= 0 && right.get(rightIndex) == right_val) {
                    right_count++;
                    rightIndex--;
                }
                
                cnt += right_count * left_count;
            }

            if(left_val + right_val < S) {
                leftIndex++;
            }
            if(left_val + right_val > S) {
                rightIndex--;
            }
        }

        if(S==0)
            System.out.println(cnt-1);
        else
            System.out.println(cnt);

    }

    public static void makeBinary(int sum, int start, int end, ArrayList<Integer> list) {
        if(start >= end) {
            list.add(sum);
            return;
        }

        makeBinary(sum+arr[start], start+1, end, list); // 골랐을 때
        makeBinary(sum, start+1, end, list); // 못 골랐을 때

    }
	
	static String src ="5 0\r\n" + 
			"-7 -3 -2 5 8";
}
