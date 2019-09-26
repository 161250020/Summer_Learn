package exams.dongfangcaifu;

import java.util.*;

public class Main {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] spl1=sc.nextLine().split(",");
        String[] spl2=sc.nextLine().split(",");
        int[] num1=new int[spl1.length];
        int[] num2=new int[spl2.length];
        for (int i=0;i<spl1.length;i++)num1[i]=Integer.parseInt(spl1[i]);
        for (int i=0;i<spl2.length;i++)num2[i]=Integer.parseInt(spl2[i]);

        Arrays.sort(num1);
        Arrays.sort(num2);

        ArrayList<Integer> arr=new ArrayList<>();
        int ptr1=0;
        int ptr2=0;
        while (true){
            for (int i=0;i<=ptr2&&i<num2.length;i++){
                int sum=num1[ptr1]+num2[ptr2];
                if (!arr.contains(sum))arr.add(sum);
            }
            for (int i=0;i<=ptr1&&i<num1.length;i++){
                int sum=num1[ptr1]+num2[ptr2];
                if (!arr.contains(sum))arr.add(sum);
            }
            if (arr.size()>=3)break;
            else{
                ptr1++;
                ptr2++;
            }
        }

        int[] sums=new int[arr.size()];
        for (int i=0;i<arr.size();i++)sums[i]=arr.get(i);
        Arrays.sort(sums);
        System.out.println(sums[0]+","+sums[1]+","+sums[2]);
    }
}
