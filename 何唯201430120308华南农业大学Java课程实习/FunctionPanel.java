package 课设1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;

public class FunctionPanel extends JPanel
{			//7个滑动条
   private JSlider aSlider;
   private JSlider bSlider;
   private JSlider cSlider;
   private JSlider dSlider;
   private JSlider eSlider;
   private JSlider fSlider;
   private JSlider gSlider;
   		//7个滑动条的标签
   private JLabel aLabel;
   private JLabel bLabel;
   private JLabel cLabel;
   private JLabel dLabel;
   private JLabel eLabel;
   private JLabel fLabel;
   private JLabel gLabel;
   		//两个启动颜色选择窗口的按钮和一个清除按钮
   private JButton c,colorButton1,colorButton2;
   private FunctionViewportPanel display;//图象面板
   private JLabel functionLabel;//函数表达式
   private JPanel SliderPanel;//滑动条面板
   
   private final String STR = "函数 y = ";
			//设置滑动条最小最大初始值，最大拖动最小拖动等
   private final int MIN = -10;
   private final int MAX = 10;
   private final int ORI = 0;
   private final int MAJOR = 5;
   private final int MINOR = 1;
   
   public FunctionPanel()
   {
      setLayout(new BorderLayout());
      
      SliderPanel=getSliderPanel();
      add(SliderPanel, BorderLayout.WEST);//SliderPanel:滑动条，函数系数设置提示，初始化按键clear

      display = new FunctionViewportPanel();
      add(display, BorderLayout.CENTER);//绘制函数图像面板
      add(new ExtraPanel(),BorderLayout.EAST);//计算器以及音乐播放器面板
      
      functionLabel = new JLabel(STR + 0+"的图像");
      functionLabel.setHorizontalAlignment(SwingConstants.CENTER);
      functionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
      functionLabel.setBorder(BorderFactory.createEtchedBorder());
      
      colorButton1=new JButton("更改坐标轴颜色");
      colorButton1.addActionListener(new ColorListener1());
      colorButton2=new JButton("更改函数图象颜色");
      colorButton2.addActionListener(new ColorListener2());
      JPanel colorPanel=new JPanel();
      colorPanel.add(colorButton1);
      colorPanel.add(colorButton2);
      
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      topPanel.add(colorPanel,BorderLayout.WEST);
      topPanel.add(functionLabel,BorderLayout.CENTER);
      add(topPanel, BorderLayout.NORTH);//topPanel:函数表达式和颜色选择窗口
      
      
   }

   private JPanel getSliderPanel()
   {
      SliderMouseListener changed = new SliderMouseListener();

      aSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      aSlider.setPaintTicks(true);
      aSlider.setPaintLabels(true);
      aSlider.setMajorTickSpacing(MAJOR);
      aSlider.setMinorTickSpacing(MINOR);
      aSlider.setSnapToTicks(true);
      aSlider.addMouseListener(changed);

      bSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      bSlider.setPaintTicks(true);
      bSlider.setPaintLabels(true);
      bSlider.setMajorTickSpacing(MAJOR);
      bSlider.setMinorTickSpacing(MINOR);
      bSlider.setSnapToTicks(true);
      bSlider.addMouseListener(changed);

      cSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      cSlider.setPaintTicks(true);
      cSlider.setPaintLabels(true);
      cSlider.setMajorTickSpacing(MAJOR);
      cSlider.setMinorTickSpacing(MINOR);
      cSlider.setSnapToTicks(true);
      cSlider.addMouseListener(changed);
      
      eSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      eSlider.setPaintTicks(true);
      eSlider.setPaintLabels(true);
      eSlider.setMajorTickSpacing(MAJOR);
      eSlider.setMinorTickSpacing(MINOR);
      eSlider.setSnapToTicks(true);
      eSlider.addMouseListener(changed);
      
      fSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      fSlider.setPaintTicks(true);
      fSlider.setPaintLabels(true);
      fSlider.setMajorTickSpacing(MAJOR);
      fSlider.setMinorTickSpacing(MINOR);
      fSlider.setSnapToTicks(true);
      fSlider.addMouseListener(changed);
      
      gSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      gSlider.setPaintTicks(true);
      gSlider.setPaintLabels(true);
      gSlider.setMajorTickSpacing(MAJOR);
      gSlider.setMinorTickSpacing(MINOR);
      gSlider.setSnapToTicks(true);
      gSlider.addMouseListener(changed);
      
      dSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, ORI);
      dSlider.setPaintTicks(true);
      dSlider.setPaintLabels(true);
      dSlider.setMajorTickSpacing(MAJOR);
      dSlider.setMinorTickSpacing(MINOR);
      dSlider.setSnapToTicks(true);
      dSlider.addMouseListener(changed);
      
      aLabel=new JLabel("系数 a 的值:"+ORI);
      bLabel=new JLabel("系数 b 的值:"+ORI);
      cLabel=new JLabel("系数 c 的值:"+ORI);
      dLabel=new JLabel("系数 d 的值:"+ORI);
      eLabel=new JLabel("系数 e 的值:"+ORI);
      fLabel=new JLabel("系数 f 的值:"+ORI);
      gLabel=new JLabel("系数 g 的值:"+ORI);

