package exams.duxiaoman;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class Main {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] split=sc.nextLine().split(" ");
        int x=Integer.parseInt(split[0]);
        int y=Integer.parseInt(split[1]);
        int n=Integer.parseInt(split[2]);
        int[] x_is=new int[n];
        int[] y_is=new int[n];
        int min_x=Integer.MAX_VALUE;
        int min_y=Integer.MAX_VALUE;
        int max_x=Integer.MIN_VALUE;
        int max_y=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            String[] spl2=sc.nextLine().split(" ");
            int curx=Integer.parseInt(spl2[0]);
            int cury=Integer.parseInt(spl2[1]);
            x_is[i]=curx;
            y_is[i]=cury;
            if (curx<min_x)
                min_x=curx;
            if (curx>max_x)
                max_x=curx;
            if (cury<min_y)
                min_y=cury;
            if (cury>max_y)
                max_y=cury;
        }

        if (x==0&&y==0)
            System.out.println(0);

        ArrayList<String> path=new ArrayList<>();
        move(0,0,x,y,
                min_x-1,min_y-1,max_x+1,max_y+1,
                x_is,y_is,path);
        System.out.println(min);

    }
    private static void move(int startx, int starty, int endx, int endy,
                             int min_x,int min_y,int max_x,int max_y,int[] x_is,int[] y_is, ArrayList<String> path) {
        if (startx==endx&&starty==endy){
            if (path.size()<min)
                min=path.size();
            return;
        }

        //向左移动
        if ((startx-1>=min_x)&&(!path.contains((startx-1)+","+starty))){
            boolean flag=false;//无障碍
            for (int i=0;i<x_is.length;i++){
                if (x_is[i]==startx-1&&y_is[i]==starty){
                    flag=true;
                    break;
                }
            }
            if (!flag){
                path.add((startx-1)+","+starty);
                move(startx-1,starty,endx,endy,
                        min_x,min_y,max_x,max_y,
                        x_is,y_is,path);
                path.remove(path.size()-1);
            }
        }
        //向右移动
        if ((startx+1<=max_x)&&(!path.contains((startx+1)+","+starty))){
            boolean flag=false;//无障碍
            for (int i=0;i<x_is.length;i++){
                if (x_is[i]==startx+1&&y_is[i]==starty){
                    flag=true;
                    break;
                }
            }
            if (!flag){
            path.add((startx+1)+","+starty);
            move(startx+1,starty,endx,endy,
                    min_x,min_y,max_x,max_y,x_is,y_is,path);
            path.remove(path.size()-1);}
        }
        //向上移动
        if ((starty-1>=min_y)&&(!path.contains((startx)+","+(starty-1)))){
            boolean flag=false;//无障碍
            for (int i=0;i<x_is.length;i++){
                if (x_is[i]==startx&&y_is[i]==starty-1){
                    flag=true;
                    break;
                }
            }
            if (!flag){
            path.add((startx)+","+(starty-1));
            move(startx,starty-1,endx,endy,
                    min_x,min_y,max_x,max_y,x_is,y_is,path);
            path.remove(path.size()-1);}
        }
        //向下移动
        if ((starty+1<=max_y)&&(!path.contains((startx)+","+(starty+1)))){
            boolean flag=false;//无障碍
            for (int i=0;i<x_is.length;i++){
                if (x_is[i]==startx&&y_is[i]==starty+1){
                    flag=true;
                    break;
                }
            }
            if (!flag){
            path.add((startx)+","+(starty+1));
            move(startx,starty+1,endx,endy,
                    min_x,min_y,max_x,max_y,x_is,y_is,path);
            path.remove(path.size()-1);}
        }

    }

}
