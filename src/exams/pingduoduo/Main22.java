package exams.pingduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int S= Integer.parseInt(sc.nextLine());
        String[] inputs=new String[S*2];
        for (int i=0;i<S*2;i++){
            inputs[i]=sc.nextLine();
        }

        //进行第i行和i+1行的数据的处理
        for (int i=0;i<S*2;i+=2){
            System.out.println("{");

            //计算所有操作的方式（字典序列出操作），以及操作的结果，
            //如果结果符合M，则保存该操作
            //输出所有操作，记得末尾要有一个空格
            ArrayList<String> operations=new ArrayList<>();
            String mei=inputs[i];
            String bai=inputs[i+1];
            int N=inputs[i].length();
            int M=inputs[i+1].length();
            ArrayList<String> operate=new ArrayList<>();
            cal(operations,operate,mei,bai);

            for (int j=0;j<operations.size();j++){
                System.out.println(operations.get(j));
            }

            System.out.println("}");
        }
    }

    private static void cal(ArrayList<String> operations, ArrayList<String> operate, String mei, String bai) {
        if (mei.length()==0)
            return;

        StringBuilder op=new StringBuilder();
        if (operate.size()==mei.length()){//已完成一次的排序
            String temp="";//操作的结果
            for (int i=0;i<operate.size();i++){
                op.append(operate.get(i)+" ");
                char c=mei.charAt(i);
                if (operate.get(i).equals("d")){
                    continue;
                }
                else if (operate.get(i).equals("l")){
                    temp=c+temp;
                }
                else {
                    temp=temp+c;
                }
            }
            if (temp.equals(bai)){
                operations.add(op.toString());
            }
            return;
        }
        else {
            operate.add("d");
            cal(operations,operate,mei,bai);
            operate.remove(operate.size()-1);

            operate.add("l");
            cal(operations,operate,mei,bai);
            operate.remove(operate.size()-1);

            operate.add("r");
            cal(operations,operate,mei,bai);
            operate.remove(operate.size()-1);
        }
    }
}
