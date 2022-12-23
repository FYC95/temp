public class people500 {
    public static void main(String args[]) {
        // 用布尔值来标识每个人是否出队 出队为false，未出队为true 并将每个人的初始值都赋为true
        boolean a[] = new boolean[500];
        for (int i = 0; i < a.length; i++) {
            a[i] = true;
        }
    /*leftNum:未出队的人数 countNum:取值为1、2、3， 每次从1开始数，数到3的人出队，下一个人接着从1开始数
    index：数数的人的编号，取值范围0~500
    */
        int leftNum = a.length;
        int countNum = 0;
        int index = 0;
        // 循环数数，直到只剩下一个人，即leftNum的值为1
        while (leftNum > 1) {
            if (a[index] == true) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    a[index] = false;
                    leftNum--;
                }
            }
            index++;
            // 如果数到第500个人，index回0，又从第1个人开始数
            if (index == a.length) {
                index = 0;
            }
        }
        //循环遍历每个数数的人，找到值为true的并输出
        for (int i = 0; i < a.length; i++) {
            if (a[i] == true)
                System.out.println("最后剩下的人是第" + (i + 1) + "的人");
        }
    }
}
