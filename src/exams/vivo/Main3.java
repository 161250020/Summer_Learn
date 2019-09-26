package exams.vivo;

import java.io.*;

/**
 * Welcome to vivo !
 */
//挖矿矿石
//这道题目超时了，其实是可以剪枝的：
// 假设余下a个数字没有遍历，而背包当中还需要放置a个石头，那么余下a个都放进去就好，无需考虑余下的石头是否是不需要放置
//也可以使用01背包问题
public class Main3 {

    public static int min=Integer.MAX_VALUE;
    public static int sum=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        if (input.length==0)return 0;

        //无论是技术个还是偶数个：
        //挑选len/2个放在一边，使得总重量尽可能为总砝码重量的一半
        int len=input.length;
        for (int i=0;i<input.length;i++)sum+=input[i];
        int count=len/2;
        int reach=0;
        cal(input,count,reach,0);

        return min;
    }

    private static void cal(int[] input, int count, int reach,int index) {
        if (count==0){
            min=Math.min(min,Math.abs(sum-reach-reach));
            return;
        }
        if (index==input.length)return;

        cal(input,count,reach,index+1);
        cal(input,count-1,reach+input[index],index+1);

    }
}
