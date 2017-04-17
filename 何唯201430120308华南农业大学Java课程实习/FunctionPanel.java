package ����1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;

public class FunctionPanel extends JPanel
{			//7��������
   private JSlider aSlider;
   private JSlider bSlider;
   private JSlider cSlider;
   private JSlider dSlider;
   private JSlider eSlider;
   private JSlider fSlider;
   private JSlider gSlider;
   		//7���������ı�ǩ
   private JLabel aLabel;
   private JLabel bLabel;
   private JLabel cLabel;
   private JLabel dLabel;
   private JLabel eLabel;
   private JLabel fLabel;
   private JLabel gLabel;
   		//����������ɫѡ�񴰿ڵİ�ť��һ�������ť
   private JButton c,colorButton1,colorButton2;
   private FunctionViewportPanel display;//ͼ�����
   private JLabel functionLabel;//�������ʽ
   private JPanel SliderPanel;//���������
   
   private final String STR = "���� y = ";
			//���û�������С����ʼֵ������϶���С�϶���
   private final int MIN = -10;
   private final int MAX = 10;
   private final int ORI = 0;
   private final int MAJOR = 5;
   private final int MINOR = 1;
   
   public FunctionPanel()
   {
      setLayout(new BorderLayout());
      
      SliderPanel=getSliderPanel();
      add(SliderPanel, BorderLayout.WEST);//SliderPanel:������������ϵ��������ʾ����ʼ������clear

      display = new FunctionViewportPanel();
      add(display, BorderLayout.CENTER);//���ƺ���ͼ�����
      add(new ExtraPanel(),BorderLayout.EAST);//�������Լ����ֲ��������
      
      functionLabel = new JLabel(STR + 0+"��ͼ��");
      functionLabel.setHorizontalAlignment(SwingConstants.CENTER);
      functionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
      functionLabel.setBorder(BorderFactory.createEtchedBorder());
      
      colorButton1=new JButton("������������ɫ");
      colorButton1.addActionListener(new ColorListener1());
      colorButton2=new JButton("���ĺ���ͼ����ɫ");
      colorButton2.addActionListener(new ColorListener2());
      JPanel colorPanel=new JPanel();
      colorPanel.add(colorButton1);
      colorPanel.add(colorButton2);
      
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      topPanel.add(colorPanel,BorderLayout.WEST);
      topPanel.add(functionLabel,BorderLayout.CENTER);
      add(topPanel, BorderLayout.NORTH);//topPanel:�������ʽ����ɫѡ�񴰿�
      
      
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
      
      aLabel=new JLabel("ϵ�� a ��ֵ:"+ORI);
      bLabel=new JLabel("ϵ�� b ��ֵ:"+ORI);
      cLabel=new JLabel("ϵ�� c ��ֵ:"+ORI);
      dLabel=new JLabel("ϵ�� d ��ֵ:"+ORI);
      eLabel=new JLabel("ϵ�� e ��ֵ:"+ORI);
      fLabel=new JLabel("ϵ�� f ��ֵ:"+ORI);
      gLabel=new JLabel("ϵ�� g ��ֵ:"+ORI);

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
      c.addMouseListener(new ButtonListener());//������
      buttonPanel.add(c);
      
      JPanel titlePanel=new JPanel();
      JLabel title = new JLabel("����ax^6+bx^5+cx^4+dx^3+ex^2+fx+gϵ������:");
      title.setFont(new Font("Dialog", Font.BOLD, 20));
      titlePanel.add(title);
      
      JPanel titlePanel2=new JPanel();
      JLabel title2 = new JLabel("�����л���������ϵ��:");
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
     
      return sliderPanel;//���ػ��������
   }

 
   private void updateFunctionLabel (Function function)
   {
	   functionLabel.setText (STR + function.toString());
   }

  			//��clear�����ʼ��
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
   		//��ȡ��������ֵ��ʵ������������
   private class SliderMouseListener extends MouseAdapter
   {
      public void mouseReleased(MouseEvent event)
      {
    	  Function function = new Function(aSlider.getValue(), bSlider.getValue(), cSlider.getValue(),dSlider.getValue(), eSlider.getValue(), fSlider.getValue(),gSlider.getValue());
         display.setFunction(function);
         updateFunctionLabel(function);
         aLabel.setText("ϵ�� a ��ֵ:"+aSlider.getValue());
         bLabel.setText("ϵ�� b ��ֵ:"+bSlider.getValue());
         cLabel.setText("ϵ�� c ��ֵ:"+cSlider.getValue());
         dLabel.setText("ϵ�� d ��ֵ:"+dSlider.getValue());
         eLabel.setText("ϵ�� e ��ֵ:"+eSlider.getValue());
         fLabel.setText("ϵ�� f ��ֵ:"+fSlider.getValue());
         gLabel.setText("ϵ�� g ��ֵ:"+gSlider.getValue());
         
         repaint();
      }
   }
   		//����ͼ����ɫѡ��
   private class ColorListener2 implements ActionListener
   {
	   public void actionPerformed(ActionEvent event)
	   { 
		
	   Color shade2 = Color.black;
	      int again;
			/*��ɫѡ��Ի���*/
	      do 
	      {
	         shade2 = JColorChooser.showDialog (colorButton2,"Pick a Color!", shade2);/*���b��ť������ɫѡ��Ի���*/

	         display.setFunctionColor(shade2);//������������ɫ

	         again = JOptionPane.showConfirmDialog (null,"��Ҫ����ѡ����?");
	         display.repaint();
	      }
	      while (again == JOptionPane.YES_OPTION);
		   
	   }
	
   }
   		//��������ɫѡ��
   private class ColorListener1 implements ActionListener
   {
	   public void actionPerformed(ActionEvent event)
	   { 
		
	   Color shade1 = Color.black;
	      int again;
			/*��ɫѡ��Ի���*/
	      do 
	      {
	         shade1 = JColorChooser.showDialog (colorButton1,"Pick a Color!", shade1);/*���b��ť������ɫѡ��Ի���*/

	         display.setAxisColor(shade1);//���ú���ͼ����ɫ

	         again = JOptionPane.showConfirmDialog (null,"��Ҫ����ѡ����?");
	         display.repaint();
	      }
	      while (again == JOptionPane.YES_OPTION);
		   
	   }
	
   }
}


