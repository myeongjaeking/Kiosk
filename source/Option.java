package source;

import javax.swing.*;

import src.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Option extends Menu implements Initinterface{
    private JPanel imgPanel;
    private JButton backBtn;
    private String options[]={"수량","-샷추가","-바닐라시럽추가","-헤이즐넛시럽추가","-휘핑추가"};
    private JLabel optionPrice[]=new JLabel[options.length-1]; //수량에는 500원이 필요없기때문에 -1
    private JLabel optionNames[]=new JLabel[options.length];
    private JButton plusBtn[]=new JButton[options.length];   //+
    private JButton minusBtn[]=new JButton[options.length];  //-
    private JLabel count[]=new JLabel[options.length];  // 숫자들
    private int itemCount = 1; // 선택한 메뉴의 개수
    private int addShotCount = 0; // 샷 추가 개수
    private int vCount = 0; // 바닐라 시럽 개수
    private int hCount = 0; // 헤이즐넛 시럽 개수
    private int wCount = 0; // 휘핑 추가 개수
    private JLabel menuName;
    private JLabel menuPriceLabel;
    private JButton cancel;
    private JButton selected;
    private String seleted_menuName;
    private int menuPrice;
    private int x,y;
    public Option(String seleted_menuName,String seleted_groupName,String imgRoot,JLabel menuImg,int menuPrice){
        this.menuPrice=menuPrice;
        this.seleted_menuName=seleted_menuName;
        this.setLayout(null);   //절대 배치자
        imgPanel = new JPanel();
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setLayout(null);
        imgPanel.setBounds(0,0,600, 400);  //panel 나눔 
        this.add(imgPanel);
       
        menuImg.setBounds(20, 90, 200, 200);  //이미지 위치
        imgPanel.add(menuImg);
        
        menuName=new JLabel(seleted_menuName); //이름 출력
        menuName.setBounds(250, 130, 200,30);
        menuName.setFont(new Font("맑은 고딕",1, 25));
        imgPanel.add(menuName);

        this.menuPriceLabel=new JLabel(Integer.toString(menuPrice));  //메뉴가격
        this.menuPriceLabel.setBounds(250, 180, 200,30);
        this.menuPriceLabel.setFont(new Font("맑은 고딕",1, 25));
        imgPanel.add(this.menuPriceLabel);
/////////////////////////
        backBtn=new JButton("<--");  //뒤로가기
        backBtn.setBounds(1,5, 80, 30);
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.setBorderPainted(false);
        imgPanel.add(backBtn);

        y=495;
        for(int i=0;i<optionPrice.length;i++){  //500원 라벨 생성
            optionPrice[i]=new JLabel("500원");
            optionPrice[i].setFont(new Font("맑은 고딕",1,13 ));
            optionPrice[i].setBounds(290,y, 50, 30);
            this.add(optionPrice[i]);
            y+=45;
        }
        x=100;y=450;
        for(int i=0;i<optionNames.length;i++){ //옵션 코드 500원떄무에 -1
           optionNames[i]=new JLabel(options[i]);
           
           optionNames[i].setFont(new Font("맑은 고딕",1,15 ));
           optionNames[i].setBounds(x,y, 150, 30);
         
           this.add(optionNames[i]);
           y+=45;
        }
      
        /////////수량 버튼//////////////
        x=350;y=450;
        for(int i=0;i<options.length;i++){ 
            minusBtn[i]= new JButton("-");
            plusBtn[i]= new JButton("+");
            minusBtn[i].setBounds(x, y, 45, 30);
            plusBtn[i].setBounds(x+90, y, 45, 30);
            minusBtn[i].setBackground(Color.WHITE);
            plusBtn[i].setBackground(Color.WHITE);
            y+=45;
            this.add(minusBtn[i]);
            this.add(plusBtn[i]);
        } 
        //카운트
        y=460;
       for(int j=0;j<count.length;j++){
            if(j==0)count[j]= new JLabel("1"); //수량 1으로
            else count[j]= new JLabel("0");
            count[j].setFont(new Font("궁서",1, 12));
            count[j].setBounds(412, y, 10, 10);
            this.add(count[j]);
            y+=45;
       }

        cancel= new JButton("취소");
        cancel.setBounds(40,800, 220, 130);
        cancel.setBackground(Color.WHITE);
        cancel.setFont(new Font("궁서 보통",1,35));
        cancel.setForeground(Color.cyan);
       this.add(cancel);

        selected=new JButton("선택완료");
        selected.setBounds(310,800, 220, 130);
        selected.setBackground(Color.cyan);
        selected.setFont(new Font("궁서 보통",1,35));
        selected.setForeground(Color.WHITE);
        this.add(selected);

         for (int i = 0; i < options.length; i++) {  
            int index = i;  //이유?
            minusBtn[i].addActionListener(new ActionListener() { //-
                @Override
                public void actionPerformed(ActionEvent e) {
                     int num=Integer.valueOf(count[index].getText()); //해당 위치에 맞는 옵션 수량
                    if (num> 0) {  
                       if(index==0 &&num==1) { ///수량 개수 1일경우 그만 최소 1이여야댐
                          return;}
                       else {
                            count[index].setText(Integer.toString(--num));
                       }
                    }
                    return;
                }
            });

            plusBtn[i].addActionListener(new ActionListener() {  //+
                @Override
                public void actionPerformed(ActionEvent e) {
                    int num=Integer.valueOf(count[index].getText()); //해당 위치에 맞는 옵션 수량
                   count[index].setText(Integer.toString(++num));
                }
               
            });
                    }

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               
                Init(seleted_groupName,false);  //각각 다른 생성자
            }
        });
        cancel.addActionListener(new ActionListener() {  //일단 돌아가게는 함
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Init(seleted_groupName,false);  //각각 다른 생성자
            }
        });
        selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               
                     itemCount = Integer.valueOf(count[0].getText()); // 선택한 메뉴의 개수
                     addShotCount = Integer.valueOf(count[1].getText()); // 샷 추가 개수
                     vCount = Integer.valueOf(count[2].getText()); // 바닐라 시럽 개수
                     hCount = Integer.valueOf(count[3].getText()); // 헤이즐넛 시럽 개수
                     wCount = Integer.valueOf(count[4].getText()); // 휘핑 추가 개수
            
                Init(seleted_groupName,true);  //
            }
        });

        this.setSize(600, 1030);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
     public void Init(String seletedGroup,boolean flag){
        Button btnObj=new Button();
        Drink item;
        if(!flag)item=null;
        else item=new Drink(seleted_menuName,itemCount,addShotCount,vCount,hCount,wCount,this.menuPrice);
        switch(seletedGroup){
            case"Coffee":{new Menu(btnObj.getCoffeeNames(),seletedGroup,btnObj.getCoffeeImgs(),item);return;}
            case"Smoothie":{new Menu(btnObj.getSmoothieNames(),seletedGroup, btnObj.getSmoothieImgs(),item); return;}
            case"Ade": {new Menu(btnObj.getAdeNames(),seletedGroup,btnObj.getAdeImgs(),item); return;}
            case"Juice": {new Menu(btnObj.getJuiceNames(),seletedGroup,btnObj.getJuiceImgs(),item);return;}
            case"Tea":{new Menu(btnObj.getTeaNames(),seletedGroup,btnObj.getTeaImgs(),item);return;}
            default:return;
        }
    }
}