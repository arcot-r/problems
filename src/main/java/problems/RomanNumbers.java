package problems;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
	public int convertToInt(String s) {
		int ans = 0, num = 0, prev =0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			ans = (num < prev) ? ans - num : ans + num;
			prev = num;
		}

		return ans;
	}
	
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) res -= map.get(s.charAt(i));
            else res += map.get(s.charAt(i));
        }
        return res + map.get(s.charAt(s.length()-1));
    }

	public static void main(String[] args) {
		RomanNumbers roman = new RomanNumbers();
		System.out.println("RomanNumbers.main()= " + roman.convertToInt("MMMMMMMMMMMMMM"));
		System.err.println("value = "+roman.romanToInt("MMMMMMMMMMMMMM"));
	}
}
