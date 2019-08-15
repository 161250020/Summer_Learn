package 剑指offer;

public class 数组中出现次数超过一半的数字 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，
     * 请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，
     * 超过数组长度的一半，
     * 因此输出2。
     * 如果不存在则输出0。
     * */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0)
            return 0;

        //进行加一，减一的计算，以得到最小值
        int min=array[0];
        int minNum=1;
        for (int i=1;i<array.length;i++){
            if (minNum==0){
                min=array[i];
                minNum=1;
            }

            if (array[i]==min)
                minNum++;
            else
                minNum--;
        }

        //进行验证是否该数字在数组中出现的次数是超过一半的
        int appearNum=0;
        for (int i=0;i<array.length;i++){
            if (array[i]==min)
                appearNum++;
        }
        if (appearNum*2>array.length)
            return min;
        else
            return 0;
    }

}
