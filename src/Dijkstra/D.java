
import java.util.*;
import java.io.*;

public class D {
	public static void main(String args[])throws Exception
	{

		FileReader fr = new FileReader("Input1.txt");
		BufferedReader br = new BufferedReader(fr);

		int nodes=Integer.parseInt(br.readLine());
		System.out.println(nodes);
		int weightarr[][]=new int[nodes][nodes];
		for(int i=0;i<nodes;i++)
		for(int j=0;j<nodes;j++)
			weightarr[i][j]=0;
		String str;
		for (int i=0;i<nodes;i++)
		{

			str=br.readLine();
	
			System.out.println(str);
			String s[]=null;
			s=str.split(",");
			
				int first = Integer.parseInt(s[0]);
				//System.out.println(x);
			
			int k=1;
			for (int j=0;j<first;j++)
			{
					String again[]= s[k].split(":");
					weightarr[i][Integer.parseInt(again[0])-1]=Integer.parseInt(again[1]);
					//System.out.println(weightarr[i][Integer.parseInt(again[0])-1]);
					k++;
			}

		}
		for(int i=0;i<nodes;i++)
			{
				for(int j=0;j<nodes;j++)
					System.out.print(weightarr[i][j]+" ");
				System.out.println();
			}
			System.out.println();

			int edgefrom[]=new int[nodes];
			int dist[]=new int[nodes];
			int inf=1000;
			dist[0]=0;
			for(int i=1;i<nodes;i++)
				dist[i]=inf;

			int source=0;

			int visited[][]=new int[nodes][nodes];

			for(int i=0;i<nodes;i++)
				for(int j=0;j<nodes;j++)
					visited[i][j]=0;

			for(int i=source,j=0;j<nodes;j++)
			{
				visited[i][j]=weightarr[i][j];
				if(weightarr[i][j]!=0){
				dist[j]=weightarr[i][j];
				edgefrom[j]=i;
				}
			}

			int o=0,r=0;
			int lastmin=0;

			for(int e=0;e<18;e++){
			int min=1000;
			for(int i=0;i<nodes;i++){
				for(int j=i;j<nodes;j++)
					if((visited[i][j]!=0 && visited[i][j]!=-1)&& visited[i][j]<min)
					{
						min=visited[i][j];
						o=i;
						r=j;
					}
			}
			source=r;
			visited[o][r] = -1;
			

			for(int i=source,j=0;j<nodes;j++){
				if(visited[i][j]!=-1){
				visited[i][j] = weightarr[i][j];
				if(visited[i][j]!=0){
					//System.out.println(dist[j]+" "+(dist[i]+visited[i][j]));
					if(dist[j] > dist[i] + visited[i][j]){
						dist[j] = dist[i] + visited[i][j];
						edgefrom[j] = i;
					}
				}
			}
			}
			lastmin = min;
			}

			//for(int i=0;i<nodes;i++)
				//System.out.print(dist[i]+" ");

			for(int i=0;i<nodes;i++){
				int path[] = new int[nodes];
				int k = 0;
				path[k++] = i;
				System.out.print ("Distance of the path "+ dist[i]+" ");
				int j = i;
				while(j!=0){
					path[k++] = edgefrom[j];
					j = edgefrom[j];
				}
				System.out.println();
				System.out.print("Path is ");
				for(int l=k-1;l>=0;l--)
					if(l==0)
						System.out.print(path[l]);
					else
						System.out.print(path[l]+"--->");
					//System.out.print("  Distance of this path is "+dist[i++]);
				System.out.println();

			}
			

	}
}