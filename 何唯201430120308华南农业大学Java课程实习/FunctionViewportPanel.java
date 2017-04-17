package ����1;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FunctionViewportPanel extends JPanel
{
   private final int X_MIN = -10, Y_MIN = -10, X_MAX = 10, Y_MAX = 10;//��ʵ����ϵ�����Сֵ
   private final int REAL_WIDTH = X_MAX - X_MIN;//��ʵ�����
   private final int REAL_HEIGHT = Y_MAX - Y_MIN;
   private final double AXIS_MARK = 0.2;//�������ǳ���
   
   private Function function;
   private Color shade1=Color.black;//Ĭ����������ɫ
   private Color shade2=Color.black;//Ĭ�Ϻ���ͼ����ɫ
   
   public FunctionViewportPanel()
   {
	   function = new Function();//�������ʽ
      setBorder (new LineBorder(Color.lightGray, 4));
      setPreferredSize(new Dimension(500, 500));
   }

   void setFunction (Function newFunction)
   {
	   function = newFunction;
   }

		//����ʵ����ת��ΪJava����ϵ����
   private int convertX (double x)
   {
      double offset = x - X_MIN;
      double result = offset * getSize().width / REAL_WIDTH;
      return (int)Math.round(result);//��������
   }

   
   private int convertY (double y)
   {
      double offset = Y_MAX - y;
      double result = offset * getSize().height / REAL_HEIGHT;
      return (int)Math.round(result);
   }

		//����
   private void drawScreenLine(Graphics page, double xMin, double yMin,
      double xMax, double yMax)
   {
      page.drawLine(convertX(xMin), convertY(yMin), convertX(xMax), convertY(yMax));
   }

   private void drawScreenPoint(Graphics page, double x, double y)
   {
      page.drawLine(convertX(x), convertY(y), convertX(x), convertY(y));
   }

   public void setFunctionColor(Color color){
	   shade2 = color;
   }
   public void setAxisColor(Color color){
	   shade1 = color;
   }
   
   public void paintComponent(Graphics page)
   {
      page.setColor(Color.white);
      page.fillRect(0,0,getSize().width, getSize().height);

      // draw the x and y axis
      page.setColor(shade1);
      drawScreenLine(page, X_MIN, 0, X_MAX, 0);
      drawScreenLine(page, 0, Y_MIN, 0, Y_MAX);

      // draw tick marks
      for (int x=X_MIN; x<X_MAX; x++)
         drawScreenLine(page, x, -AXIS_MARK, x, AXIS_MARK);
      for (int y=Y_MIN; y<Y_MAX; y++)
         drawScreenLine(page, -AXIS_MARK, y, AXIS_MARK, y);

      // draw the graph of the equation
      page.setColor(shade2);
      double x = X_MIN;
      double y;
      double stepSize = (double)(X_MAX - X_MIN) / getSize().width;
      int screenX = getSize().width;
      for (int i = 0; i <= screenX; i++)
      {
    	  if(function.isZero())
    	     ;
    	  else
         {y = function.computeValue(x);
         drawScreenLine(page, x-stepSize,function.computeValue(x-stepSize),x,y);
         x += stepSize;}
      }
   }
   
   
}

