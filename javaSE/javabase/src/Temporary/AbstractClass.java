package Temporary;

public class AbstractClass {
    public static void main(String[] args) {
        Shape r1 = new Rectangle(4,5);
        Shape s1 = new Square(5);
        Shape c1 = new Circular(3.14,5.0);
        System.out.println(r1.area());
        System.out.println(s1.area());
        System.out.println(c1.area());
    }
}
abstract class Shape{
    protected abstract double area();
    protected final boolean areaCompare(Shape s){
        return this.area()>s.area() ? true:false;
    }
}
abstract class Ellipse extends Shape{
    public int x;
    public int y;
    protected double area(){
        System.out.println("椭圆面积");
        return 0.0;
    }
    public Ellipse(){};
}
class Circular extends Ellipse{
    public final double pi;
    public double r;
    public double area(){
        return this.pi * this.r * this.r;
    }
    Circular(double pi,double r) {
        this.pi = pi;
        this.r = r;
    }

}
abstract class Quadrilateral extends Shape{
    public int a;
    public int b;
    public int c;
    public int d;
}
class Rectangle extends Quadrilateral{
    public int width;
    public  int height;
    public double area(){
        return this.width * this.height;
    }
    public Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }
}
class Square extends Rectangle{
    public Square(int width) {
        super(width, width);
    }
    public double area(){
        return this.width * this.width;
    }
}