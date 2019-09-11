package test;

public class Main {
    public static void main(String[] agrs){
        SuperExample e = new SuperExtendExample(1, 2, 3);
        e.func();
        System.out.println(e.x+"---"+e.y);
    }
}
