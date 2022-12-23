package Temporary;

public interface InterfacePractice {

}
interface USB{
    void transferData();//默认为public abstract
    default public void test(){
        System.out.println("接口默认方法");
    }
}
class Electronic{
    protected double Voltage;
}
class Computer extends Electronic implements USB, InterfacePractice {
    private int cpu;
    public Computer(){
        this.Voltage = 3.5;
        this.cpu = 1;
    }
    public void transferData(){}
}
class Phone extends Electronic implements USB{
    public void transferData(){}

    @Override
    public void test() {
        USB.super.test();
    }
}