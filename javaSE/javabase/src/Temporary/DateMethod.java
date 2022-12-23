package Temporary;
import java.util.Date;

public class DateMethod {
    public static void main(String[] args) {
        Date date = new Date();
        Caculate caculate = new Caculate();
        System.out.println(caculate.ca());
    }
}
class Caculate{
    public Long ca(){
        int s = 0;
        long t0 = System.currentTimeMillis();
        for (int i = 1; i < 1000001; i++) {
            s += i;
        }
        long t1 = System.currentTimeMillis();
        return (t1 - t0);
    }
}
