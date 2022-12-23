package Study;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.webp");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.webp");
    //绘制窗口
    public void paint(Graphics g){
        System.out.println("窗口被画了一次");
        g.drawImage(desk,20,20,null);
        g.drawImage(ball,20,20,null);
    }
    //创建窗口
    void launchFrame(){
        setSize(860,501);
        setLocation(100,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        System.out.println("我的小游戏开始了！");

        BallGame game=new BallGame();
        game.launchFrame();
    }
}
