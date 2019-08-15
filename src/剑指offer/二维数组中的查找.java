package 剑指offer;

public class 二维数组中的查找 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     *
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * */
    public boolean Find(int target, int [][] array) {
        int x=array.length;
        int y=array[0].length;

        //初始化开始的比较节点
        int i=0;
        int j=y-1;
        while(i<x&&j>=0){//节点会往右和往上移动，所以需要设置节点的取值范围
            if (array[i][j]>target)
                j--;
            else if (array[i][j]<target)
                i++;
            else
                return true;
        }

        return false;
    }
}
