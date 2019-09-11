package exams.xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        char[][] points=new char[N][N];
        int startx=0,starty=0,endx=0,endy=0;
        for (int i=0;i<N;i++){//第i行
            String line=sc.nextLine();
            for (int j=0;j<line.length();j++){
                char c=line.charAt(j);
                points[i][j]=c;
                if (c=='S'){
                    startx=i;
                    starty=j;
                }

                if (c=='E'){
                    endx=i;
                    endy=j;
                }
            }
        }

        //达到则输出最短长度，无法到达则输出-1
        ArrayList<String> path=new ArrayList<>();
        ArrayList<Integer> lengths=new ArrayList<>();
        cal(startx,starty,endx,endy,points,path,lengths);

        if (lengths.size()==0){
            System.out.println(0);
        }
        else {
            int min=lengths.get(0);
            for (int i=1;i<lengths.size();i++)
                min=Math.min(min,lengths.get(i));
            System.out.println(min+1);
        }
    }

    private static void cal(int startx, int starty, int endx, int endy, char[][] points, ArrayList<String> path, ArrayList<Integer> lengths) {
        if (startx==endx&&starty==endy){
            lengths.add(path.size());
            return;
        }

        //向左移动
        int lx=(startx-1+points.length)%points.length;
        if ((points[lx][starty]!='#')&&(!path.contains(lx+","+starty))){
            path.add(lx+","+starty);
            cal(lx,starty,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
        //向右移动
        int rx=(startx+1)%points.length;
        if ((points[rx][starty]!='#')&&(!path.contains(rx+","+starty))){
            path.add(rx+","+starty);
            cal(rx,starty,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
        //向上移动
        int uy=(starty-1+points.length)%points.length;
        if ((points[startx][uy]!='#')&&(!path.contains((startx)+","+uy))){
            path.add((startx)+","+uy);
            cal(startx,uy,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
        //向下移动
        int dy=(starty+1)%points.length;
        if ((points[startx][dy]!='#')&&(!path.contains((startx)+","+dy))){
            path.add((startx)+","+dy);
            cal(startx,dy,endx,endy,points,path, lengths);
            path.remove(path.size()-1);
        }
    }
}
