package SW역량테스트_1014;

public class fibonacci {
	public static void main(String[] args) {
		int N = fibonacci(5);
		
		System.out.println(N);
	}

	private static int fibonacci(int n) {
		if(n <= 2 ) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
