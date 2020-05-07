import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 //code
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    for(int k=0;k<t;k++){
	        int n=scan.nextInt();
	        int m=scan.nextInt();
	        int[][] residue=new int[n][n];
	        for(int i=0;i<m;i++){
	            int x=scan.nextInt()-1;
	            int y=scan.nextInt()-1;
	            int z=scan.nextInt();
	            residue[x][y]+=z;
	            residue[y][x]+=z;
	        }
	        int ans=0;
	        while(true){
	            boolean[] vis=new boolean[n];
	            int temp=dfs(residue,0,n-1,vis,Integer.MAX_VALUE);
	            if(temp==Integer.MAX_VALUE){
	                break;
	            }
	            ans+=temp;
	        }
	        System.out.println(ans);
	    }
	 }
	 public static int dfs(int[][] residue,int s,int e,boolean[] vis,int min){
	     if(s==e){
	         return min;
	     }
	     vis[s]=true;
	     for(int i=0;i<residue.length;i++){
	         if(residue[s][i]>0&&!vis[i]){
	             int temp=dfs(residue,i,e,vis,Math.min(min,residue[s][i]));
	             if(temp!=Integer.MAX_VALUE){
	                 residue[s][i]-=temp;
	                 residue[i][s]+=temp;
	                 return temp;
	             }
	         }
	     }
	     return Integer.MAX_VALUE;
	 }
}
