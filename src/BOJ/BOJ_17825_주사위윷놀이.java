package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_17825_주사위윷놀이 {
	static int[][] map= {
            {0,2,4,6,8,0,12,14,16,18,0,22,24,26,28,0,32,34,36,38,0,0},
            {0,10,13,16,19,0},    //0,5
            {0,20,22,24,0},    //0,10
            {0,30,28,27,26,0},    //0,15
            {0,25,30,35,40,0}    // 1,4 2,3, 3,4
    };    
    
    static boolean[][] visit;
    
    static int[] dice;
    
    static Pos[] pos;
    
    static int answer;
    static class Pos{
        int i,j;
        Pos(int i,int j){
            this.i=i;this.j=j;
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice=new int[10];
        for(int i=0;i<10;i++) 
            dice[i]=Integer.parseInt(st.nextToken());
        
        visit=new boolean[10][25];
        pos=new Pos[4];
        for(int i=0;i<4;i++) 
            pos[i]=new Pos(0, 0);    //시작점
        
        answer=0;
        dfs(0,0);
        System.out.println(answer);
    }
    
    
    
    static void dfs(int depth,int sum) {
//        System.out.println(depth+" "+sum);
        if(depth==10) {
//            System.out.println(sum);
            answer=Math.max(answer, sum);
            return;
        }
        
        int distance=dice[depth];
        
        for(int index=0;index<4;index++) {
            Pos temp=pos[index];
            if(isDeparture(temp)==true) {
                continue;
            }
            Pos next= move(distance,pos[index]);
            if(isDeparture(next)==true) {    //최종도착이면 방문 상관없이
                pos[index]=next;
                visit[temp.i][temp.j]=false;
                dfs(depth+1,sum+map[next.i][next.j]);
                pos[index]=temp;
                visit[temp.i][temp.j]=true;
            }else if(visit[next.i][next.j]==false) {    //아닐경우 방문 여부체크
                visit[next.i][next.j]=true;
                visit[temp.i][temp.j]=false;
                pos[index]=next;
                dfs(depth+1,sum+map[next.i][next.j]);
                pos[index]=temp;
                visit[temp.i][temp.j]=true;
                visit[next.i][next.j]=false;
            }
        }
    }
    
    static boolean isDeparture(Pos cur) {
        if((cur.i==0 && cur.j==21)||(cur.i==4 && cur.j==5))
            return true;
        return false;
    }
    
    static Pos move(int distance,Pos pos) {
        Pos cur = pos;
        int nextJ=pos.j+distance;
        if(cur.i==0) {
            if(nextJ==5) {
                return new Pos(1,1);    //1로분기
            }else if(nextJ==10) {
                return new Pos(2,1);    //2으로 분기
            }else if(nextJ==15) {
                return new Pos(3,1);    //3으로 분기
            }else if(nextJ==20) {
                return new Pos(4,4);
            }else if(nextJ>20) {
                return new Pos(0, 21);    //도착점
            }else        
                return new Pos(0,nextJ);
        }else if(cur.i==1) {
            if(nextJ==5) {
                return new Pos(4, 1);
            }else if(nextJ>5) {
                nextJ=nextJ-5+1;
                return new Pos(4,nextJ);
            }else
                return new Pos(1,nextJ);
        }else if(cur.i==2) {
            if(nextJ==4) {
                return new Pos(4, 1);
            }else if(nextJ>4) {
                nextJ=nextJ-4+1;
                return new Pos(4,nextJ);
            }else
                return new Pos(2,nextJ);
        }else if(cur.i==3) {
            if(nextJ==5) {
                return new Pos(4, 1);
            }else if(nextJ>5) {
                nextJ=nextJ-5+1;
                return new Pos(4,nextJ);
            }else
                return new Pos(3,nextJ);
        }else if(cur.i==4) {
            if(nextJ>=5) {
                return new Pos(4, 5);
            }else
                return new Pos(4,nextJ);
        }
        return null;
    }
    
    static String src = "1 2 3 4 1 2 3 4 1 2";
}