      JPanel aPanel = new JPanel();
      aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.Y_AXIS));
      aPanel.setBorder(BorderFactory.createEtchedBorder ());
      aPanel.add(aLabel);
      aPanel.add(aSlider);

      JPanel bPanel = new JPanel();
      bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
      bPanel.setBorder(BorderFactory.createEtchedBorder ());
      bPanel.add(bLabel);
      bPanel.add(bSlider);

      JPanel cPanel = new JPanel();
      cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
      cPanel.setBorder(BorderFactory.createEtchedBorder ());
      cPanel.add(cLabel);
      cPanel.add(cSlider);
      
      JPanel dPanel = new JPanel();
      dPanel.setLayout(new BoxLayout(dPanel, BoxLayout.Y_AXIS));
      dPanel.setBorder(BorderFactory.createEtchedBorder ());
      dPanel.add(dLabel);
      dPanel.add(dSlider);
      
      JPanel ePanel = new JPanel();
      ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.Y_AXIS));
      ePanel.setBorder(BorderFactory.createEtchedBorder ());
      ePanel.add(eLabel);
      ePanel.add(eSlider);
      
      JPanel fPanel = new JPanel();
      fPanel.setLayout(new BoxLayout(fPanel, BoxLayout.Y_AXIS));
      fPanel.setBorder(BorderFactory.createEtchedBorder ());
      fPanel.add(fLabel);
      fPanel.add(fSlider);
      
      JPanel gPanel = new JPanel();
      gPanel.setLayout(new BoxLayout(gPanel, BoxLayout.Y_AXIS));
      gPanel.setBorder(BorderFactory.createEtchedBorder ());
      gPanel.add(gLabel);
      gPanel.add(gSlider);
      
      JPanel buttonPanel=new JPanel();
      c=new JButton("Clear!");
      c.addMouseListener(new ButtonListener());//监听器
      buttonPanel.add(c);
      
      JPanel titlePanel=new JPanel();
      JLabel title = new JLabel("方程ax^6+bx^5+cx^4+dx^3+ex^2+fx+g系数设置:");
      title.setFont(new Font("Dialog", Font.BOLD, 20));
      titlePanel.add(title);
      
      JPanel titlePanel2=new JPanel();
      JLabel title2 = new JLabel("在下列滑动条设置系数:");
      titlePanel2.add(title2);
      
      JPanel sliderPanel = new JPanel();
      sliderPanel.setBorder(BorderFactory.createEtchedBorder ());
      sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));  
      
      
      sliderPanel.add(titlePanel);
      sliderPanel.add(titlePanel2);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(aPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(bPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(cPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(dPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(ePanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(fPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(gPanel);
      sliderPanel.add(buttonPanel);
     
      return sliderPanel;//返回滑动条面板
   }

 
   private void updateFunctionLabel (Function function)
   {
	   functionLabel.setText (STR + function.toString());
   }

  			//按clear！后初始化
   private class ButtonListener extends MouseAdapter
   {
     
      public void mousePressed (MouseEvent event)
      {
       aSlider.setValue(0);
       bSlider.setValue(0);
       cSlider.setValue(0);
       dSlider.setValue(0);
       eSlider.setValue(0);
       fSlider.setValue(0);
       gSlider.setValue(0);
       Function function = new Function();
       display.setFunction(function);
       updateFunctionLabel(function);
         repaint();
      }

   } 
   		//获取滑动条的值，实例化函数方程
   private class SliderMouseListener extends MouseAdapter
   {
      public void mouseReleased(MouseEvent event)
      {
    	  Function function = new Function(aSlider.getValue(), bSlider.getValue(), cSlider.getValue(),dSlider.getValue(), eSlider.getValue(), fSlider.getValue(),gSlider.getValue());
         display.setFunction(function);
         updateFunctionLabel(function);
         aLabel.setText("系数 a 的值:"+aSlider.getValue());
         bLabel.setText("系数 b 的值:"+bSlider.getValue());
         cLabel.setText("系数 c 的值:"+cSlider.getValue());
         dLabel.setText("系数 d 的值:"+dSlider.getValue());
         eLabel.setText("系数 e 的值:"+eSlider.getValue());
         fLabel.setText("系数 f 的值:"+fSlider.getValue());
         gLabel.setText("系数 g 的值:"+gSlider.getValue());
         
         repaint();
      }
   }
   		//函数图象颜色选择
   private class ColorListener2 implements ActionListener
   {
	   public void actionPerformed(ActionEvent event)
	   { 
		
	   Color shade2 = Color.black;
	      int again;
			/*颜色选择对话框*/
	      do 
	      {
	         shade2 = JColorChooser.showDialog (colorButton2,"Pick a Color!", shade2);/*点击b按钮弹出颜色选择对话框*/

	         display.setFunctionColor(shade2);//设置坐标轴颜色

	         again = JOptionPane.showConfirmDialog (null,"需要重新选择吗?");
	         display.repaint();
	      }
	      while (again == JOptionPane.YES_OPTION);
		   
	   }
	
   }
   		//坐标轴颜色选择
   private class ColorListener1 implements ActionListener
   {
	   public void actionPerformed(ActionEvent event)
	   { 
		
	   Color shade1 = Color.black;
	      int again;
			/*颜色选择对话框*/
	      do 
	      {
	         shade1 = JColorChooser.showDialog (colorButton1,"Pick a Color!", shade1);/*点击b按钮弹出颜色选择对话框*/

	         display.setAxisColor(shade1);//设置函数图象颜色

	         again = JOptionPane.showConfirmDialog (null,"需要重新选择吗?");
	         display.repaint();
	      }
	      while (again == JOptionPane.YES_OPTION);
		   
	   }
	
   }
}


