package 二叉树;


/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author mark
 *
 */
public class _226_翻转二叉树 {

	// 前序遍历
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
         
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
    }
	
	public static void main(String[] args) {
		
	}

}
