package number.palindrome;

public class Palindrome {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int y = x;
		int rev = 0;
		while (y != 0) {
			rev = rev * 10 + y % 10;
			y /= 10;
		}

		return x == rev;

	}
	
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		System.err.println(p.isPalindrome(15251));
	}
}
