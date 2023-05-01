package com.java;

interface oddEven
{
	void evenOdd(int x);
	
}

interface Palindrome
{
	String check(String str);
}

interface PrimeNumber
{
	void prime(int num);
}

interface CoPrime
{
	void coPrime(int x, int y);
}

interface NumberPalindrom
{
	void checkNumber(int num);
}

class LambdaExpressionExample
{
	public static void main(String[] args)
	{
	
		System.out.println("check odd or even number");
		oddEven op1 = (num->{
			if(num%2==0)
				{
				System.out.println("even");
				}
			else
			{
				System.out.println("odd");
			}
				});
		
		op1.evenOdd(5);
		
		System.out.println("check palindrome or not");
		Palindrome obj = ((str)->{
		
			String rev = "";
			int l=str.length();
			for(int i=l-1;i>=0;--i)
			{
				rev = rev+str.charAt(i);
			}
			if(str.equals(rev))
			{
				return "palindrome";
			}
			else
			{
				return "not palindrome";
			}
			
			
			
		});
		
		
		System.out.println(obj.check("madam"));
	
		System.out.println("number is prime or not");
		PrimeNumber pn = (num -> {
			int i;
			int f=0;
			for(i=2;i<=num/2;i++)
			{
				if(num%i==0)
				{
					f=1;
				}
			}
			if(f==0)
			{
				System.out.println(num+" is prime number");
			}
			else
			{
				System.out.println(num+" is not prime number");
			}
			
		});
		
		pn.prime(21);
		pn.prime(5);
		
		
		System.out.println("check coprime or not");
		CoPrime check = ((x,y) -> {
			int hcf = 1;
			for(int i=1; i<=x && i<=y; i++)
			{
				if(x%i==0 && y%i==0)
				{
					hcf=i;
				}
			}
			if(hcf==1)
			{
				System.out.println(x+" and "+y+" are coprime");
			}
			else
				System.out.println("numbers are not coprime");
			
		});
		
		check.coPrime(17, 5);
	
		System.out.println("check number is palindrome or not");
		NumberPalindrom np = (x -> {
			int on = x;
			int rev=0;
			int rem;
			while(x!=0)
			{
				rem = x%10;
				rev = rev*10+rem;
				x/=10;
			}
			if(rev==on)
			{
				System.out.println("number is palindrome:"+on);
			}
			else
			{
				System.out.println("number is not palindrome:"+on);
			}
			
		});
		
		np.checkNumber(181);
		
	}
		
	
}