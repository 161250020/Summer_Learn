package exams.beikezhaofang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        //输入内容
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(sc.nextLine());
            nums.add(temp);
        }

        int maxLen = -1;
        for (int i = 0; i < num; i++) {
            int cal = cal(nums, i, i);//数组，当前比较的最大值的index，最大开始查找的index
            if (cal > maxLen)
                maxLen = cal;
        }

        /*
        //对于每个index的数而言，计算他的最长的子串，记录最长子串的长度
        int maxLen = -1;
        int minCur=Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {//对于序列当中的每一个数字而言
            int len = 1;//记录当前子串的长度
            int ptrNum = nums.get(i);//记录当前子串需要大于的数值

            //如果前面<=该值的数字已经计算过，则该值无需再次计算
            if (ptrNum>=minCur){
                continue;
            }
            else {
                minCur=ptrNum;
            }

            for (int j = i + 1; j < num; j++) {
                if(nums.get(j)>ptrNum){
                    len++;
                    ptrNum=nums.get(j);
                }
            }

            if (len>maxLen)
                maxLen=len;
        }*/

        System.out.println(maxLen);
    }

    private static int cal(ArrayList<Integer> nums, int curIndex, int moreIndex) {
        if (moreIndex == (nums.size() - 1))//最后一个元素，返回0
            return 0;
        else {
            int one = -1;
            if (nums.get(moreIndex + 1) > nums.get(curIndex))//后一个元素大于当前元素
                one = cal(nums, moreIndex + 1, moreIndex + 1);

            int two = cal(nums, curIndex, curIndex + 1);

            return Math.max(one, two);
        }
    }
}
