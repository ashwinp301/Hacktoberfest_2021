public class LongestCommonSubsequence {

	public static int lcs(String s1,String s2,int n,int m) {
		if(n==0 || m==0)
			return 0;
		if(s1.charAt(n-1)==s2.charAt(m-1))
			return 1+lcs(s1,s2,n-1,m-1);
		return Math.max(lcs(s1,s2,n-1,m),lcs(s1,s2,n,m-1));
	}
	
	public static int lcsTopDown(String s1,String s2,int n,int m,Integer[][] ar) {
		if(n==0||m==0)
			return 0;
		
		if(ar[n][m] == null) {
			if(s1.charAt(n-1)==s2.charAt(m-1))
				ar[n][m] = 1+lcsTopDown(s1,s2,n-1,m-1,ar);
			else
			 ar[n][m]= Math.max(lcsTopDown(s1,s2,n-1,m,ar),lcsTopDown(s1,s2,n,m-1,ar));
		}
		return ar[n][m];
	}
	
	public static int lcsBottomUp(String s1,String s2,int n,int m) {
		if(n==0 || m==0)
			return 0;
		int[][] ar = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					ar[i][j]=1+ar[i-1][j-1];
				}
				else {
					ar[i][j]=Math.max(ar[i][j-1],ar[i-1][j]);
				}
			}
		}
		return ar[n][m];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1="ecfbefdcfca";
		String s2="badfcbebbf";
		
		System.out.println(LongestCommonSubsequence.lcs(s1, s2,s1.length(),s2.length()));
		
		Integer[][] arr = new Integer[s1.length()+1][s2.length()+1];
		System.out.println(LongestCommonSubsequence.lcsTopDown(s1, s2,s1.length(),s2.length(), arr));
		System.out.println(LongestCommonSubsequence.lcsBottomUp(s1, s2,s1.length(),s2.length()));
	}

}
