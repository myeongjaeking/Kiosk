package source;


import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;



public class ChooseCardNumber extends Kiosk{
   	private JPanel view;
	private JPanel buttonPanel;
    private JTextField textField;
	private JLabel label;
	private String[] buttonArr={"1","2","3","4","5","6","7","8","9","<-","0","clear","","-","결제완료"};
	private JButton[] buttons;
    public static int orderNumber=0;
    public ChooseCardNumber()
    {
		System.out.println(1111);
		view=new JPanel(new BorderLayout());
		view.setSize(600,300);
    	label=new JLabel("                 카드 번호를 입력해주세요");
		label.setFont(new Font("고딕체",5,30));
		view.add(label,BorderLayout.NORTH);
		

        this.textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setPreferredSize(new Dimension(0, 60));//텍스트필드 설정
		textField.setFont(new Font("고딕체",5,30));
		//view.setBackground(Color.LIGHT_GRAY);
		view.add(textField,BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,3,4,4));
		buttons=new JButton[buttonArr.length];

        for (int i = 0; i <buttonArr.length; i++) {
            buttons[i]= new JButton(buttonArr[i]);
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setFont(new Font("고딕체", 1, 16));
			try{
			if(buttonArr[i].equals("<-"))buttons[i].addActionListener(new BackspaceButton()); //\
			else if(buttonArr[i].equals("-"))buttons[i].addActionListener(new Hyphen()); 
			else if(buttonArr[i].equals("결제완료")){buttons[i].addActionListener(new FinishButton()); buttons[i].setBackground(Color.cyan);} //다음 화면으로
			else if(buttonArr[i].equals("clear"))buttons[i].addActionListener(new Clear()); //전부다 클리어
			else buttons[i].addActionListener(new NumberButton());
			}catch(NullPointerException e){
				System.out.println("예외메세지>>"+e.getMessage());
				e.printStackTrace();
			}
            buttonPanel.add(buttons[i]);
        }

       
		this.setLayout(new BorderLayout());
		this.add(view,BorderLayout.NORTH);
  		this.add(buttonPanel);

    	this.setTitle("결제창");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(600, 600);
		this.setVisible(true);
		
      
    }
	private class NumberButton implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
	        String buttonText = ((JButton) e.getSource()).getText();
	        textField.setText(textField.getText() + buttonText);
	    }
	}
		private class Clear implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
	        textField.setText("");
	    }
	}
	
	private class BackspaceButton implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
	        String currentText = textField.getText();
	        if (!currentText.isEmpty()) {
	            textField.setText(currentText.substring(0, currentText.length() - 1));
	        }
	    }
	}
	private class Hyphen implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
	        String buttonText = ((JButton) e.getSource()).getText();
	        textField.setText(textField.getText() + buttonText);
	    }
	}
	
	
	private class FinishButton implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
	    	dispose();
	        String paymentText = textField.getText(); 
	        String[] paymentValues = paymentText.split("-"); // public String[] split(String regex) 인자 regex는 정규표현식(regex)으로 문자열 패턴을 받고, 그 패턴과 일치하는 문자열을 기준으로 잘라줍니다.
					 // 공백을 기준으로 잘랐어용
	        if (paymentValues.length == 3) {
	            int numCard = Integer.parseInt(paymentValues[0]);
	            int dateYYExpired = Integer.parseInt(paymentValues[1]);
	            int dateMMExpired = Integer.parseInt(paymentValues[2]);
				Kiosk.onOff=true;
				Kiosk.k.setnumCard(numCard);
				Kiosk.k.setdateYYExpired(dateYYExpired);
				Kiosk.k.setdateMMExpired(dateMMExpired);
				Kiosk.k.Excution();
	        }
			else{
				new ChooseCardNumber();
			}
	    }
	}
}
