import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        int[] ages = {18,15,19,23,20};
        int[] dst = new int[5];
        System.out.println(ages);
//        System.arraycopy(ages,1,dst,0,2);
        /*for (int i = 0; i < ages.length; i++) {
            dst[i] = ages[i];
            System.out.println(dst[i]);
        }*/

        System.arraycopy(ages,0,dst,0,5);
        Arrays.sort(dst);
        for (int i = 0; i < dst.length; i++) {
            System.out.println(dst[i]);
        }
        System.out.println(Arrays.binarySearch(dst,23));


    }
}
