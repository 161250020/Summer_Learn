package exams.xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] nums=sc.nextLine().split(" ");
        int n=Integer.parseInt(nums[0]);
        int m=Integer.parseInt(nums[1]);
        int k=Integer.parseInt(nums[2]);
        int[][] points=new int[n][m];//有障碍物的点使用1来表示

        for (int i=0;i<k;i++){
            String[] xy=sc.nextLine().split(" ");
            int x=Integer.parseInt(xy[0]);
            int y=Integer.parseInt(xy[1]);
            points[x][y]=1;
        }

        //使用图来解决
        ArrayList<String> path=new ArrayList<>();
        ArrayList<Integer> lengths=new ArrayList<>();
        move(0,0,n-1,m-1,points,path,lengths);

        if (lengths.size()==0)
            System.out.println(0);
        else {
            int min=lengths.get(0);
            for (int i=1;i<lengths.size();i++)
                min=Math.min(min,lengths.get(i));
            System.out.println(min);
        }
    }

    private static void move(int startx, int starty, int endx, int endy, int[][] points, ArrayList<String> path, ArrayList<Integer> lengths) {
        if (startx==endx&&starty==endy){//之前这里写错了，写成了||，应该是&&
            lengths.add(path.size());
            return;//忘记加这个了！！！，一定要加，不然就是无限循环的超时了
        }

        //向左移动
        if ((startx-1>=0)&&(points[startx-1][starty]!=1)&&(!path.contains((startx-1)+","+starty))){
            path.add((startx-1)+","+starty);
            move(startx-1,starty,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
        //向右移动
        if ((startx+1<=points.length-1)&&(points[startx+1][starty]!=1)&&(!path.contains((startx+1)+","+starty))){
            path.add((startx+1)+","+starty);
            move(startx+1,starty,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
        //向上移动
        if ((starty-1>=0)&&(points[startx][starty-1]!=1)&&(!path.contains((startx)+","+(starty-1)))){
            path.add((startx)+","+(starty-1));
            move(startx,starty-1,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
        //向下移动
        if ((starty+1<=points[0].length-1)&&(points[startx][starty+1]!=1)&&(!path.contains((startx)+","+(starty+1)))){
            path.add((startx)+","+(starty+1));
            move(startx,starty+1,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }

    }

}
