public class functionMethod {
    public static void printStar1(int num){
        for (int i = 0; i <= num; i++) {
            System.out.print("*");
        }
    }
    public static void printStar2(){

            System.out.print("\n*********");
    }
    public static void main(String[] args) {
        printStar1(15);
        printStar2();

    }
}
