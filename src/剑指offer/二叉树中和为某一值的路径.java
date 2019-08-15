package 剑指offer;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {
    /**
     * 输入一颗二叉树的根节点和一个整数，
     * 打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     * */
    private ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    private ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return lists;

        list.add(root.val);
        target-=root.val;

        //list符合条件就添加
        if (target==0&&root.left==null&&root.right==null)
            lists.add(new ArrayList<Integer>(list));//不可以直接加上list，因为list为一个对象

        //list不符合条件就在root的左子树和右子树里面分别寻找
        FindPath(root.left,target);
        FindPath(root.right,target);
        //将list此次递归添加的值去除，以免影响到其余递归
        list.remove(list.size()-1);
        //是返回lists，而中间过程中FindPath的返回值没有用处，
        //所以对最终的返回值影响不大
        return lists;
    }

}
