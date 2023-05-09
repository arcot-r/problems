package problems;

public class Substring {
	public boolean isSubsequence(String s, String t) {
        int j =0;
        for(int i=0;i<t.length(); i++){
            if(j <s.length() && s.charAt(j)==t.charAt(i)){
                j++;
            }
        }
        return (j==s.length());
    }
	
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        int[] pattern = new int[t.length()];
        int i=0;
        while(i<s.length()){
            pattern[i]=s.toLowerCase().charAt(i) - 97;
            i++;
        }
        return false;
     }
	
	public static void main(String[] args) {
		Substring prob = new Substring();
//		System.out.println(prob.isSubsequence("abc", "ahbgdc"));
		System.out.println(prob.isIsomorphic("add", "add"));
	}
}
