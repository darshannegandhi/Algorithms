import java.io.*;
import java.util.*;

class kruskals
{
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
					System.out.println(weightarr[i][Integer.parseInt(again[0])-1]);
					k++;
			}

		}
		for(int i=0;i<nodes;i++)
			{
				for(int j=0;j<nodes;j++)
					System.out.print(weightarr[i][j]+" ");
				System.out.println();
			}

		int unique[]=new int[nodes];

		for(int i=0;i<nodes;i++)
			unique[i]=i;
		//for(int i=0;i<nodes;i++)
		//	System.out.println(unique[i]);

		int min;
		int lastmin=0;
		int o,r;
		int mstd=0;
		
		min=1000;
		int pool1[] = new int[nodes];
		int pool2[] = new int[nodes];

		int count=0;
		while(count<8)
		{
			o=-1;
			r=-1;
			min=1000;
			for(int i=0;i<nodes;i++)
				for(int j=i;j<nodes;j++)
					if(weightarr[i][j]!=0 && weightarr[i][j]<min && weightarr[i][j]>lastmin)
					{
						min=weightarr[i][j];
						o=i;
						r=j;
					}
					//System.out.println(min+" "+count+" "+unique[o]+" "+unique[r]);

					if(unique[o]!=unique[r])
					{
						mstd+=min;
						pool1[count] = o;
						pool2[count] = r;
						count+=1;
						//System.out.println(unique[o]+" "+unique[r]);

						int tochange = unique[r];

						for(int i=0;i<nodes;i++)
						{
							if(unique[i]==tochange)
								unique[i]=unique[o];
						}
					}
					System.out.println(mstd);
					lastmin=min;
		}
		System.out.println("Minimum Spanning cost using kruskals is :");
		System.out.println(mstd);
		System.out.println("The edge set is as follows: ");
		for(int i=0;i<count;i++)
			System.out.print(pool1[i]+"--"+pool2[i]+" , ");

	}
}