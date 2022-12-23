public class processControl {
    public static void main(String[] args) {
        float score = 55.5F;
        if (score <0 || score>100){
            System.out.println("成绩错误");
        } else if (score>=90) {
            System.out.println("优秀");
        } else if (score>=80) {
            System.out.println("良好");
        } else if (score>=60) {
            System.out.println("及格");
        }
        else {
            System.out.println("不及格");
        }
    }
}
