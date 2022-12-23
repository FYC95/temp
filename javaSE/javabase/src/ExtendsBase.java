public class ExtendsBase {
    public static void main(String[] args) {
//        Person person = new Person();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("英短",2.0F);
//        Botany botany = new Botany();
        /*System.out.println(person.age);
        System.out.println(cat.age);
        person.eat();
        cat.eat();
        System.out.println(person.life);
        System.out.println(cat.life);
        System.out.println(botany.ability);*/
    }
}
class Biology{
    boolean life = true;
    public Biology(){
        System.out.println("生物类空参构造");
    }
}
class Botany extends Biology{
    boolean ability;
    Double photosynthesis = 0.0;
    public Botany(){
        System.out.println("植物类空参构造");
    }
}
class Animal extends Biology{
    int age;
    Boolean hungry = true;
    public void eat(){
        System.out.println("吃");
    }
    public Animal(){
        System.out.println("动物类空参构造");
    }
}
class Person extends Animal{
    int iq = 90;
    public Person(){
        System.out.println("人类空参构造");
    }
}
class Cat extends Animal{
    String type;
    Float hair;
    public Cat(){
        super();
        System.out.println("猫科类空参构造");
    }
    public Cat(Float hair) {
        this();
        this.hair = hair;
        System.out.println("猫科毛发参数构造");
    }
    public Cat(String type, Float hair) {
        this(hair);
        this.type = type;
        System.out.println("猫科类品种参数构造");
    }
}