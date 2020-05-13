import java.util.*;
public class Solution {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for(int i =0; i< size; i++) arr[i] = sc.nextInt();
		
		int[] gcd = new int[size];
		
		gcd[size-1] = arr[size-1];
		
		for(int i = size-2; i>=0; i--) gcd[i] = gcd(gcd[i+1], arr[i]);
		
		int prev = (arr[0] * gcd[1])/gcd[0];
		
		for(int i = 1; i < size-1; i ++) {
			gcd[i] = gcd(prev, (arr[i] * gcd[i+1])/gcd[i]);
			prev = gcd[i];
		}
		
		System.out.println(prev);
		
	}
	
	public static int gcd(int a, int b) {
		while(true) {
			
			if(a == 0) {
				return b;
			}
			if(b == 0) {
				return a;
			}
			if(a > b) {
				int temp = b;
				b = a%b;
				a = temp;
			}
			else if(b > a) {
				int temp = a;
				a = b%a;
				b = temp;
			}
			else {
				return a;
			}
			
		}
	}
}

