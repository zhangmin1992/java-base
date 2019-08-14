package com.my.java.suanfa;

public class MyTreeNode {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
        }
	}
	public static void main(String[] args) {
	}
	
	public static int TreeDepth(TreeNode pRoot){
        if(pRoot == null)
            return 0;
        int left= TreeDepth(pRoot.left)+1;
        int right=TreeDepth(pRoot.right)+1;
        return left>right?left:right;
    }
 
}
