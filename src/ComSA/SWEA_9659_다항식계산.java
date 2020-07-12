package ComSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_9659_다항식계산 {

	private static Func[] func;
	private static long[] ans;

	private static int MOD = 998244353;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++ ) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			func = new Func[N+1];
			
			for(int i =2; i<=N; i++) {
				String str = br.readLine();
				StringTokenizer tokens = new StringTokenizer(str);
				int tp = Integer.parseInt(tokens.nextToken());
				int a = Integer.parseInt(tokens.nextToken());
				int b = Integer.parseInt(tokens.nextToken());
				func[i] = new Func(tp,a,b);
				
				
			}
			int M = Integer.parseInt(br.readLine());
			
			
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				ans = new long[N+1];
				ans[0] = 1;
				ans[1] = Long.parseLong(tokens.nextToken());
				for(int j=2; j<=N; j++) {
					switch (func[j].t) {
						case 1:
							ans[j] = (ans[func[j].a] + ans[func[j].b]) % MOD;
							break;
						case 2:
							ans[j] = func[j].a * ans[func[j].b]% MOD;
							break;
						case 3:
							ans[j] = (ans[func[j].a] % MOD) * (ans[func[j].b] % MOD) % MOD;
							break;
					}
				}
				
				sb.append(ans[N]).append(" ");
			}

			sb.append("\n");
			
		
		}
		System.out.println(sb);
	}

	
	
	static class Func{
		int t;
		int a;
		int b;
		
		public Func(int t, int a, int b) {
			super();
			this.t = t;
			this.a = a;
			this.b = b;
		}
		
		@Override
		public String toString() {
			return "Func [t=" + t + ", a=" + a + ", b=" + b + "]";
		}
		
		
		
	}
	private static String src = "1\r\n" + 
			"4\r\n" + 
			"1 0 1\r\n" + 
			"2 2 2\r\n" + 
			"3 2 3\r\n" + 
			"4\r\n" + 
			"0 1 2 3";

}
