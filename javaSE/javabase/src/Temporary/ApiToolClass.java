package Temporary;

public class ApiToolClass {
    public static void main(String[] args) {
        Person p1 = new Person(7,"zhangsan");
        Person p2 = new Person(5,"lisi");
        Person p3 = new Person(7,"wangwu");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p3.equals(p1));
        System.out.println(p3.equals(p2));
        System.out.println(p1.equals(p2));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
class Person{
    private int id;
    private String name;
    public Person(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "我的类型Person" + this.hashCode();
    }

    @Override
    public int hashCode() {
        int s = 1;
        for (int i = 0; i < 3; i++) {
            s *=this.id;
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if (this.hashCode() == ((Person)obj).hashCode()){flag=true;}
        return flag;
    }
}