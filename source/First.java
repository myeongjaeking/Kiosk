package source;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class First extends JFrame{
    private ImageIcon bg=new ImageIcon("../키오스크/img/로고확정.png");  
    private JLabel label;
    private JButton button;
    public First(){  
        Button btnObj=new Button();
        
        Image img= bg.getImage();
        label=new JLabel(new ImageIcon(img.getScaledInstance(600,1030,Image.SCALE_SMOOTH)));
        this.add(label);

        button=new JButton("주문하기");
        button.setBackground(Color.LIGHT_GRAY);
        button.setBounds(190,720 , 200, 90);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 15));  
        label.add(button);
        
        this.setTitle("카페");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,1030);  //1080은 짤려서 조금 수정했습니단
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              dispose();
             new Menu(btnObj.getCoffeeNames(),"Coffee",btnObj.getCoffeeImgs(),null);
              
          }
      });
     
    }
    public static void main(String[] args) {
        new First();
    }
}