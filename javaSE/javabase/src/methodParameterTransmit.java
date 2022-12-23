public class methodParameterTransmit {
    public int add(int x,int y){
        int z =x+y;
        return z;
    }

    public static  void getX(int x){
        x = 3*x;
    }
    public static  void getY(int[] y){
        y[0] = y[0]*3;
    }

    public static void main(String[] args) {
        /*methodParameterTransmit fd = new methodParameterTransmit();
        int x = fd.add(10,20);
        System.out.println(x);
        int y = fd.add(100,200);
        System.out.println(y);*/
        int x=10;
        System.out.println("x调用方法前："+x);
        getX(x);
        System.out.println("x调用方法后："+x);
        int []y={10};
        System.out.println("y调用方法前："+y[0]);
        getY(y);
        System.out.println("y调用方法后："+y[0]);
    }
}
