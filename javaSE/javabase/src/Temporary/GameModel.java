package Temporary;

public class GameModel {
    public static void main(String[] args) {
        Role w1 = new Warrior(3000,100,200);
        Role a1 = new Archer(2000,50,300);
        Role a2 = new Archer(3000,50,300);
        Role au1 = new Auxiliary(4000,150,100);
        System.out.println(a1.PK(w1));
        System.out.println(a2.PK(au1));
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(w1);
        System.out.println(au1);
    }
}
class Role implements Attack{
    public String role;
    protected int bloodVolume = 3000;
    protected int defenseValue = 100;
    protected int attackPower = 200;
    public Role(int b,int d,int a){
        this.bloodVolume = b;
        this.defenseValue = d;
        this.attackPower = a;
    }
    public int PK(Role r){
        int flag = 0;
        while (this.bloodVolume>=0 && r.bloodVolume>=0){
            attack(this,r);
            attack(r,this);
            if (this.bloodVolume == 0 && r.bloodVolume == 0){flag = 0;}
            else if (r.bloodVolume <= 0) {flag = 1;}
            else if (this.bloodVolume <= 0) {flag = -1;}
        }
        return flag;
    }
}
interface Attack{
    default Role attack(Role r1,Role r2){
        r2.bloodVolume = r2.bloodVolume - r1.attackPower + r2.defenseValue;
        return r2;
    }
}
interface Treat{
    default Role treat(Role r){
        r.bloodVolume += r.bloodVolume * 0.2;
        return r;
    }
}
class Warrior extends Role implements Attack{
    public String role = "Warrior";
    public Warrior(int b,int d,int a){
        super(b, d, a);
    }
    public String toString() {
        return this.role+"{" +
                "bloodVolume=" + bloodVolume +
                '}';
    }
}
class Archer extends Role implements Attack{
    public String role = "Archer";
    public Archer(int b,int d,int a){
        super(b, d, a);
    }
    public String toString() {
        return this.role+"{" +
                "bloodVolume=" + bloodVolume +
                '}';
    }
}
class Auxiliary extends Role implements Treat{
    public String role = "Auxiliary";
    public Auxiliary(int b,int d,int a){
        super(b, d, a);
    }
    public String toString() {
        return this.role+"{" +
                "bloodVolume=" + bloodVolume +
                '}';
    }
}
