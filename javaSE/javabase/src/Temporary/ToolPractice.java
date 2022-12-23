package Temporary;

public class ToolPractice {
    public static void main(String[] args) {
        String s = "123.45";
        int n = 144;

        Float sf = new Float(s);
        Float sf1 = Float.valueOf(s);
        Float v = Float.parseFloat(s);
        System.out.println(v);
        System.out.println(Float.parseFloat(s));

        System.out.println(Double.parseDouble(s));
        Integer ni = new Integer(n);
        String.valueOf(n);


        String S = "abc";
        StringBuffer s1 = new StringBuffer("abc");
        StringBuilder s2 = new StringBuilder("abc");
        System.out.println(S.equals(s1));
        System.out.println(S.equals(s2));
        System.out.println(s1.equals(s2));

    }
}
class Transfer{

}