package exams.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main21 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String nums=line.split(";")[0];
        int N= Integer.parseInt(line.split(";")[1]);
        String[] numsStr=nums.split(",");
        int[] numsInt=new int[numsStr.length];
        for (int i=0;i<numsStr.length;i++){
            numsInt[i]=Integer.parseInt(numsStr[i]);
        }

        //对数组进行排序
        Arrays.sort(numsInt);
        int[] numsInt2=new int[numsInt.length];
        //先将偶数放在前面
        int index=0;
        for (int i=numsInt.length-1;i>=0;i--){
            if (numsInt[i]%2==0){//为偶数
                numsInt2[index]=numsInt[i];
                index++;
            }
            if (index==N)
                break;
        }
        //将奇数放在后面
        if (index<N){
            for (int i=numsInt.length-1;i>=0;i--){
                if (numsInt[i]%2==1){//为奇数
                    numsInt2[index]=numsInt[i];
                    index++;
                }
                if (index==N)
                    break;
            }
        }

        StringBuilder toPrint=new StringBuilder();
        for (int i=0;i<(N-1);i++){
            toPrint.append(numsInt2[i]);
            toPrint.append(",");
        }
        toPrint.append(numsInt2[N-1]);

        System.out.println(toPrint.toString());
    }
}
