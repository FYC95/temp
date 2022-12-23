public class ChainMethod {
    public static void main(String[] args) {
        Actor a = new Actor();
        Brackets brackets = new Brackets();
        a.drink().smoke();
        brackets.fun1().fun1();
        System.out.println(brackets.getName());
    }
}
class Actor{
    public Actor smoke(){
        System.out.println("抽烟");
        return this;
    }
    public Actor drink(){
        System.out.println("喝酒");
        return this;
    }
}
class Brackets{
    private String name;
    public Brackets (){
        this.name = "anonymous";
    }
    public Brackets fun1(){
        this.name = "[" + this.name + "]";
        return this;
    }
    public String getName(){
        return name;
    }
}