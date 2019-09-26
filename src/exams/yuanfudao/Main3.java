package exams.yuanfudao;

import java.util.ArrayList;
import java.util.Scanner;

class Classroom{
    int num;//学生个数
    String tid;
    String className;
    ArrayList<String> sids;

    public Classroom(int num,String tid,String className,ArrayList<String> sids){
        this.num=num;
        this.tid=tid;
        this.className=className;
        this.sids=sids;
    }
}
class record{
    String cmdj;
    String userid;
    int time;

    public record(String cmdj,String userid,int time){
        this.cmdj=cmdj;
        this.userid=userid;
        this.time=time;
    }
}
public class Main3 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] spl=sc.nextLine().split(" ");
        int N= Integer.parseInt(spl[0]);
        int M= Integer.parseInt(spl[1]);

        Classroom[] classrooms=new Classroom[M];
        record[] records=new record[N];
        for (int i=0;i<M;i++){
            String[] spl2=sc.nextLine().split(" ");
            ArrayList<String> sids=new ArrayList<>();
            for (int j=0;j<Integer.parseInt(spl2[0]);j++)
                sids.add(spl2[j+3]);
            classrooms[i]=new Classroom(Integer.parseInt(spl2[0]),
                    spl2[1],spl2[2],sids);
        }
        for (int i=0;i<N;i++){
            String[] spl2=sc.nextLine().split(" ");
            records[i]=new record(spl2[0],spl2[1],Integer.parseInt(spl2[2]));
        }

        int[] tSums=new int[M];
        int[] sSums=new int[M];
        for(int i=0;i<M;i++){//第i个班级
            int tSum=0;
            int sSum=0;
            for (int j=0;j<N;j++){//第j个记录
                if (records[j].userid.equals(classrooms[i].tid)&&records[j].cmdj.equals("IN")){//为该班级老师的进入记录
                    //找到最近的老师的出记录

                }
                else if (classrooms[i].sids.contains(records[j].userid)&&records[j].cmdj.equals("IN")){//为该班级同学的进入记录
                    //找到最近的该同学的出记录

                }
            }
            tSum *= classrooms[i].num;
        }
    }
}
