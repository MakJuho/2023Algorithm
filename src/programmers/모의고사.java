package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int A_tot=0, B_tot=0, C_tot=0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i%5] ){
                A_tot++;
            }
            if(answers[i] == second[i%8] ){
                B_tot++;
            }
            if(answers[i] == third[i%10] ){
                C_tot++;
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        max = A_tot > B_tot ? A_tot : B_tot;
        
        max = max > C_tot ? max : C_tot;
        ArrayList<Integer> arraylist = new ArrayList<>();
        if(max == A_tot){
        	arraylist.add(1);
        }
        if(max == B_tot){
        	arraylist.add(2);
        }
        if(max == C_tot){
        	arraylist.add(3);
        }
        
       // System.out.println(arraylist);
        
        int[] answer = new int[arraylist.size()];
        
        for(int i=0; i< answer.length; i++) {
        	answer[i] = arraylist.get(i).intValue();
        }
        
        System.out.println(Arrays.toString(answer));
        
	}
}
