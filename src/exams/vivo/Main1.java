package exams.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//少了一种可能：input[0]==0的时候是直接返回-1的，因为跳不了，除非input的长度为1
public class Main1 {

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
        if (input.length==0)return -1;
        if (input.length==1)return 0;

        int[] dp=new int[input.length];
        for (int i=0;i<dp.length;i++)dp[i]=-1;
        dp[0]=0;
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<i;j++){
                //从第j个跳到第i个
                if (input[j]>=(i-j)){
                    if (dp[i]!=-1)dp[i]=Math.min(dp[i],dp[j]+1);
                    else dp[i]=dp[j]+1;
                }
            }
        }

        return dp[dp.length-1];
    }
}