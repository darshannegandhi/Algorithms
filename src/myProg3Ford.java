
import java.util.*;
import java.io.*;

class myProg3Ford{

	static int a[][],link[];
	
	public static void main(String args[]){
		
		int totalV = 8;
		
		int g[][] = new int[totalV][totalV];
		
		g[0][0] = 0;
		g[0][1] = 10;
		g[0][2] = 5;
		g[0][3] = 15;
		g[0][4] = 0;
		g[0][5] = 0;
		g[0][6] = 0;
		g[0][7] = 0;
		
		g[1][0] = 0;
		g[1][1] = 0;
		g[1][2] = 4;
		g[1][3] = 0;
		g[1][4] = 9;
		g[1][5] = 15;
		g[1][6] = 0;
		g[1][7] = 0;
		
		g[2][0] = 0;
		g[2][1] = 0;
		g[2][2] = 0;
		g[2][3] = 4;
		g[2][4] = 0;
		g[2][5] = 8;
		g[2][6] = 0;
		g[2][7] = 0;
		
		g[3][0] = 0;
		g[3][1] = 0;
		g[3][2] = 0;
		g[3][3] = 0;
		g[3][4] = 0;
		g[3][5] = 0;
		g[3][6] = 30;
		g[3][7] = 0;
		
		g[4][0] = 0;
		g[4][1] = 0;
		g[4][2] = 0;
		g[4][3] = 0;
		g[4][4] = 0;
		g[4][5] = 15;
		g[4][6] = 0;
		g[4][7] = 10;
		
		g[5][0] = 0;
		g[5][1] = 0;
		g[5][2] = 0;
		g[5][3] = 0;
		g[5][4] = 0;
		g[5][5] = 0;
		g[5][6] = 15;
		g[5][7] = 10;
		
		g[6][0] = 0;
		g[6][1] = 0;
		g[6][2] = 6;
		g[6][3] = 0;
		g[6][4] = 0;
		g[6][5] = 0;
		g[6][6] = 0;
		g[6][7] = 10;
		
		g[7][0] = 0;
		g[7][1] = 0;
		g[7][2] = 0;
		g[7][3] = 0;
		g[7][4] = 0;
		g[7][5] = 0;
		g[7][6] = 0;
		g[7][7] = 0;
		
		int source = 0;
		int target = 7;
		
		a = new int[totalV][totalV];
		
		for(int x=0;x<totalV;x++)
			for(int y=0;y<totalV;y++)
				a[x][y] = g[x][y];
		
		link = new int[totalV];
		
		int MAXfinal = 0;
		
		while(thereispath(source,target,totalV)==1){
			int MAXoverflow = Integer.MAX_VALUE;
			for(int next=target;next!=source;next=link[next]){
				int x = link[next];
				MAXoverflow = Math.min(MAXoverflow,a[x][next]);
			}
			
			for(int next=target;next!=source;next=link[next]){
				int x = link[next];
				a[x][next] -= MAXoverflow;
				a[next][x] += MAXoverflow;
			}
			
			MAXfinal += MAXoverflow;
		}
		
		System.out.println("The maximum cost would be "+MAXfinal);
		
	}
	
	static int thereispath(int src,int tar,int totalV){
		
		boolean vis[] = new boolean[totalV];
		
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		
		que.addFirst(src);
		vis[src] = true;
		
		while(!que.isEmpty()){
			int current = que.pollFirst();
			
			for(int i=0;i<totalV;i++){
				if(vis[i]==false && a[current][i]>0){
					que.addFirst(i);
					link[i] = current;
					vis[i] = true;
				}
			}
		}
		
		if(vis[tar]==true)
			return 1;
		else
			return 0;
	}
}
