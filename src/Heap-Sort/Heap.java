import java.io.*;

class Heap
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
			int count=0;
		for(int i=0;i<nodes;i++)
				for(int j=i;j<nodes;j++)
					if(weightarr[i][j]!=0)
						count++;

		int arr[]=new int[count];
		int k1=0;
		for(int i=0;i<nodes;i++)
				for(int j=i;j<nodes;j++)
					if(weightarr[i][j]!=0)
					{	arr[k1]=weightarr[i][j];
						k1++;
					}


		int i=0,f=0,s=0;

		//if(arr.length==0)
		//return;

		for (i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			s=i;
			f=(s-1)/2;

			while(s>0 && arr[f]<temp)
			{
				arr[s]=arr[f];
				s=f;
				f=(s-1)/2;
			}
			arr[s]=temp;
		}
		System.out.println();
		System.out.println("This is max-heapified array");
		for(i=0;i<arr.length;i++)
		System.out.print(arr[i]+" ");


		for (i=arr.length-1;i>0;i--)
		{
			int temp2=arr[i];
			arr[i]=arr[0];
			f=0;

			if(i==1)
				s=-1;
			else
				s=1;

			if(i>2 && arr[2]>arr[1])
				s=2;

			while(s>=0 && temp2<arr[s])
			{
				arr[f]=arr[s];
				f=s;
				s=2*f+1;

				if(s+1<i-1 && arr[s]<arr[s+1])
					s++;

				if(s>i-1)
					s=-1;
			}

			arr[f]=temp2;
		}
		System.out.println();
		System.out.println("Sorted Array: ");
		for(i=0;i<arr.length;i++)
		System.out.print(arr[i]+"  ");

	}
}