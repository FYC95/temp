import java.util.Arrays;

public class methodParameterTransmit1 {

    public static int maxValue(int[] x){
        Arrays.sort(x);
        return x[x.length-1];
    }
    public static double maxValue(double[] x){
        Arrays.sort(x);
        return x[x.length-1];
    }
    public static String maxValue(String[] x){
        Arrays.sort(x);
        return x[x.length-1];
    }


    public static void main(String[] args) {
        int[] a = {18,15,19,23,20};
        double[] b = {4.5,5.6,1.2,0.5};
        String[] c = {"a","a","p","io"};
        System.out.println(maxValue(a));
        System.out.println(maxValue(b));
        System.out.println(maxValue(c));

    }

}
