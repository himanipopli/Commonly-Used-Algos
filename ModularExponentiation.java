package commonAlgos;

public class ModularExponentiation {

	public static void main(String[] args) {
		// TODO auto-generated method stub
		int a = 1000746583, b = 500000074, mod = 1000000007;  //(a^b)%mod  
	    System.out.println("Power is " + power(a, b, mod));
	    System.out.println("Power is " + exponentMod(a, b, mod));
	}
	
	
	public static long power(long a, long b, long mod) 
    { 
        long res = 1;       
        a = a % mod;  
      
        while (b > 0) 
        { 
            if((b & 1)==1) 
                res = (res * a) % mod; 
            b = b >> 1;  
            a = (a * a) % mod;  
        } 
        return res; 
    } 
	
	public static int exponentMod(int a, int b, int mod)   
	{  
		// base cases  
		if (a == 0)  
			return 0;  
		if (b == 0)  
			return 1;  
		// If b is even  
		long y;  
		if (b % 2 == 0) 
		{  
			y = exponentMod(a, b / 2, mod);  
			y = (y * y) % mod;  
		}  
		// If b is odd  
		else 
		{  
			y = a % mod;  
			y = (y * exponentMod(a, b - 1, mod) % mod) % mod;  
		}  
		return (int)((y + mod) % mod);  
	}  

}
