package 课设1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ExtraPanel extends JPanel {

	private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
			"*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=","sin","cos","tan","exp","abs" };
	private final String[] COMMAND = { "Backspace", "启动键盘按键", "C" };
	private JButton keys[] = new JButton[KEYS.length];/* 计算器上的数字键按钮 */
	private JButton commands[] = new JButton[COMMAND.length];/* 计算器上的功能键按钮 */
	private JTextField resultText = new JTextField("0");/*结果文本框 */
	private boolean firstDigit = true;/*是否是整个表达式的第一个数字,或者是运算符后的第一个数字*/
	private double resultNum = 0.0;/*结果值*/
	private String operator = "=";/*当前运算符*/
	private boolean operateValidFlag = true;/* 操作是否合法*/
	
    public ExtraPanel(){
    	resultText.setHorizontalAlignment(JTextField.RIGHT);//右对齐
			resultText.setEditable(false);	// 不允许修改结果文本框
			resultText.setBackground(Color.WHITE);
		
		JPanel calckeysPanel = new JPanel();// 将数字键以及运算键放在一个面板calckeysPanel内
		calckeysPanel.setLayout(new GridLayout(5, 5, 3, 3));
		for (int i = 0; i < KEYS.length; i++) {
			keys[i] = new JButton(KEYS[i]);
			calckeysPanel.add(keys[i]);
			keys[i].setForeground(Color.black);
		}
		
		keys[3].setForeground(Color.red);
		keys[8].setForeground(Color.red);
		keys[13].setForeground(Color.red);
		keys[18].setForeground(Color.red);
		keys[19].setForeground(Color.red);

		
		JPanel commandsPanel = new JPanel();// 将功能键放在一个面板commandsPanel内
		commandsPanel.setLayout(new GridLayout(1, 3, 3, 3));
		for (int i = 0; i < COMMAND.length; i++) {
			commands[i] = new JButton(COMMAND[i]);
			commandsPanel.add(commands[i]);
			commands[i].setForeground(Color.red);
		}

			// 下面进行计算器的整体布局，将calckeys和command画板放在计算器的中部，
			// 将文本框放在北部，将calms画板放在计算器的西部。

			// 新建一个大的画板，将上面建立的command和calckeys画板放在该画板内
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout(3, 3));
		panel1.add("North", commandsPanel);
		panel1.add("Center", calckeysPanel);
			// 建立一个面板放文本框
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout(3, 3));
		top.add("Center", resultText);

			// 整体布局
		setLayout(new BorderLayout(10, 10));
		add("North", top);
		add("Center", panel1);
		add("South",new musicPanel());
			// 为各按钮添加事件监听器
		for (int i = 0; i < KEYS.length; i++) {
			keys[i].addActionListener(new ButtonListener());
		}
		for (int i = 0; i < COMMAND.length; i++) {
			commands[i].addActionListener(new ButtonListener());
		}
		
		addKeyListener(new CalculatorListener());//加入按键监听器
		//以下语句是对焦点题的解决 使按键可以在任何情况实现
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {   
            public void eventDispatched(AWTEvent event) {  
                // TODO Auto-generated method stub  
                if(((KeyEvent)event).getID()==KeyEvent.KEY_PRESSED){  
                    switch (((KeyEvent)event).getKeyCode()) {  
                    case KeyEvent.VK_BACK_SPACE :
            			handleBackspace();
            			break;
            		case KeyEvent.VK_NUMPAD0:
            			handleNumber("0");
            			break;
            		case KeyEvent.VK_NUMPAD1:
            			handleNumber("1");
            			break;
            		case KeyEvent.VK_NUMPAD2:
            			handleNumber("2");
            			break;
            		case KeyEvent.VK_NUMPAD3:
            			handleNumber("3");
            			break;
            		case KeyEvent.VK_NUMPAD4:
            			handleNumber("4");
            			break;
            		case KeyEvent.VK_NUMPAD5:
            			handleNumber("5");
            			break;
            		case KeyEvent.VK_NUMPAD6:
            			handleNumber("6");
            			break;
            		case KeyEvent.VK_NUMPAD7:
            			handleNumber("7");
            			break;
            		case KeyEvent.VK_NUMPAD8:
            			handleNumber("8");
            			break;
            		case KeyEvent.VK_NUMPAD9:
            			handleNumber("9");
            			break;
            		case KeyEvent.VK_EQUALS:
            			handleOperator("=");
            			break;
            		case KeyEvent.VK_ENTER:
            			handleOperator("=");
            			break;
            		case KeyEvent.VK_ADD:
            			handleOperator("+");
            			break;
            		case KeyEvent.VK_MULTIPLY:
            			handleOperator("*");
            			break;
            		case KeyEvent.VK_SLASH:
            			handleOperator("/");
            			break;
            		case KeyEvent.VK_MINUS:
            			handleOperator("-");
            			break;
            		  
                    }  
                }  
            }  
        }, AWTEvent.KEY_EVENT_MASK);



		
		setFocusable(true);
    }

    private class ButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();		// 获取事件源的标签 (getSource() 返回的当前动作所指向的对象，包含对象的所有信息)
		if (label.equals(COMMAND[0])) {
			// 用户按了"Backspace"键
			handleBackspace();
		} else if (label.equals(COMMAND[1])) {
			// 用户按了"启动键盘按键"键
			;
		} else if (label.equals(COMMAND[2])) {
			// 用户按了"C"键
			handleC();
		} else if ("0123456789.".indexOf(label) >= 0) {
			// 用户按了数字键或者小数点键
			handleNumber(label);
		} else {
			// 用户按了运算符键
			handleOperator(label);
		}
		requestFocus();//把焦点定于此面板
	  }
    }
    
    
    private class CalculatorListener implements KeyListener
    {
    	public void keyPressed(KeyEvent event)
    	{
    		switch(event.getKeyCode())
    		{
    		case KeyEvent.VK_BACK_SPACE :
    			handleBackspace();
    			break;
    		case KeyEvent.VK_NUMPAD0:
    			handleNumber("0");
    			break;
    		case KeyEvent.VK_NUMPAD1:
    			handleNumber("1");
    			break;
    		case KeyEvent.VK_NUMPAD2:
    			handleNumber("2");
    			break;
    		case KeyEvent.VK_NUMPAD3:
    			handleNumber("3");
    			break;
    		case KeyEvent.VK_NUMPAD4:
    			handleNumber("4");
    			break;
    		case KeyEvent.VK_NUMPAD5:
    			handleNumber("5");
    			break;
    		case KeyEvent.VK_NUMPAD6:
    			handleNumber("6");
    			break;
    		case KeyEvent.VK_NUMPAD7:
    			handleNumber("7");
    			break;
    		case KeyEvent.VK_NUMPAD8:
    			handleNumber("8");
    			break;
    		case KeyEvent.VK_NUMPAD9:
    			handleNumber("9");
    			break;
    		case KeyEvent.VK_EQUALS:
    			handleOperator("=");
    			break;
    		case KeyEvent.VK_ENTER:
    			handleOperator("=");
    			break;
    		case KeyEvent.VK_ADD:
    			handleOperator("+");
    			break;
    		case KeyEvent.VK_MULTIPLY:
    			handleOperator("*");
    			break;
    		case KeyEvent.VK_SLASH:
    			handleOperator("/");
    			break;
    		case KeyEvent.VK_MINUS:
    			handleOperator("-");
    			break;
    		
    		}
    	}

		
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
    	
    }
    	/*处理Backspace被按下的事件*/
    public void handleBackspace() {
		String text = resultText.getText();
		int i = text.length();
		if (i > 0) {
			// 退格，将文本最后一个字符去掉
			text = text.substring(0, i - 1);
			if (text.length() == 0) {
				// 如果文本没有了内容，则初始化计算器的各种值
				resultText.setText("0");
				firstDigit = true;
				operator = "=";
			} else {
				// 显示新的文本
				resultText.setText(text);
			}
		}
	}
			/*处理数字键被按下的事件*/
	public void handleNumber(String key) {
		if (firstDigit) {
			// 输入的第一个数字
			resultText.setText(key);
		} else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
			// 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面
			resultText.setText(resultText.getText() + ".");
		} else if (!key.equals(".")) {
			// 如果输入的不是小数点，则将数字附在结果文本框的后面
			resultText.setText(resultText.getText() + key);
		}
		// 以后输入就不是第一个数字
		firstDigit = false;
	}

			/*处理C键被按下的事件*/
	public void handleC() {
		// 初始化计算器的各种值
		resultText.setText("0");
		firstDigit = true;
		operator = "=";
	}

			/* 处理运算符键被按下的事件*/
	public void handleOperator(String key) {
		if (operator.equals("/")) {
			// 除法运算
			// 如果当前结果文本框中的值等于0
			if (getNumberFromText() == 0.0) {
				// 操作不合法
				operateValidFlag = false;
				resultText.setText("除数不能为零");
			} else {
				resultNum /= getNumberFromText();
			}
		} else if (operator.equals("1/x")) {
			// 倒数运算
			if (resultNum == 0.0) {
				// 操作不合法
				operateValidFlag = false;
				resultText.setText("零倒数为无穷");
			} else {
				resultNum = 1 / resultNum;
			}
		} else if (operator.equals("+")) {
			// 加法运算
			resultNum += getNumberFromText();
		} else if (operator.equals("-")) {
			// 减法运算
			resultNum -= getNumberFromText();
		} else if (operator.equals("*")) {
			// 乘法运算
			resultNum *= getNumberFromText();
		} else if (operator.equals("sqrt")) {
			// 平方根运算
			resultNum = Math.sqrt(resultNum);
		} else if (operator.equals("%")) {
			// 百分号运算，除以100
			resultNum = resultNum / 100;
		} else if (operator.equals("+/-")) {
			// 正数负数运算
			resultNum = resultNum * (-1);
		} else if (operator.equals("=")) {
			// 赋值运算
			resultNum = getNumberFromText();
		}else if(operator.equals("sin")){
			//sin
			resultNum=(float) Math.sin(Math.toRadians(resultNum));
		}else if(operator.equals("cos")){
			//cos
			resultNum=(float)Math.cos(Math.toRadians(resultNum));
		}else if(operator.equals("tan")){
			//tan
			resultNum=(float)Math.tan(Math.toRadians(resultNum));
		}else if(operator.equals("exp")){
			//exp
			resultNum=Math.exp(resultNum);
		}else if(operator.equals("abs")){
			//abs
			if(resultNum<0)
				resultNum=-resultNum;
		}
		if (operateValidFlag) {
				// 双精度浮点数的运算
			long t1;
			double t2;
			t1 = (long) resultNum;
			t2 = resultNum - t1;
			if (t2 == 0) {
				resultText.setText(String.valueOf(t1));
			} else {
				resultText.setText(String.valueOf(resultNum));
			}
		}
			// 运算符等于用户按的按钮
		operator = key;
		firstDigit = true;
		operateValidFlag = true;
	}
		/* 从结果文本框中获取数字*/
	public double getNumberFromText() {
		double result = 0;
		try {
			result = Double.valueOf(resultText.getText()).doubleValue();
		} catch (NumberFormatException e) {
		}
		return result;
	}
    
}