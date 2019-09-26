package exams.vivo;

import java.io.*;

/**
 * Welcome to vivo !
 */

public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {
        StringBuffer s=new StringBuffer();

        int start=0;
        int N=input[0];
        int M=input[1];
        int[] nums=new int[N];
        for (int i=0;i<nums.length;i++)nums[i]=i+1;
        int tempM=M;
        while (N>0){
            if (nums[start]!=0){
                tempM--;
                if (tempM==0){
                    s=s.append(nums[start]+" ");
                    nums[start]=0;
                    N--;
                    tempM=M;
                }
            }
            start++;
            start%=nums.length;
        }
        String str=s.toString();
        return str.substring(0,str.length()-1);
    }

}
