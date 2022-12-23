package Temporary;

public class InterfacePractice2 {
    public static void main(String[] args) {
        Shape1 r1 = new Rectangle1(4,5);
        Shape1 s1 = new Square1(5);
        Shape1 c1 = new Circular1(3.14,5.0);
        /*Shape1[] arr = new Shape1[3];
        arr[0] = r1;
        arr[1] = s1;
        arr[2] = c1;*/
        System.out.println(r1.area());
        System.out.println(s1.area());
        System.out.println(c1.area());
        System.out.println(r1.areaCompare(s1));
        System.out.println(c1.areaCompare(s1));
        System.out.println(c1.areaCompare(r1));
    }
}
interface Shape1{
    double area();
    default boolean areaCompare(Shape1 s){
        return this.area()>s.area() ? true:false;
    }
}
class Ellipse1 implements Shape1{
    public int x;
    public int y;
    public double area(){
        System.out.println("椭圆面积");
        return 0.0;
    }
}
class Circular1 extends Ellipse1{
    public final double pi;
    public double r;
    public double area(){
        return this.pi * this.r * this.r;
    }
    Circular1(double pi,double r) {
        this.pi = pi;
        this.r = r;
    }

}
interface Quadrilateral1 extends Shape1{
    public static final int a=1;
    public int b=2;
    public int c=3;
    public int d=3;
}
class Rectangle1 implements Quadrilateral1{
    public int width;
    public  int height;
    public double area(){
        return this.width * this.height;
    }
    public Rectangle1(int width,int height){
        this.width = width;
        this.height = height;
    }
}
class Square1 extends Rectangle1{
    public Square1(int width) {
        super(width, width);
    }
    public double area(){
        return this.width * this.width;
    }
}