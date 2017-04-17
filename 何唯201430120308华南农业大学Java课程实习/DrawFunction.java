package 课设1;
import javax.swing.*;

public class DrawFunction
{
   
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("绘制任意次数一元多项式函数图像");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (new FunctionPanel()); 
      frame.setVisible(true);
      frame.pack();
   }
}
