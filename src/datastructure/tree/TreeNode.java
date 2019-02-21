/**
 * 
 */
package datastructure.tree;

/**
 * <b> Properties of binary tree</b><br/>
 * <ol><li> Max nodes at level l = 2^(l -1)</li>
 * <li> Max nodes in tree of height h = 2^h - 1</li>
 * <li> BT of N nodes, min possible height/levels = log2(N + 1)</li>
 * <li> BT of L leaves, min possible levels = log2(L) + 1</li>
 * </ol>
 * @author skedia
 * @param <T>
 *
 */
public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this(data);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode [left=" + left + " ] " + " data= " + data + "[ right= " + right + " ]";
    }

}
