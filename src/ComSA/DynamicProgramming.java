package ComSA;

import java.util.HashMap;

public class DynamicProgramming {
		public static void main(String args[]){

		System.out.println(factorial(10));

	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	    System.out.println(factorialMemoization(10, map));




	    //재귀 함수를 활용한 factorial 함수
		}
		static int factorial(int number){
			if(number>0){
				return number*factorial(number-1);
			}else{
				return 1;
			}
		}

	   // 메모이제이션을 적용한 factorial 함수
		static int factorialMemoization(int number, HashMap map){

			if(map.containsKey(number)){
				return (int) map.get(number);
			}else{

				if(number>0){
					int temp = number*factorial(number-1);
					map.put(number, temp);
					return temp;
				}else{
					return 1;
				}
			}
		}
	}
