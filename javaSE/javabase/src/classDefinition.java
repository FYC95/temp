public class classDefinition {
    public static void main(String[] args) {
        Student zs = new Student();
        zs.name = "zhangsan";
        zs.age = 23;
        zs.showMe();
        Phone phone = new Phone();
        phone.phoneName = "华为";
        phone.price = 2399.0;
        phone.size = 6;
        phone.showMe();
    }
}

class Student {
    String name;
    Integer age;//包装类，方便调用包装类属性和方法
    private long sn;
    private double score;

    public void showMe() {
        System.out.println("我的姓名是:" + name + "年龄:" + age);
    }
}

class Phone {
    String phoneName;
    long phoneNumber;
    float size;//包装类，方便调用包装类属性和方法
    double price;

    public void showMe() {
        System.out.println("手机品牌:" + phoneName + "价格:" + price + "尺寸（寸）:" + size);
    }
}

