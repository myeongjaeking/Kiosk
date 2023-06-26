package source;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;
public class SeletePay extends Menu{
   private JPanel menuPanel;
    private JButton btnPre;
    private JButton btnPayCard;
    private JButton btnClear;
    private JLabel labelTotalPrice;
    private JLabel labelChoice=new JLabel("결제 방식을 선택해주세요!");
    private JLabel labelWon=new JLabel("￦");
    private String totalPrice;
    private JTextField textPrice;
    public SeletePay(String[] menuName,String seleted_groupName,String[] imgRoot){
            this.setLayout(null);
            
            menuPanel= new JPanel();
            menuPanel.setLayout(null);
            menuPanel.setBounds(0,0,600,600);
            menuPanel.setBackground(Color.WHITE);
            this.add(menuPanel);

            btnPayCard= new JButton("카드결제");
            btnPayCard.setBounds(30,100,200,150);
            btnPayCard.setBackground(Color.LIGHT_GRAY);
            btnPayCard.setFont(new Font("맑은 고딕", 1, 23));
            menuPanel.add(btnPayCard);

            labelChoice.setBounds(40, 30, 500,60);
            labelChoice.setFont(new Font("맑은 고딕", 1, 23));
            menuPanel.add(labelChoice);
  
        
            btnClear= new JButton("전체 취소");
            btnClear.setBounds(30, 700, 120, 100);
            btnClear.setBackground(Color.WHITE);
            btnClear.setFont(new Font("고딕체",1, 15));
            this.add(btnClear);

            btnPre=new JButton("이전");
            btnPre.setBounds(170, 700, 160, 100);
            btnPre.setBackground(Color.WHITE);
            this.add(btnPre);

            this.textPrice=new JTextField();  // 총 가격   
            this.totalPrice=Integer.toString(Menu.menuSum);
    
            labelTotalPrice = new JLabel("결제 금액");
            labelTotalPrice.setBounds(30, 648, 150, 30);
            labelTotalPrice.setFont(new Font("고딕체",1, 25));
            this.add(labelTotalPrice);

            textPrice=new JTextField(totalPrice);
            textPrice.setBounds(400, 640, 120, 50);
            textPrice.setFont(new Font("고딕체",1, 23));
            textPrice.setHorizontalAlignment(JTextField.RIGHT); //오른쪽으로
            this.add(textPrice);

            labelWon.setBounds(370, 640, 50, 50);
            labelWon.setFont(new Font("고딕체",1, 23));
            this.add(labelWon);

            btnClear.addActionListener(new ActionListener() { // 전체취소
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new Clear(seleted_groupName);
            }
        });
         btnPre.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuCheck(menuName,seleted_groupName,imgRoot);  ///그룹 라벨 그룹 이름 그룹 이미지 경로
            }
        });
         btnPayCard.addActionListener(new ActionListener() {  //카드 번호 입력받는 패널로 이동
             @Override
             public void actionPerformed(ActionEvent e) {
                 dispose();
                 new ChooseCardNumber();
             }
         });
            this.setSize(600,900);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
    }