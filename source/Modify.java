package source;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Modify extends Menu{
        private JLabel label;
        private JButton del;
        private JButton modify;
        private int[] selectedMenuPrice;
        private int[] selectedMenuCount;
        
        private String[] seletedMenu;
        public Modify(int i,String[] menuName,String groupName,String[] imgRoot,JLabel seletedMenuImg){
        this.setLayout(null);
        
        label=new JLabel("무엇을 수정하시겠습니까?");
        label.setBounds(150, 100,400, 30);
        label.setFont(new Font("고딕체", 1,25));
        this.add(label);

        del=new JButton("삭제");
        modify=new JButton("옵션 변경");
        del.setBounds(60, 400, 200, 100);
        del.setBackground(Color.white);
            
        modify.setBounds(330, 400, 200, 100);
        modify.setBackground(Color.white);
    
        this.add(del);
        this.add(modify);
        this.selectedMenuPrice=super.getSeletedMenuPrice();

        this.seletedMenu=super.getSeletedMenu();
        this.selectedMenuCount=super.getSeletedMenuCount();
        del.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {  
                System.out.println("Modify>>"+Menu.selectedTop);
            	Menu.menuSum-=selectedMenuPrice[i];
            	for(int j=i;j<Menu.selectedTop;j++)seletedMenu[j]=seletedMenu[j+1];
            	for(int j=i;j<Menu.selectedTop;j++)selectedMenuPrice[j]=selectedMenuPrice[j+1];
            	for(int j=i;j<Menu.selectedTop;j++)selectedMenuCount[j]=selectedMenuCount[j+1];
                dispose();
                
                String text=Menu.menuArea.getText();
                String[] lines = text.split("\\n");  // 개행 문자 만나는 거 기준으로 배열에 저장!
                int line_delete = i;
                if (line_delete >= 0 && line_delete < lines.length) {
                    lines[line_delete] = "";
                }
                StringBuilder modifiedText = new StringBuilder(); //StringBuilder는 문자열 삽입,수정,삭제 도와주는 메소드얌
                for (String line : lines) {
                    if (!line.isEmpty()) {
                        modifiedText.append(line).append("\n"); 
                    }
                }
                Menu.menuArea.setText(modifiedText.toString());
                Menu.selectedTop--;
                new Menu(menuName,groupName,imgRoot,null);
            }
        });
            modify.addActionListener(new ActionListener() {   //여기서부터,,
                 @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                   new Option(seletedMenu[i], groupName,imgRoot[i],seletedMenuImg,selectedMenuPrice[i] );
                   menuSum-=selectedMenuPrice[i];
                    for(int j=i;j<Menu.selectedTop;j++)seletedMenu[j]=seletedMenu[j+1];
                    for(int j=i;j<Menu.selectedTop;j++)selectedMenuPrice[j]=selectedMenuPrice[j+1];
                    for(int j=i;j<Menu.selectedTop;j++)selectedMenuCount[j]=selectedMenuCount[j+1];
                    dispose();
                    String text=menuArea.getText();
                    String[] lines = text.split("\\n");  // 개행 문자 만나는 거 기준으로 배열에 저장!
                    int line_delete = i;
                    if (line_delete >= 0 && line_delete < lines.length) {
                        lines[line_delete] = "";
                    }
                    StringBuilder modifiedText = new StringBuilder(); //StringBuilder는 문자열 삽입,수정,삭제 도와주는 메소드얌
                    for (String line : lines) {
                        if (!line.isEmpty()) {
                            modifiedText.append(line).append("\n"); 
                        }
                    }
                    menuArea.setText(modifiedText.toString());
                    Menu.selectedTop--; //안 할 시 수정하고 메뉴로 넘어가게 되면 ++된다
            	
               
            }
        });
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
