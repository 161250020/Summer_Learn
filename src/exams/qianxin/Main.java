package exams.qianxin;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] PIDS=sc.nextLine().split(" ");
        String[] PPIDS=sc.nextLine().split(" ");
        String PID=sc.nextLine();

        HashSet<String> finPids=new HashSet<>();
        boolean contain=false;
        for (int i=0;i<PIDS.length;i++){
            if (PIDS[i].equals(PID))
                contain=true;
        }
        if (contain){
            finPids.add(PID);
            while (true){
                int in=0;
                for (int i=0;i<PPIDS.length;i++){
                    String ppid=PPIDS[i];
                    String pid=PIDS[i];
                    if (finPids.contains(ppid)&&(!finPids.contains(pid))){
                        in++;
                        finPids.add(pid);
                    }
                }
                if (in==0)
                    break;
            }
        }
        System.out.println(finPids.size());
    }

}
