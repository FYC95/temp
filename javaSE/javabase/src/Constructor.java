public class Constructor {
    public static void main(String[] args) {
        StudentInformation ls = new StudentInformation();
        ls.showMe();
        StudentInformation zs = new StudentInformation("zhangsan", 27);
        zs.showMe();
        StudentInformation ww = new StudentInformation("ww",19,true);
        ww.showMe();
    }
}
    class StudentInformation {
        private String name;
        private int age;//包装类，方便调用包装类属性和方法
        private boolean gender;

        //创建构造函数
        public StudentInformation(){
            System.out.println("1");
        }

        public StudentInformation(String name, int age, boolean gender) {
            this(name, age);
            this.gender = gender;
        }

        public StudentInformation(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("2");
        }
        public void showMe() {
            System.out.println("姓名是:" + name + ",年龄:" + age);
        }
    }

