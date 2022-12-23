package Temporary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StdSeleceSystem {
    public static void main(String[] args) {
        List<Student> stds = new ArrayList();
        Student s1 = new Student("zhangsan",18,true);
        Student s2 = new Student("lisi",19,false);
        Student s3 = new Student("Wangwu",20,false);
        Student s4 = new Student("zhaoliu",21,true);
        stds.add(s1);
        stds.add(s2);
        stds.add(s3);
        stds.add(s4);
        System.out.println("共有学生数"+stds.size());
        System.out.println(stds.get(2));
        for (int i = 0; i < stds.size(); i++) {
            System.out.println(stds.get(i));
        }
        System.out.println(stds.contains(s1));
        LinkedList<Student> stdsTrue = new LinkedList<>();
        for (int i = 0; i < stds.size(); i++) {
            stdsTrue.add(0,stds.get(i));
        }
    }
}
class Student{
    private String name;
    private int age;
    private boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Student(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}