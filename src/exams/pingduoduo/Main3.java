package exams.pingduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] Args) {
        //读入任务和依赖
        int proNum = -1;
        int relyNum = -1;
        ArrayList<Integer> proTimes = new ArrayList<>();//所有任务所需时间
        proTimes.add(0);//占位第0个位置，该任务不执行
        //所有依赖情况，ArrayList<Integer>存其之前需要执行的程序
        ArrayList<ArrayList<Integer>> relys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        proNum = Integer.parseInt(line1.split(" ")[0]);
        relyNum = Integer.parseInt(line1.split(" ")[1]);
        String line2 = sc.nextLine();
        String[] times = line2.split(" ");
        for (String time : times)
            proTimes.add(Integer.parseInt(time));
        //初始化依赖---几个任务则有几个数组的依赖
        for (int i = 0; i < (proNum + 1); i++)
            relys.add(new ArrayList<>());
        for (int i = 0; i < relyNum; i++) {
            String lineRely = sc.nextLine();
            int pre = Integer.parseInt(lineRely.split(" ")[0]);//依赖于这个
            int lat = Integer.parseInt(lineRely.split(" ")[1]);//待执行任务
            ArrayList<Integer> rely = relys.get(lat);
            rely.add(pre);
            relys.set(lat, rely);
        }

        //排出一个最佳的任务执行顺序，按照任务时间和index的顺序，不包含第0个任务
        ArrayList<Integer> timePre = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            for (int j = 1; j < proTimes.size(); j++) {
                if (proTimes.get(j) == i)
                    timePre.add(j);
            }
        }
        //设一个:已执行任务的序列
        ArrayList<Integer> alExec = new ArrayList<>();
        //对于每一个依赖数组而言，如果所有以来都在alExec当中，且在timePre中的位置靠前，则可以执行
        while (alExec.size() != proNum) {
            for (int i = 0; i < timePre.size(); i++) {//保证为时间最少的靠前的任务先执行
                int proIndex = timePre.get(i);//该任务为第几个任务
                if (!alExec.contains(proIndex)) {//该任务未执行
                    ArrayList<Integer> rely = relys.get(proIndex);//获得该任务所有依赖
                    if (rely.size() == 0) {//该任务没有依赖，则直接执行
                        alExec.add(proIndex);
                    } else {
                        boolean flag = true;//该任务所有依赖是否都包含在alExec当中
                        for (int j = 0; j < rely.size(); j++) {
                            if (!alExec.contains(rely.get(j))) {//alExec不包含需要依赖的任务
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            alExec.add(proIndex);
                    }
                }
            }
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < alExec.size(); i++) {
            s.append(alExec.get(i) + " ");
        }
        String out = s.toString().substring(0, s.toString().length() - 1);
        System.out.println(out);

    }

}
