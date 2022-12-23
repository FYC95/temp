import java.sql.Struct;
import java.util.Objects;

public class Rwwrite1 {
    public static void main(String[] args) {
        Peopl p = new Peopl();
        Do d = new Do();
//        d.compare(p);
        d.setAge(3);
        p.setAge(40);
        System.out.println(p.equals(d));
        System.out.println(d);
        System.out.println(p);
    }
}
class Anima{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("吃");
    }
    /*public boolean compare(Anima oth){
        boolean status = this.age> oth.age?true:false;
        return status;
    }*/

    @Override
    public boolean equals(Object oth) {
        boolean flag = false;
        if (oth instanceof Do){
            flag = this.getAge() > (((Do) oth).getAge()*5+20) ? true:false;
        }
        return flag;
    }

    @Override
    public String toString() {
        return "年龄:" +this.getAge();
    }
}
class Peopl extends Anima{
    public void eat(){
        System.out.println("吃粮食");
    }
}
class Do extends Anima{
    public void eat(){
        System.out.println("吃骨头");
    }
    /*public boolean compare(Anima oth){
        boolean status = (this.getAge()*5+20)> oth.getAge()?true:false;
        return status;
    }*/
}