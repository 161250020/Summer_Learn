package exams.pingduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //获得数组A和B
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        String[] arrayA=strA.split(" ");
        String[] arrayB=strB.split(" ");
        ArrayList<Integer> A=new ArrayList<>();//数组A
        ArrayList<Integer> B=new ArrayList<>();//数组B
        for (String s :arrayA){
            A.add(Integer.parseInt(s));
        }
        for (String s :arrayB){
            B.add(Integer.parseInt(s));
        }
        if(A.size()<=1){
            if (A.size()==0)
                System.out.println();
            else
                System.out.println(A.get(0));
        }
        else{
            //找到A[i]>=A[i+1]的i
            int i=-1;
            for (int index = 0;index< (A.size()-1);index++){
                if (A.get(index)>=A.get(index+1)){
                    i=index;
                    break;
                }
            }
            if(i!=-1){//找到i
                /**
                 * 可以修改A[i]/A[i+1]，最好修改A[i+1]（因为A[i]更大，所以修改后的A[i+1]可以更大），
                 * 但是A[i]需要A[i]<A[i+2]才可以修改A[i+1]，否则需要修改A[i]，
                 * 还有一种就是i+1为数组最后一个值，则修改A[i]或A[i+1]中可以修改且更大的那个
                 */
                int maxB=Integer.MIN_VALUE;
                if (B.size()==0)
                    System.out.println("NO");//没有需要的值，输出NO

                if((i+2)>=A.size()){//A[i+1]为最后的值，最好修改A[i+1]，不然修改A[i]
                    for(int num:B){
                        if ((num>A.get(i))&&(num>=maxB))
                            maxB=num;
                    }
                    if (maxB!=Integer.MIN_VALUE)
                        A.set(i+1,maxB);
                    else{//修改A[i]
                        for(int num:B){
                            if ((num>A.get(i-1))&&(num<A.get(i+1))&&(num>=maxB))
                                maxB=num;
                        }
                        A.set(i,maxB);
                    }
                }
                else {
                    if (A.get(i)<A.get(i+2)){//修改A[i+1]
                        for(int num:B){
                            if ((num>A.get(i))&&(num<A.get(i+2))&&(num>=maxB))
                                maxB=num;
                        }
                        A.set(i+1,maxB);
                    }
                    else{//修改A[i]
                        for(int num:B){
                            if ((num>A.get(i-1))&&(num<A.get(i+1))&&(num>=maxB))
                                maxB=num;
                        }
                        A.set(i,maxB);
                    }
                }

                //如果A依旧不为严格升序，输出NO
                boolean flag = true;
                for (int index=0;index<(A.size()-1);index++)
                    if (A.get(index)>=A.get(index+1)){
                        flag=false;
                        break;
                    }
                if (flag){
                    //输出A
                    printA(A);
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                //输出A
                printA(A);
            }
        }
    }

    private static void printA(ArrayList<Integer> a) {
        StringBuffer out = new StringBuffer();
        for (int numA:a)
            out.append(numA+" ");
        String strOut=out.toString().substring(0,out.toString().length()-1);
        System.out.println(strOut);
    }

}
