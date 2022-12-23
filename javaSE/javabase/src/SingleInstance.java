public class SingleInstance {
    public static void main(String[] args) {
        Television t1 = Television.getTel();
        Television t2 = Television.getTel();
        System.out.println(t1);
        System.out.println(t2);
        Telev t3 = Telev.getTele();
        Telev t4 = Telev.getTele();
        System.out.println(t3);
        System.out.println(t4);
    }
}
//饿汉式
class Television{
    private static Television tel = new Television();
    private Television(){}
    public static Television getTel(){
        return tel;
    }
}
//懒汉式
class Telev{
    private static Telev tele = null;
    private Telev(){}
    public static Telev getTele(){
        if(tele == null){
            tele = new Telev();
        }
        return tele;
    }
}