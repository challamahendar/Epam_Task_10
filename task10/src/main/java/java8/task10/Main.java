//*Author : G VISHNU SAI
 //*********************************************************************************
/* 1. Write a method that returns the average of a list of integers. 
 * 
 * 2. Given a list of Strings, write a method that returns a list of all strings
 *    that start with the letter 'a' (lower case) and have exactly 3 letters. 
 *    (TIP: Use Java 8 Lambdas and Streams API's.) 
 *    
 * 3. Given a list of Strings (that contains both palindromes and nonpalindromes),
 *    write a method that returns a list of all the palindrome strings.  
 *   (TIP: Use static method references of Functional Interfaces )
*/
//--------------------------------------------------------------------------------------------

package java8.task10;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import org.apache.commons.lang3.StringUtils;

class Avg
{
	public static double avg1(List<Integer> arr)
	{//regular method.
		double sum=0;
		int len=arr.size();
		for(int i=0;i<len;i++)
			sum+=arr.get(i);
		return sum/len;
	}
	
	public static double avg2(List<Integer> arr)
	{//using streams.
		 return (double)(arr.stream().filter(j->j!=0).mapToInt(i -> i).sum())/arr.size(); 
	}
}

class alist
{
	public static List<String> alis(List<String> al2)
	{
		return al2.stream().filter(i->(i.length()==3 && i.charAt(0)=='a')).collect(Collectors.toList());
	}
}

class palin
{
	public static List<String> plis1(List<String> al3)
	{
		return al3.stream().filter(i->i.equals(StringUtils.reverse(i))).collect(Collectors.toList());
	}
	
	public static List<String> plis2(List<String> al3)
	{
		return al3.stream().filter(i->i.equalsIgnoreCase(StringUtils.reverse(i))).collect(Collectors.toList());
	}
}



public class Main
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		Avg m1=new Avg();
		alist m2=new alist();
		palin m3=new palin();
		
		int ch;
		
		while(true)
		{
			System.out.println("Select one of the operation :");
			System.out.println("1. To return the average of a list of Integers\n"+"2. To return a list of all strings that start with the letter 'a' and have exactly 3 letters \n"+"3. To return a list of all the palindrome strings.\n"+"4.To Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				ArrayList<Integer> al=new ArrayList<Integer>();
				System.out.println("Enter the size of the List :");
				int n1=sc.nextInt();	//Size of the list
				System.out.println("Enter "+n1+" Integers below:");
				//long sum=0;
				for(int i=0;i<n1;i++)
					al.add(sc.nextInt());
				System.out.println("The average of the elements of the list is as follows : ");
				System.out.println("Without using streams - "+m1.avg1(al));
				System.out.println("Using Streams - "+m1.avg2(al));
				break;
				
				
			case 2:
				ArrayList<String> al2=new ArrayList<String>();
				System.out.println("Enter the size of the List :");
				int n2=sc.nextInt();	//Size of the list
				System.out.println("Enter "+n2+" Strings below:");
				for(int i=0;i<n2;i++)
					al2.add(sc.next());
				System.out.println("The List of strings of size 3 and starting with a are as follows:");
				System.out.println(m2.alis(al2));
				break;
				
			case 3:
				ArrayList<String> al3=new ArrayList<String>();
				System.out.println("Enter the size of the List :");
				int n3=sc.nextInt();	//Size of the list
				System.out.println("Enter "+n3+" Strings below:");
				for(int i=0;i<n3;i++)
					al3.add(sc.next());
				System.out.println("The output as follows :");
				System.out.println("Case - sensitive : "+m3.plis1(al3));
				System.out.println("Cases Ignored : "+m3.plis2(al3));
				break;
			case 4 : System.out.println("The Exit");
					System.exit(0);
					
			default : System.out.println("Enter a valid input\n\n");
				break;
			}
		}
	}
}