package 剑指offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * */
public class 序列化二叉树 {
    //序列化的部分包含了叶子节点的左右子节点（即：null节点）
    String Serialize(TreeNode root) {
        StringBuffer sb=new StringBuffer();
        if (root==null){
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val+"!");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index=-1;
    TreeNode Deserialize(String str) {
        index++;
        int len=str.length();
        if (index>=len)return null;
        String[] strs=str.split("!");
        TreeNode node=null;
        if (!strs[index].equals("#")){
            node=new TreeNode(Integer.valueOf(strs[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;//使用#符号来判断什么时候需要递归的返回
    }
}
