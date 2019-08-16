package 剑指offer;

public class 平衡二叉树 {
    //输入一棵二叉树，判断该二叉树是否是平衡二叉树
    //平衡二叉树每个结点的左右子树高度相差小于等于1
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    //若发现左右子树相差大于1，就返回-1；否则，返回的是该节点的树的高度；
    private int getDepth(TreeNode root) {
        if (root==null)return 0;
        int left=getDepth(root.left);
        if (left==-1)return -1;
        int right=getDepth(root.right);
        if (right==-1)return -1;

        //左右子树各自都是平衡的，
        //那么他们的高度相差如果大于1，则返回-1；
        //否则返回：左右子树高度最高的高度+1；
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }

}
