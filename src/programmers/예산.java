package programmers;

public class 예산 {
	static boolean[] check;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		int answer = 0;
        int left = 0;
        int right = 0;
        for (int budget : budgets) {
            if (budget > right) {
                right = budget;
// answer의 최대 값은 budgets의 요소의 최대값
            }
        }
        int middle = 0;
        while (left <= right) {
            long sum = 0;
            middle = (left + right) / 2;
            for (int budget : budgets) {
                if (budget >= middle) {
                    sum += middle;
                }
                else {
                    sum += budget;
                }
            }
            if (sum > M) {
                right = middle - 1;
            }
            else {
// answer에 의한 예산의 합은 예산 M보다 작아야 하므로 해당 분기에서 처리
                answer = middle;
                left = middle + 1;
            }
        }
        System.out.println(answer);
		
	}

}
