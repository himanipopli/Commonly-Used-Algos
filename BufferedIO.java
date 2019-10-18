package commonAlgos;
import java.util.*;
import java.io.*;

public class BufferedIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String line=br.readLine();
		String[] strs=line.trim().split("\\s+");
		long a[]=new long[n];
		for(int i=0;i<n;i++) {
			  a[i]=Long.parseLong(strs[i]);
//			a[i]=Integer.parseInt(strs[i]);
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
