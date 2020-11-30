package 순열_조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PCSpractice {

	public static char[] N = {'A','B','C','D'};
	public static int R =2;
	public static char[] result;
	public static boolean[] visited;
	public static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// nPrVisted
		visited = new boolean[N.length];
		result = new char[R];
		nPrVisted(0);
		System.out.println();
		// nPrSwap
		nPrSwap(0);
		System.out.println();
		//
		NP();
		System.out.println();
		// nCr
		result = new char[R];
		nCrRecursion(0, 0);
		System.out.println();
		//nCr
		result = new char[R];
		nCrDef(N.length, R);
		System.out.println();
		// subSetBit
		subSetBit();
		System.out.println();
		// subSetList
		subSetList(0, 0);
		// subSetRecursion
		
		visited = new boolean[N.length];
		subSetRecursion(0);
		
		
	}
	public static void nPrVisted(int r) {
		if(r == R) {
			System.out.println("visited:" + Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[r] = N[i];
				nPrVisted(r+1);
				visited[i] =false;
			}
		}
	}
	public static void nPrSwap(int d) {
		if(d ==R) {
			System.out.println("swap:" + Arrays.toString(Arrays.copyOfRange(N, 0, R)));
			return;
		}
		for (int i = d; i < N.length; i++) {
			swap(d,i);
			nPrSwap(d+1);
			swap(d,i);
		}
	}
	
	public static void swap(int a, int b) {
		char tmp = N[a];
		N[a] = N[b];
		N[b] = tmp;
	}
	public static void NP() {
		do {
			System.out.println("NP:" +Arrays.toString(N));
		}while(nPrNP());
	}
	
	
	public static boolean nPrNP() {
		
		// i 구하기
		int i;
		for (i = N.length-2; i >= 0; i--) {
			if(N[i] < N[i+1]) break;
		}
		if(i<0) {
			return false;
		}
		
		// j 구하기
		int j;
		for (j = N.length-1; j >=0 ; j--) {
			if(N[i]<N[j]) break;
		}
		
		// 스왑
		swap(i,j);
		
		// i 뒤 숫자 정렬 reverse
		for (int a = i+1, b = N.length-1; a < b; a++,b--) {
			swap(a,b);
		}
		
		return true;
		
	}
	
	public static void nCrRecursion(int r, int k) {
		if(r ==R) {
			System.out.println("Recursion:" + Arrays.toString(result));
			return;
		}
		for (int i = k; i < N.length; i++) {
			result[r] = N[i];
			nCrRecursion(r+1,i+1);
		}
	}
	
	public static void nCrDef(int n, int r) {
		if(r == 0) {
			System.out.println(Arrays.toString(result));
			return;
		}else if(n<r) {
			return;
		}else {
			result[r-1] = N[n-1];  
			nCrDef(n-1, r-1);
			nCrDef(n-1, r);
		}
	}
	
	
	public static void subSetBit() {
		for (int i = 0; i < (1<<N.length); i++) {
			List<Character> tmp = new LinkedList<>();
			for (int j = 0; j < N.length; j++) {
				if((i & 1<<j)>0) {
					tmp.add(N[j]);
				}
			}
			System.out.println(tmp);
		}
	}
	
	public static void subSetList(int r, int k) {
		System.out.println(list);
		if(r == N.length) {
			return;
		}
		for (int i = k; i < N.length; i++) {
			list.add(N[i]);
			subSetList(r+1,i+1);
			list.remove(list.size()-1);
		}
		
	}
	public static void subSetRecursion(int i) {
		if(i == N.length) {
			print();
			return;
		}
		visited[i] = false;
		subSetRecursion(i+1);
		visited[i] = true;
		subSetRecursion(i+1);
		
	}
	public static void print() {
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]){
				System.out.print(N[i] + " ");
			}
		}
		System.out.println();
	}
}
