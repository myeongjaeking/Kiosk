package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Clear extends Menu implements Initinterface{
     private JLabel label;
    private JButton Yes;
    private JButton No;
    public int[] selectedMenuPrice;
    public int[] selectedMenuCount;
    public String[] selectedMenu;
    public Clear(String groupName){
    this.selectedMenu=super.getSeletedMenu();
    this.selectedMenuCount=super.getSeletedMenuCount();
    this.selectedMenuPrice=super.getSeletedMenuPrice();
    
    this.setLayout(null);
    label=new JLabel("선택한 메뉴를 모두 취소 하시겠습니까?");
    label.setBounds(70, 100,500, 30);
    label.setFont(new Font("고딕체", 1,25));
    this.add(label);
    Yes=new JButton("예");
    No=new JButton("아니오");
    Yes.setBounds(60, 400, 200, 100);
    Yes.setBackground(Color.white);
    
    No.setBounds(330, 400, 200, 100);
    No.setBackground(Color.white);

    this.add(Yes);
    this.add(No);
    Yes.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
               for(int i=0;i<Menu.selectedTop;i++){ //초기화
                     Menu.seletedMenu[i]="";
                    Menu.selectedMenuCount[i]=0;
                    Menu.selectedMenuPrice[i]=0;

                }

            dispose();
            Menu.selectedTop=0;
            Menu.menuArea.setText("");
            Menu.menuSum=0;
            Init(groupName,true);
        }
             
    });

        No.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                 Init(groupName,true);
        } 
        });
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }   @Override
        public void Init(String seletedGroup,boolean flag){
        Button btnObj=new Button();
        switch(seletedGroup){
            case"Coffee":{new Menu(btnObj.getCoffeeNames(),seletedGroup,btnObj.getCoffeeImgs(),null);return;}
            case"Smoothie":{new Menu(btnObj.getSmoothieNames(),seletedGroup, btnObj.getSmoothieImgs(),null); return;}
            case"Ade": {new Menu(btnObj.getAdeNames(),seletedGroup,btnObj.getAdeImgs(),null); return;}
            case"Juice": {new Menu(btnObj.getJuiceNames(),seletedGroup,btnObj.getJuiceImgs(),null);return;}
            case"Tea":{new Menu(btnObj.getTeaNames(),seletedGroup,btnObj.getTeaImgs(),null);return;}
            default:return;
        }
    }
    }
