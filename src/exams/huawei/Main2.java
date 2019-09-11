package exams.huawei;

import java.util.*;

public class Main2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=null;
        ArrayList<String> lines=new ArrayList<>();
        while (!(line=sc.nextLine()).equals("")){
            lines.add(line);
        }
        for (int k=0;k<lines.size();k++){
            line=lines.get(k);
            String[] numStrs=line.split(" ");
            if (numStrs.length==6){
                ArrayList<Integer> nums=new ArrayList();
                Set<Integer> canReach=new HashSet();
                for (int i=0;i<numStrs.length;i++){
                    nums.add(Integer.parseInt(numStrs[i]));
                }
                canReach.add(nums.get(0));//设第一个节点是可达的
                nums.remove(0);

                //对于index为1~5的节点的周围节点是否在Set当中，若在，则将该节点加入进去
                while (true){
                    int notIn=0;
                    for (int i=0;i<nums.size();i++){
                        int top=(nums.get(i)-10)>0?(nums.get(i)-10):0;
                        int behind=(nums.get(i)+10)>45?0:(nums.get(i)+10);
                        int left=((nums.get(i)-1)%10>=1)&&((nums.get(i)-1)%10<=5)?(nums.get(i)-1):0;
                        int right=((nums.get(i)+1)%10>=1)&&((nums.get(i)+1)%10<=5)?(nums.get(i)+1):0;
                        if ((top!=0)&&canReach.contains(top)){
                            canReach.add(nums.get(i));
                            nums.remove(i);
                            continue;
                        }
                        if ((behind!=0)&&canReach.contains(behind)){
                            canReach.add(nums.get(i));
                            nums.remove(i);
                            continue;
                        }
                        if ((left!=0)&&canReach.contains(left)){
                            canReach.add(nums.get(i));
                            nums.remove(i);
                            continue;
                        }
                        if ((right!=0)&&canReach.contains(right)){
                            canReach.add(nums.get(i));
                            nums.remove(i);
                            continue;
                        }

                        notIn++;
                    }

                    if (nums.size()==0){
                        System.out.println("1");
                        break;
                    }

                    if (notIn==nums.size()){
                        System.out.println("0");
                        break;
                    }
                }
            }
            else {
                System.out.println(0);
            }

        }
        }



}
