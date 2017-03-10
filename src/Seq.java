class Seq{

	public static void main(String args[]){
	
		String a = "AGGCTATCACCTGACCTCCAGGCCGATGCCC";
		String b = "TAGCTATCACGACCGCGGTCGATTTGCCCGAC";
		
		int gap = 1;
		int mismatch = 2;
		
		int m = a.length();
		int n = b.length();
		
		int c[][] = new int[m][n];
		
		for(int i=0;i<m;i++)
			c[i][0] = i;
		
		for(int j=0;j<n;j++)
			c[0][j] = j;
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(a.charAt(i-1)!=b.charAt(j-1))
					c[i][j] = Math.min(Math.min(c[i][j-1]+gap,c[i-1][j]+gap),c[i-1][j-1]+mismatch);
				else
					c[i][j] = Math.min(Math.min(c[i][j-1]+gap,c[i-1][j]+gap),c[i-1][j-1]);
			}
		}

		for(int i=1;i<m;i++)
			{
				for(int j=1;j<n;j++)
				System.out.print(c[i][j] + " ");
				System.out.println();
			}
		System.out.println("The cost of alignment is "+ c[m-1][n-1]);
		
	}
}
