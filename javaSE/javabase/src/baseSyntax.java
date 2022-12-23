import java.util.Scanner;
public class baseSyntax {

        public static void main(String[] args)
        {

            Scanner scan=new Scanner(System.in);
            System.out.println("请输入华氏温度：");
            double h=scan.nextDouble();
            double s=(h-32)/1.8;
            System.out.println("华氏温度："+h+"对应的摄氏温度："+s);//华氏温度：80.0对应的摄氏温度：26.666666666666664
            //使用Math.round()：四舍五入，转换为整型
		/*Math.round（变量名称）这种返回的其实是整数，也就是说对整数进行四舍五入。
         比如Math.round（4.256）最后的结果就是4。
		 */
            System.out.println("华氏温度："+h+"对应的摄氏温度："+Math.round(s));//华氏温度：80.0对应的摄氏温度：27

        }



}
