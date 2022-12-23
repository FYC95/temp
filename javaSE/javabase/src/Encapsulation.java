public class Encapsulation {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");
        System.out.println(employee.toString());
    }
}
class Employee{
    private String name;
    public void setName(String name){
//        this.name = name;
        if (name == ""){
            this.name = "guest";
            return;
        }
        if (name == "admin"){
            System.out.println("用户名不能是admin");
//            this.name = "用户名不能是admin";
            return;
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}