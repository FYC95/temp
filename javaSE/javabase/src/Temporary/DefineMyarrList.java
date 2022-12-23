package Temporary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefineMyarrList {
    public static void main(String[] args) {
//        List<Number> nums = new ArrayList<>();
        MyArrayList nums = new MyArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.pop();
        System.out.println(nums);
    }
}
interface  MyContainer{
    int size();
    boolean isEmpty();
    void add(Integer obj);
    void remove(Integer obj);
}
class MyArrayList implements MyContainer{
    private Integer[] eleData = new Integer[3];
    private int spaceNumber = 3;
    private int nSize = 0;
    @Override
    public int size() {
        return this.nSize;
    }

    @Override
    public boolean isEmpty() {
        return this.nSize == 0;
    }

    @Override
    public void add(Integer obj) {
        if(this.nSize >= this.spaceNumber){
            Integer[] temp = new Integer[2*spaceNumber];
            for (int i = 0; i < this.eleData.length; i++) {
                temp[i] = this.eleData[i];
            }
            this.eleData = temp;
        }
        this.eleData[nSize] = obj;
        nSize ++;
    }
    public Integer get(int index){
        if (index < 0 || index > nSize){
            index = 0;
        }
        return this.eleData[index];
    }

    @Override
    public void remove(Integer obj) {

    }
    public Integer pop(){
        Integer ret = this.eleData[this.nSize - 1];
        Integer[] temp = new Integer[spaceNumber];
        if (this.nSize-1 <= this.spaceNumber/2){
            temp = new Integer[spaceNumber/2];
            System.out.println("eleLength:"+this.eleData.length);
            for (int i = 0; i < this.nSize-1; i++) {
                temp[i] = this.eleData[i];
            }
            this.eleData = temp;
            this.nSize--;
        }else {
            for (int i = 0; i < this.nSize-1; i++) {
            temp[i] = this.eleData[i];
        }
        this.eleData = temp;this.nSize--;}
        return ret;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "eleData=" + Arrays.toString(eleData) +
                ", spaceNumber=" + spaceNumber +
                ", nSize=" + nSize +
                '}';
    }
}