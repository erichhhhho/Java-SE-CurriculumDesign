package ����1;
import javax.swing.*;

public class DrawFunction
{
   
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("�����������һԪ����ʽ����ͼ��");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (new FunctionPanel()); 
      frame.setVisible(true);
      frame.pack();
   }
}
