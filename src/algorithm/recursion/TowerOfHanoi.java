package algorithm.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
	int n = 3;
	tower(n, "A", "B", "C");
    }

    private static void tower(int n, String src, String dest, String aux) {
	// if there is only one disk left move it to destination from source
	if (n == 1)
	    System.out.println(n + " : " + src + " --> " + dest);
	else {
	    // recursively move n-1 disks from source to the aux tower
	    tower(n - 1, src, aux, dest);
	    // move nth disk from src to dest tower
	    System.out.println(n + " : " + src + " --> " + dest);
	    // rescursively move n-1 desks from aux tower to dest tower
	    tower(n - 1, aux, dest, src);
	}
    }
}
