package algorithm.backtracking;

public class InterleavingStrings {

    public static void main(String[] args) {
	String c = "XXY";
	String a = "XY";
	String b = "X";

	System.out.println(new InterleavingStrings().isInterLeave(a, b, c));
    }

    public boolean isInterLeave(String a, String b, String c) {
	return isInterLeave(a, 0, b, 0, c, 0);
    }

    public boolean isInterLeave(String a, int ia, String b, int ib, String c, int ic) {
	// termination conditions
	if (ic <= c.length() && ia == a.length() && ib == b.length())
	    return true;
	if (ic >= c.length() && (ia < a.length() || ib < b.length()))
	    return false;

	// recursively compare current char of string a and c
	// the first case is if you pick the current character and the second
	// case is when you don't
	if (ia < a.length() && a.charAt(ia) == c.charAt(ic) && isInterLeave(a, ia + 1, b, ib, c, ic + 1))
	    return true;
	if (ib < b.length() && b.charAt(ib) == c.charAt(ic) && isInterLeave(a, ia, b, ib + 1, c, ic + 1))
	    return true;
	return false;
    }
}
