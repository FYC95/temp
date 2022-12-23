package Temporary;

public class ExceptionHandling {
    public static void main(String[] args) {
        Case c1 = new Case();
        Splice s1 = new Splice();
        int[] ages = {18,15,19,23,0};
        try {
        System.out.println(s1.splip(ages));
        }catch (RuntimeException e){
            System.out.println(e);
//            throw e;//向上抛出异常
        }finally {
            System.out.println("一定执行的代码,开关作用");//保底处理
        }
        boolean f;
        try {
            f = c1.compare("abf","shj");
        }catch (NullPointerException e){
            e.printStackTrace();
            throw e;
        }catch (Exception e){e.printStackTrace();}
    }
}
class Splice{
    public double splip(int[] arr){
        int s = 0;
        for (int i = 0; i < arr.length-1; i++) {
            s += arr[i];
        }
        return s/arr[arr.length-1];
    }
    public Splice(){};
}
class Case{
    public boolean compare(String a,String b){
        boolean flag = false;
        if (a.compareToIgnoreCase(b)>=0){flag = true;}
        else if (a.compareToIgnoreCase(b)<0) {flag = false;}
        return flag;
    }
    public Case(){}
}
