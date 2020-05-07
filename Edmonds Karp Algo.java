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
	            HashMap<Integer,Integer> parent=new HashMap<>();
	            bfsPath(residue,0,n-1,parent);
	            int temp=findMin(residue,parent,0,n-1);
	            if(temp==Integer.MAX_VALUE){
	                break;
	            }
	            ans+=temp;
	        }
	        System.out.println(ans);
	    }
	 }
	 public static void bfsPath(int[][] residue,int s,int e,HashMap<Integer,Integer> parent){
	     Queue<Integer> q=new LinkedList<>();
	     boolean[] vis=new boolean[residue.length];
	     q.add(s);
	     vis[s]=true;
	     while(!q.isEmpty()){
	         int temp=q.poll();
	         if(temp==e){
	             return;
	         }
	         for(int i=0;i<residue.length;i++){
	             if(residue[temp][i]>0&&!vis[i]){
	                 vis[i]=true;
	                 q.add(i);
	                 parent.put(i,temp);
	             }
	         }
	     }
	 }
	 public static int findMin(int[][] residue,HashMap<Integer,Integer> parent,int s,int e){
	     int min=Integer.MAX_VALUE;
	     int eOrg=e;
	     while(parent.containsKey(e)){
	         int p=parent.get(e);
	         min=Math.min(min,residue[p][e]);
	         e=p;
	     }
	     if(e==s){
	         e=eOrg;
	         while(parent.containsKey(e)){
    	         int p=parent.get(e);
    	         residue[p][e]-=min;
    	         residue[e][p]+=min;
    	         e=p;
    	     }
	         return min;
	     }
	     return Integer.MAX_VALUE;
	 }
}
