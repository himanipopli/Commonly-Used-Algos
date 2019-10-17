package commonAlgos;
import java.util.*;
public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int gcd=gcd(a,b);
		System.out.println(gcd);
	}
	public static int gcd(int a,int b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}

}
