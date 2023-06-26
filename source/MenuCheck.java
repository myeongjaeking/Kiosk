package source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuCheck extends Menu{
    private JTextField textPrice;
    private JPanel menuPanel;
    private JButton[] edit_btn;
    private JButton pre;
    private JButton allClear;
    private JButton next;
    private int menuSum;
    private JScrollPane scroll;
    private JLabel payPrice;
    private JLabel seletedMenu[];  //선택된 메뉴 이름
    private JLabel seletedMenuCount[];  //선택된 메뉴 수량
    private JLabel seletedMenuPrice[];  //선택된 메뉴 이름
    private JLabel seletedMenuImg[]; //선택된 메뉴 이미지를 위ㅐㅎ
    private JLabel won=new JLabel("￦");
    public int Top=0; //이 클래스에서 사용
    public int y=70; //이미지 띄우기 위해서
    public int getMenuSum(){return this.menuSum;}    //접근자들은 결제 선택 클래스에서 쓰일 예정
    public void setMenuSum(int num){ this.menuSum=num;}    //접근자들은 결제 선택 클래스에서 쓰일 예정
    public MenuCheck(){}
    public MenuCheck(String[] menuName,String seleted_groupName,String[] imgRoot){
        this.setLayout(null);
        menuPanel= new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(0,0,600,600);
        menuPanel.setBackground(Color.WHITE);
        this.add(menuPanel);

        scroll = new JScrollPane(menuPanel); //스크롤반
        scroll.setBounds(0, 0, 580, 600);
        scroll.setFont(new Font("고딕체", 5, 20));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().setPreferredSize(menuPanel.getPreferredSize());
        this.add(scroll);
        
        this.seletedMenu=new JLabel[super.getSeletedTop()];    //선택된 개수에 맞게 생성
        this.seletedMenuCount=new JLabel[super.getSeletedTop()];
        this.seletedMenuPrice=new JLabel[super.getSeletedTop()];
        this.seletedMenuImg=new JLabel[super.getSeletedTop()];
        if(Menu.selectedTop!=0){
        for(int i=0;i<super.getSeletedTop();i++){
            imgs(super.getSeletedMenu()[i]); //이미지를 위해서 배열 자체를 전달
            this.seletedMenu[i]=new JLabel(super.getSeletedMenu()[i]);//이미지 옆에 메뉴 이름
            this.seletedMenu[i].setBounds(150,y-30,130,100);
            this.seletedMenu[i].setFont(new Font("맑은 고딕",1, 20));
            menuPanel.add(this.seletedMenu[i]);
            
            this.seletedMenuCount[i]=new JLabel(Integer.toString(super.getSeletedMenuCount()[i]));//이미지 옆에 메뉴 수량
            this.seletedMenuCount[i].setBounds(270,y-30,40,100);
            this.seletedMenuCount[i].setFont(new Font("맑은 고딕",1, 20));
            menuPanel.add(this.seletedMenuCount[i]);

            this.seletedMenuPrice[i]=new JLabel(Integer.toString(super.getSeletedMenuPrice()[i])+"원" );//이미지 옆에 메뉴 이름
            this.seletedMenuPrice[i].setBounds(380,y-30,90,100);
            this.seletedMenuPrice[i].setFont(new Font("맑은 고딕",1, 20));
            menuPanel.add(this.seletedMenuPrice[i]);
            y+=130; //y좌표
        }
    }
        allClear= new JButton("전체 취소");
        allClear.setBounds(30, 700, 120, 100);
        allClear.setBackground(Color.WHITE);
       // allClear.setFont(new Font("고딕체",1, 15));
        pre=new JButton("이전");
        next=new JButton("다음");

        pre.setBounds(170, 700, 160, 100);
        pre.setBackground(Color.WHITE);
        
        next.setBounds(360, 700, 160, 100);
        next.setBackground(Color.cyan);

        payPrice = new JLabel("결제 금액");
        payPrice.setBounds(30, 648, 150, 30);
        payPrice.setFont(new Font("고딕체",1, 25));
        this.add(payPrice);

        this.setMenuSum(Menu.menuSum); //총액
        System.out.println("check>>"+this.menuSum);
        textPrice=new JTextField(Integer.toString(this.menuSum));
        textPrice.setBounds(400, 640, 120, 50);
        textPrice.setFont(new Font("고딕체",1, 23));
        textPrice.setHorizontalAlignment(JTextField.RIGHT); //오른쪽으로
        this.add(textPrice);

        won.setBounds(370, 640, 50, 50);
        won.setFont(new Font("고딕체",1, 23));
        this.add(won);

        edit_btn=new JButton[super.getSeletedTop()];

         y=110;
        for (int i = 0; i < super.getSeletedTop(); i++) {
           edit_btn[i] = new JButton("수정"); 
           edit_btn[i].setBounds(500,y-30,60,50); 
           edit_btn[i].setFont(new Font("맑은 고딕", 1, 12));
           edit_btn[i].setBackground(Color.WHITE);
           menuPanel.add(edit_btn[i]);
           
            y += 130;
            int index=i;
            edit_btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                     new Modify(index,menuName,seleted_groupName,imgRoot,seletedMenuImg[index]);
                    return;
                }
            });
           
        }

          allClear.addActionListener(new ActionListener() { // 전체취소
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new Clear(seleted_groupName);
        
            }
        });
         pre.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new Menu(menuName, seleted_groupName, imgRoot, null);
            }
        });
        next.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new SeletePay(menuName,seleted_groupName,imgRoot);
            }
        });
        this.add(pre);
        this.add(allClear);
        this.add(next);
        this.setSize(600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void setimgIc(String s){
    ImageIcon imgc=new ImageIcon(s);
    Image ig=imgc.getImage();
    try{
    this.seletedMenuImg[Top]=new JLabel(new ImageIcon(ig.getScaledInstance(100,100,Image.SCALE_SMOOTH)));
    this.seletedMenuImg[Top].setBounds(30,y,100,100);
    }catch(NullPointerException e){
        System.out.println("예외 메세지>>"+e.getMessage());
        e.printStackTrace();
    }
    menuPanel.add(seletedMenuImg[Top++]);
    
    }
    void imgs(String s){   //이미지 수정해야댐
        Button btn=new Button();
        switch(s){
            case "아메리카노":{setimgIc(btn.getCoffeeImgs()[0]); break;}
            case "바닐라라떼":{setimgIc(btn.getCoffeeImgs()[1]); break;}
            case "카푸치노":{setimgIc(btn.getCoffeeImgs()[2]); break;}
            case "헤이즐넛":{setimgIc(btn.getCoffeeImgs()[3]); break;}
            case "딸기스무디":{setimgIc(btn.getSmoothieImgs()[0]); break;}
            case "블루베리스무디":{setimgIc(btn.getSmoothieImgs()[1]); break;}
            case "망고스무디":{setimgIc(btn.getSmoothieImgs()[2]); break;}
            case "요거트스무디":{setimgIc(btn.getSmoothieImgs()[3]); break;}
            case "레몬에이드":{setimgIc(btn.getAdeImgs()[0]); break;}
            case "자몽에이드":{setimgIc(btn.getAdeImgs()[1]); break;}
            case "청포도에이드":{setimgIc(btn.getAdeImgs()[2]); break;}
            case "블루레몬에이드":{setimgIc(btn.getAdeImgs()[3]); break;}
            case "딸기주스":{setimgIc(btn.getJuiceImgs()[0]); break;}
            case "바나나주스":{setimgIc(btn.getJuiceImgs()[1]); break;}
            case "초코바나나":{setimgIc(btn.getJuiceImgs()[2]); break;}
            case "딸기바나나":{setimgIc(btn.getJuiceImgs()[3]); break;}
            case "아이스티":{setimgIc(btn.getTeaImgs()[0]); break;}
            case "얼그레이":{setimgIc(btn.getTeaImgs()[1]); break;}
            case "캐모마일":{setimgIc(btn.getTeaImgs()[2]); break;}
            case "자스민":{setimgIc(btn.getTeaImgs()[3]); break;}
            default: return;
        }
    }
}