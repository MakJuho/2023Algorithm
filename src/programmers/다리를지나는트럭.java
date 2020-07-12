package programmers;

import java.util.LinkedList;
import java.util.Queue;

import programmers.탑.Pos;

public class 다리를지나는트럭 {
	static Queue<Pos> wait = new LinkedList<>();
	static Queue<Pos> run = new LinkedList<>();
	static Queue<Pos> finish = new LinkedList<>();

	public static void main(String[] args) {
		int bridge_length= 100;
		int weight= 100;
		int[] truck_weights= {10,10,10,10,10,10,10,10,10,10};
		int len = truck_weights.length;
		int time = 0;
		
		// 대기 트럭
		for(int i=0; i<truck_weights.length; i++) {
			wait.add(new Pos(truck_weights[i], 0));
		}
		int run_weight=0;
		
		while(finish.size() != len) {
			time ++;
			Pos truck;
			if(!run.isEmpty()) {
				if( (time -run.peek().time) >= bridge_length) {
					truck = run.poll();
					finish.add(truck);
					run_weight -= truck.weight;
				}
			}
			
			if(!wait.isEmpty()) {
				truck = wait.peek();
			
				if( weight >= run_weight + truck.weight ) {
					truck = wait.poll();
					truck.time = time;
					run_weight += truck.weight;
					run.add(truck);
				}
			}
			
			// 시간 증가
//			for(int i=0; i<run.size(); i++) {
//				run.
//			}
//			
//			System.out.println(run.peek().time);
			
			
		}
		
		System.out.println(time);
		
	}
	static class Pos{
		int weight;
		int time;
		
		
		
		public Pos(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}



		@Override
		public String toString() {
			return "Pos [weight=" + weight + ", time=" + time + "]";
		}
		
		
	}
	
}
