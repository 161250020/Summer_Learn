package test;

public class Overload {
    public int a(Object o){
        return 1;
    }
    public int a(String s){
        return 2;
    }
    public static void main(String[] args){
        System.out.println(new Overload().a(null));
    }
}
