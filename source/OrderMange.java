package source;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class OrderMange extends Kiosk{
    private JButton[] buttons= new JButton[20];
    private JPanel panel;
    private JLabel label;
    private static String[] orderNum=new String[20];
    private static int index=0;
    public OrderMange(){
        label=new JLabel("                    주문번호");
        label.setFont(new Font("맑은 고딕", 5, 30));
        this.add(label,BorderLayout.NORTH);
        
        for(int i=index;i<20;i++){if(i==19)orderNum[i]="Home";else orderNum[i]="";}
        orderNum[index++]=Integer.toString(k.num);
        panel =new JPanel(new GridLayout(0,4,4,4));
        for(int i=0;i<20;i++){
            buttons[i]=new JButton(orderNum[i]);
            if(i==19)buttons[i].setBackground(Color.cyan);
            else buttons[i].setBackground(Color.WHITE);
            buttons[i].setFont(new Font("맑은 고딕", 5, 25));
            panel.add(buttons[i]);
        }
        buttons[19].addActionListener(new ActionListener() { //결제하기
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new First(); //그룹라벨 그룹이름 그룹이미지경로
            }
        });
        this.add(panel);
        this.setTitle("전광판");
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
       
    }
   
}
