public class Rewrite {
    public static void main(String[] args) {
        SubHunter subHunter = new SubHunter();
        Hunter hunter = new Hunter();
        hunter.work();
        subHunter.work();
    }
}
class Hunter{
    public void work(){
        System.out.println("使用弓箭打猎");
    }
}
class SubHunter extends Hunter{
    @Override
    //重写权限大于等于父类，返回值声明与父类一致，返回值类型小于等于父类,方法名一致
    public void work(){
        System.out.println("使用猎枪打猎");
    }
}