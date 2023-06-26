package source;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame{
    private JPanel mainPanel;
    private JButton[] groupBtn;
    private JTextField priceField;
    private String seleted_groupName;
    public static JTextArea menuArea=new JTextArea(10,20);
    public static int menuSum=0;
    private JLabel won=new JLabel("￦"); 
    private JLabel menuNames[];
    private JLabel menuPrice[];
    private JScrollPane scrollPane;
    private JButton option[]=new JButton[4];
    private JLabel menuImg[]=new JLabel[4]; // 패널에 넣을거
    private Image[] setImgArr;//이미지 설정을 위해
    private ImageIcon[] setImgIconArr; //이미지
    public static String[] seletedMenu=new String[20];
    public static int[] selectedMenuPrice= new int[20];
    public static int[] selectedMenuCount= new int[20];
    public static int selectedTop=0;// 선택된 메뉴 개수
    ArrayList<Drink> itemList= new ArrayList<>();
    public String[] getSeletedMenu(){return seletedMenu;}  //선택된 메뉴들
    public int[] getSeletedMenuPrice(){return selectedMenuPrice;} //선택된 메뉴들가격 
    public int[] getSeletedMenuCount(){return selectedMenuCount;} //선택된 메뉴들가격 
    public int getSeletedTop(){return selectedTop;}
    public String getGroupName(){return this.seleted_groupName;}
    public Menu(){}
    public Menu(String[] menuName,String seleted_groupName,String[] imgRoot,Drink item){
        itemList.add(item);
        this.seleted_groupName=seleted_groupName;
        Button btnObj=new Button(); //버튼 obj
        mainPanel=new JPanel();
        mainPanel.setLayout(null);
        if(item!=null){   //menuArea  //처음 시작일 떈 작동안함
            for(Drink it:itemList){
                selectedMenuPrice[selectedTop]=it.getTotalPrice();
                selectedMenuCount[selectedTop]=it.getItemCount();
                seletedMenu[selectedTop++]=it.getDrinkName();
                menuSum+=it.getTotalPrice();
                if(menuArea.getText().isEmpty()){ //첫 메뉴 선택 시
                    menuArea.setText(it.getDrinkName()+",수량:"+it.getItemCount());
                }
                else{
                    menuArea.setText(menuArea.getText()+it.getDrinkName()+" 수량:"+it.getItemCount());
                }
                if(it.getOptionIsEmpty()){menuArea.setText(menuArea.getText()+"옵션: x");}
                if(it.getShotCount()!=0){menuArea.setText(menuArea.getText()+"샷 추가: "+it.getShotCount());}
                if(it.getVCount()!=0){menuArea.setText(menuArea.getText()+"바닐라시럽 추가: "+it.getVCount());}
                if(it.getHCount()!=0){menuArea.setText(menuArea.getText()+"헤이즐넛시럽 추가: "+it.getHCount());}
                if(it.getWCount()!=0){menuArea.setText(menuArea.getText()+"휘핑 추가: "+it.getWCount());}
                menuArea.setText(menuArea.getText()+'\n');
            }
        }
        groupBtn=new JButton[btnObj.getbtnLenth()]; //그룹 개수만큼 할당 4개
        int x=30;
        for(int i=0;i<groupBtn.length;i++){ //그룹버튼들만 해야되서
            groupBtn[i]=new JButton((btnObj.getbtnArr())[i]); //생성
            if(i>4)continue; //메뉴 그룹 외에는 생성만
            groupBtn[i].setBounds(x,50, 90,30);
            groupBtn[i].setBackground(Color.LIGHT_GRAY);
            groupBtn[i].setBorderPainted(false);
            mainPanel.add(groupBtn[i]);
            x+=110;
        }

        groupBtn[5].setBounds(1,5, 80, 30); //뒤로가기
        groupBtn[5].setBackground(Color.LIGHT_GRAY);
        groupBtn[5].setBorderPainted(false);
        mainPanel.add(groupBtn[5]);

        groupBtn[6].setBounds(440,820, 100, 130);  //결제하기 버튼
        groupBtn[6].setFont(new Font("굴림체",1, 13));
        groupBtn[6].setBackground(Color.cyan);
        groupBtn[6].setForeground(Color.WHITE);
        mainPanel.add(groupBtn[6]);

        groupBtn[7].setBounds(299,869,141,80); //전체취소버튼
        groupBtn[7].setFont(new Font("굴림체",1, 13));
        groupBtn[7].setBackground(Color.LIGHT_GRAY);
        groupBtn[7].setForeground(Color.WHITE);
         mainPanel.add(groupBtn[7]);

        for(int i=0;i<4;i++){ //옵션 버튼
            option[i]=new JButton("옵션");
            option[i].setFont(new Font("고딕체",1, 13));
            option[i].setBackground(Color.WHITE);
        }
         option[0].setBounds(158, 360,70,30); 
         option[1].setBounds(428, 360,70,30);
         option[2].setBounds(158, 710,70,30);
         option[3].setBounds(428, 710,70,30);
        for(JButton btn:option){mainPanel.add(btn);} 
         
        won.setBounds(264,770,80,150);   //원화
        won.setFont(new Font("고딕체",1, 33));
        mainPanel.add(won);

        menuArea.setBounds(20,800,230,150); //선택한 메뉴들
        menuArea.setFont(new Font("고딕체",5,13));
        mainPanel.add(menuArea);

        scrollPane = new JScrollPane(menuArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //스크롤반
        scrollPane = new JScrollPane(menuArea);
        scrollPane.setBounds(20, 800, 230, 150);
        scrollPane.setFont(new Font("고딕체", 5, 20));
        mainPanel.add(scrollPane);

        priceField=new JTextField(); // 총 가격
        priceField.setBounds(299,820,142,50);
        priceField.setHorizontalAlignment(JTextField.RIGHT);
        priceField.setFont(new Font("고딕체",1,23));
        priceField.setText(Integer.toString(menuSum));
        mainPanel.add(priceField);

        setMenuImg(imgRoot); //이미지 만드는 함수 호출
        menuImg[0].setBounds(30, 150, 200, 200);  //이미지 위치
        menuImg[1].setBounds(300, 150, 200, 200);  //이미지 위치
        menuImg[2].setBounds(30, 500, 200, 200);  //이미지 위치
        menuImg[3].setBounds(300, 500, 200, 200);  //이미지 위치
        for(JLabel lb:menuImg)mainPanel.add(lb);

        this.menuNames=new JLabel[btnObj.getLabelLenth()];   //메뉴 이름들 
        for(int i=0;i<menuNames.length;i++){
            this.menuNames[i]=new JLabel(menuName[i]);
            this.menuNames[i].setFont(new Font("고딕체",1, 15));
        }
        menuNames[0].setBounds(88, 60,100,150);
        menuNames[1].setBounds(358, 60,120,150);
        menuNames[2].setBounds(88, 410,100,150);
        menuNames[3].setBounds(358, 410,110,150);
         for(JLabel lb:menuNames)mainPanel.add(lb);

         this.menuPrice=new JLabel[btnObj.getPriceArrLenth()]; //메뉴 가격들
          for(int i=0;i<menuPrice.length;i++){
            this.menuPrice[i]=new JLabel(  Integer.toString((btnObj.getPrice())[i])+"원"); //정수형인 가격을 문자열로 20 25 30 35
            this.menuPrice[i].setFont(new Font("고딕체",1, 15));
        }
        menuPrice[0].setBounds(88, 300,100,150);
        menuPrice[1].setBounds(368, 300,100,150);
        menuPrice[2].setBounds(88, 650,100,150);
        menuPrice[3].setBounds(368, 650,100,150);
         for(JLabel lb:menuPrice)mainPanel.add(lb);

         
        groupBtn[5].addActionListener(new ActionListener() { //이전화면
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new First();
            }
        });
        groupBtn[6].addActionListener(new ActionListener() { //결제하기
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuCheck(menuName,seleted_groupName,imgRoot);
            }
        });
        groupBtn[7].addActionListener(new ActionListener() { // 전체취소
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Clear(seleted_groupName);
            }
        });

        groupBtn[0].addActionListener(new ActionListener() {   //그룹 이동
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                new Menu(btnObj.getCoffeeNames(),(btnObj.getbtnArr())[0],btnObj.getCoffeeImgs(),null); 
                                             //그룹 메뉴이름들 그룹이름 이미지들 널
            }
        });
        groupBtn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                 new Menu(btnObj.getSmoothieNames(),(btnObj.getbtnArr())[1],btnObj.getSmoothieImgs(),null);
                
                
            }
        });
        groupBtn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                new Menu(btnObj.getAdeNames(),(btnObj.getbtnArr())[2],btnObj.getAdeImgs(),null);
                
            }
        });
        groupBtn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                 new Menu(btnObj.getJuiceNames(),(btnObj.getbtnArr())[3],btnObj.getJuiceImgs(),null);
                
            }
        });
        groupBtn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                 new Menu(btnObj.getTeaNames(),(btnObj.getbtnArr())[4],btnObj.getTeaImgs(),null);
                
            }
        });
       option[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                new Option(menuName[0],seleted_groupName,imgRoot[0],menuImg[0],btnObj.getPrice()[0]); //메뉴이름  선택된 그룹 이미지 경로 이미지 메뉴 가격
                
            }
        });
         option[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                new Option(menuName[1],seleted_groupName,imgRoot[1],menuImg[1],btnObj.getPrice()[1]);
                
            }
        });
         option[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
               new Option(menuName[2],seleted_groupName,imgRoot[2],menuImg[2],btnObj.getPrice()[2]);
                
            }
        });
         option[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 기존 패널 숨기기
                new Option(menuName[3],seleted_groupName,imgRoot[3],menuImg[3],btnObj.getPrice()[3]);
                
            }
        });

        //기본 설정들
        this.add(mainPanel);
        this.setTitle("메뉴창");
        this.setSize(600,1030);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void setMenuImg(String[] img){
       
        setImgIconArr=new ImageIcon[img.length];
        setImgArr=new Image[img.length];
        for(int i=0;i<setImgIconArr.length;i++){     //이미지 삽입
            setImgIconArr[i]=new ImageIcon(img[i]);
            setImgArr[i]=setImgIconArr[i].getImage();
            menuImg[i]=new JLabel(new ImageIcon (setImgArr[i].getScaledInstance(200,200,Image.SCALE_SMOOTH)));
        }
     }
    
}