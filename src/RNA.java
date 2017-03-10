import java.io.*;
import java.util.*;

class RNA
{
	 
	static int BaseOrNot( int m, int n )
	{
		if ( m=='U' && n=='G' || m=='G' && n=='U' || m=='U' && n=='A' || m=='A' && n=='U' || m=='C' && n=='G' || m=='G' && n=='C')
		{
			return 1;
		}

		else
			return 0;
	}

	static int CheckWatCrick( int m, int n)
	{
		if ( m=='U' && n=='A' || m=='A' && n=='U' || m=='C' && n=='G' || m=='G' && n=='C')
		{
			return 1;
		}

		else
			return 0;
	}

	public static void main(String args[])
	{
		String s="AUGGCUACCGGUCGAUUGAGCGCCAAUGUAAUCAUU";
		int min = 4, max = 80;
		char arr[]=new char[max];
		char temp[]=new char[80];

		for(int i=0;i<max;i++)
		temp[i]=0;
		for(int i=0;i<max;i++)
		{
			arr[i]=0;
		}
		
		for(int i=0;i<s.length();i++)
		{arr[i]=s.charAt(i);
		}

		int count = s.length();

		int basePairs[][]=new int[80][80];

		for (int i=0;i<80;i++)
			for(int j=0;j<80;j++)
				{
					basePairs[i][j]=0;
				}


		int var=min;
		int inter=0,check=0,cvar=0;
		while(var<count)
		{
			for(int i=0;i<count;i++)
			{
				inter=i+var;

				if(inter<count)
				{
					check=0;
					cvar=count;

					if(basePairs[i][inter-1]>check)
					{
						check=basePairs[i][inter-1];
						cvar=count;
					}

					int retval = CheckWatCrick(arr[i],arr[inter])+basePairs[i+1][inter-1];
				
					if((inter-1)<=min && retval>check)
					{
						check=retval;
						cvar=i;
					}
					for(int j=i; j<=(inter-min); j++)
					{
						if(j!=0)
						retval = CheckWatCrick(arr[j],arr[inter])+basePairs[i][j-1] + basePairs[j+1][inter-1];
						
						else
							retval = CheckWatCrick(arr[j],arr[inter])+ basePairs[j+1][inter-1];
						if(retval>check)
						{
							check=retval;
							cvar=j;
						}
					}
					basePairs[i][inter]=check;
					if(cvar<count)
						basePairs[inter][i]=cvar;
					else
						basePairs[inter][i]=-1;
				}
			}
			var++;
		}
		System.out.println("Max number of pairs ="+check);

		// Now we calculate the values of the pairs using a recurrence function

		calculateValues(0,count-1,arr,basePairs,temp);



	}


	static void calculateValues(int m,int n,char arr[],int basePairs[][], char[] temp){

		int pairValue=basePairs[n][m];
		if(pairValue>-1)
		{
			System.out.println("The value of base pair is "+arr[pairValue]+"&"+arr[n]+" at positions "+pairValue+" & "+n);
			if(((n-1)-(pairValue+1))>=4)
				calculateValues(pairValue+1,n-1,arr,basePairs,temp);
			if((pairValue-m-1)>=4)
				calculateValues(m,pairValue-1,arr,basePairs,temp);

		}

		else
		{
			if(4<=n-m-1)
			{
				calculateValues(m,n-1,arr,basePairs,temp);
			}

		}
	}


}