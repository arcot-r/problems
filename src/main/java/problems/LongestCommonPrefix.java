package problems;

import java.util.Arrays;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		String s1 = strs[0];
		String s2 = strs[strs.length - 1];
		int idx = 0;
		while (idx < s1.length() && idx < s2.length()) {
			if (s1.charAt(idx) != s2.charAt(idx)) {
				break;
			}
			idx++;
		}

		return s1.substring(0, idx);
	}

	public static void main(String[] args) {
		String[] str1 = { "flower", "flow", "flight" };
		String[] str2 = { "dog", "racecar", "car" };
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println("LongestCommonPrefix.main()" + lcp.longestCommonPrefix(str1));
		System.err.println("Error"+lcp.longestCommonPrefix(str2));
		System.out.println("flower".startsWith("flight"));
	}
}
