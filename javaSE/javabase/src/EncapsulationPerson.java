public class EncapsulationPerson {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        Person1 p2 = new Person1();
        Person1 p3 = new Person1();
        p1.setName("zhangsan");
        p1.work(5);
        p2.setName("lisi");
        p2.buy(3);
        p3.work(15);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
class Person1{
    private static int id = 1000;
    private int pID;
    private String name;
    private int age;
    private Double money = 100.5;
    {this.pID = id++;}
    public void setAge(int age){
        if (age < 0){
            this.age = 0;
        } else if (age > 100) {
            this.age = 100;
        }
        else {this.age = age;}
    }
    public void setName(String name){
        if ("admin".equals(name)){
            this.name = "guest";
        }
        else {this.name = name;}
    }

    public int getAge() {
        return age;
    }
    public void work(int n){
        for (int i = 0; i < n; i++) {
            this.money += 10;
        }
    }
    public void buy(int n){
        for (int i = 0; i < n; i++) {
        this.money -= 20;
        }
    }

    @Override
    public String toString() {
        return "Person1{" +
                "pID=" + pID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}