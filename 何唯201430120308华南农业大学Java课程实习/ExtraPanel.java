package ����1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ExtraPanel extends JPanel {

	private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
			"*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=","sin","cos","tan","exp","abs" };
	private final String[] COMMAND = { "Backspace", "�������̰���", "C" };
	private JButton keys[] = new JButton[KEYS.length];/* �������ϵ����ּ���ť */
	private JButton commands[] = new JButton[COMMAND.length];/* �������ϵĹ��ܼ���ť */
	private JTextField resultText = new JTextField("0");/*����ı��� */
	private boolean firstDigit = true;/*�Ƿ����������ʽ�ĵ�һ������,�������������ĵ�һ������*/
	private double resultNum = 0.0;/*���ֵ*/
	private String operator = "=";/*��ǰ�����*/
	private boolean operateValidFlag = true;/* �����Ƿ�Ϸ�*/
	
    public ExtraPanel(){
    	resultText.setHorizontalAlignment(JTextField.RIGHT);//�Ҷ���
			resultText.setEditable(false);	// �������޸Ľ���ı���
			resultText.setBackground(Color.WHITE);
		
		JPanel calckeysPanel = new JPanel();// �����ּ��Լ����������һ�����calckeysPanel��
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

		
		JPanel commandsPanel = new JPanel();// �����ܼ�����һ�����commandsPanel��
		commandsPanel.setLayout(new GridLayout(1, 3, 3, 3));
		for (int i = 0; i < COMMAND.length; i++) {
			commands[i] = new JButton(COMMAND[i]);
			commandsPanel.add(commands[i]);
			commands[i].setForeground(Color.red);
		}

			// ������м����������岼�֣���calckeys��command������ڼ��������в���
			// ���ı�����ڱ�������calms������ڼ�������������

			// �½�һ����Ļ��壬�����潨����command��calckeys������ڸû�����
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout(3, 3));
		panel1.add("North", commandsPanel);
		panel1.add("Center", calckeysPanel);
			// ����һ�������ı���
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout(3, 3));
		top.add("Center", resultText);

			// ���岼��
		setLayout(new BorderLayout(10, 10));
		add("North", top);
		add("Center", panel1);
		add("South",new musicPanel());
			// Ϊ����ť����¼�������
		for (int i = 0; i < KEYS.length; i++) {
			keys[i].addActionListener(new ButtonListener());
		}
		for (int i = 0; i < COMMAND.length; i++) {
			commands[i].addActionListener(new ButtonListener());
		}
		
		addKeyListener(new CalculatorListener());//���밴��������
		//��������ǶԽ�����Ľ�� ʹ�����������κ����ʵ��
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
		String label = e.getActionCommand();		// ��ȡ�¼�Դ�ı�ǩ (getSource() ���صĵ�ǰ������ָ��Ķ��󣬰��������������Ϣ)
		if (label.equals(COMMAND[0])) {
			// �û�����"Backspace"��
			handleBackspace();
		} else if (label.equals(COMMAND[1])) {
			// �û�����"�������̰���"��
			;
		} else if (label.equals(COMMAND[2])) {
			// �û�����"C"��
			handleC();
		} else if ("0123456789.".indexOf(label) >= 0) {
			// �û��������ּ�����С�����
			handleNumber(label);
		} else {
			// �û������������
			handleOperator(label);
		}
		requestFocus();//�ѽ��㶨�ڴ����
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
    	/*����Backspace�����µ��¼�*/
    public void handleBackspace() {
		String text = resultText.getText();
		int i = text.length();
		if (i > 0) {
			// �˸񣬽��ı����һ���ַ�ȥ��
			text = text.substring(0, i - 1);
			if (text.length() == 0) {
				// ����ı�û�������ݣ����ʼ���������ĸ���ֵ
				resultText.setText("0");
				firstDigit = true;
				operator = "=";
			} else {
				// ��ʾ�µ��ı�
				resultText.setText(text);
			}
		}
	}
			/*�������ּ������µ��¼�*/
	public void handleNumber(String key) {
		if (firstDigit) {
			// ����ĵ�һ������
			resultText.setText(key);
		} else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
			// �������С���㣬����֮ǰû��С���㣬��С���㸽�ڽ���ı���ĺ���
			resultText.setText(resultText.getText() + ".");
		} else if (!key.equals(".")) {
			// �������Ĳ���С���㣬�����ָ��ڽ���ı���ĺ���
			resultText.setText(resultText.getText() + key);
		}
		// �Ժ�����Ͳ��ǵ�һ������
		firstDigit = false;
	}

			/*����C�������µ��¼�*/
	public void handleC() {
		// ��ʼ���������ĸ���ֵ
		resultText.setText("0");
		firstDigit = true;
		operator = "=";
	}

			/* ����������������µ��¼�*/
	public void handleOperator(String key) {
		if (operator.equals("/")) {
			// ��������
			// �����ǰ����ı����е�ֵ����0
			if (getNumberFromText() == 0.0) {
				// �������Ϸ�
				operateValidFlag = false;
				resultText.setText("��������Ϊ��");
			} else {
				resultNum /= getNumberFromText();
			}
		} else if (operator.equals("1/x")) {
			// ��������
			if (resultNum == 0.0) {
				// �������Ϸ�
				operateValidFlag = false;
				resultText.setText("�㵹��Ϊ����");
			} else {
				resultNum = 1 / resultNum;
			}
		} else if (operator.equals("+")) {
			// �ӷ�����
			resultNum += getNumberFromText();
		} else if (operator.equals("-")) {
			// ��������
			resultNum -= getNumberFromText();
		} else if (operator.equals("*")) {
			// �˷�����
			resultNum *= getNumberFromText();
		} else if (operator.equals("sqrt")) {
			// ƽ��������
			resultNum = Math.sqrt(resultNum);
		} else if (operator.equals("%")) {
			// �ٷֺ����㣬����100
			resultNum = resultNum / 100;
		} else if (operator.equals("+/-")) {
			// ������������
			resultNum = resultNum * (-1);
		} else if (operator.equals("=")) {
			// ��ֵ����
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
				// ˫���ȸ�����������
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
			// ����������û����İ�ť
		operator = key;
		firstDigit = true;
		operateValidFlag = true;
	}
		/* �ӽ���ı����л�ȡ����*/
	public double getNumberFromText() {
		double result = 0;
		try {
			result = Double.valueOf(resultText.getText()).doubleValue();
		} catch (NumberFormatException e) {
		}
		return result;
	}
    
}