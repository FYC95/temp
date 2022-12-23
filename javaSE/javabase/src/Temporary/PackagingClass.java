package Temporary;

public class PackagingClass {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(4);
        Integer c = new Integer(5);
        Integer d = 156;
        int e = 156;
        System.out.println(a.equals(b));
        Integer ab = Integer.parseInt("123456");
        String s = new String("123456");
//        s.valueOf(s);
        byte eb = (byte)e;
        System.out.println(eb);
        System.out.println(d.byteValue());
//        byte db = (byte)d;
    }
}
