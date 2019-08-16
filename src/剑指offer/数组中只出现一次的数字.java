package 剑指offer;

public class 数组中只出现一次的数字 {
    //一个整型数组里除了两个数字之外，
    //其他的数字都出现了两次。
    //请写程序找出这两个只出现一次的数字。
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    /*
    位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
    当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，
    最后剩下的就是落单的数，因为成对儿出现的都抵消了。
    依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
    我们首先还是先异或，剩下的数字肯定是A、B异或的结果，
    这个结果的二进制中的1，表现的是A和B的不同的位。
    我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
    分组标准是第3位是否为1。如此，相同的数肯定在一个组，
    因为相同数字所有位都相同，而不同的数，肯定不在一组。
    然后把这两个组按照最开始的思路，依次异或，
    剩余的两个结果就是这两个只出现一次的数字。

    思路：
        将两个不同的数字通过异或分到两个不同的数组里面，
        这两个数组里面会有成对的相同的数据，
        这样再分别对这两个数组里面的数据进行异或，
        最后分别异或出来的结果就是：存入数组的不同数字；
        PS：原题给了num1和num2就是提醒我们去分成两个数组进行计算；
    */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length=array.length;
        if (length<2)
            return;
        if (length==2){
            num1[0]=array[0];
            num2[0]=array[1];
            return;
        }

        int bitResult=0;//存储异或的结果
        for (int i=0;i<array.length;i++)
            bitResult^=array[i];

        int index=first1(bitResult);
        num1[0]=0;
        num2[0]=0;
        //num1[0]存储倒数第index位为1的数字们的异或结果
        //num2[0]存储倒数第index位为0的数字们的异或结果
        for (int i=0;i<array.length;i++){
            if (bitIs1(array[i],index-1))
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }

    //为target元素向右移位num个位数之后，
    //返回移位结果的最后一位是否为1的判断
    private boolean bitIs1(int target,int num) {
        return ((target>>num)&1)==1;
    }

    //返回：该数字的二进制，倒数第几位为1
    private int first1(int bitResult) {
        int index=1;
        while (index<=32){
            if ((bitResult&1)>0)
                break;
            bitResult>>=1;
            index++;
        }
        return index;
    }

}
